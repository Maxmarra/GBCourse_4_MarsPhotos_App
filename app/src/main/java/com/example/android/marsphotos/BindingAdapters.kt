package com.example.android.marsphotos

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android.marsphotos.domain.WeatherUnited
import com.example.android.marsphotos.network.Container
import com.example.android.marsphotos.network.DataList
import com.example.android.marsphotos.overview.WeatherApiStatus
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()

        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<WeatherUnited>?) {
    val adapter = recyclerView.adapter as WeatherAdapter
    adapter.submitList(data)
}

@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView,
               status: WeatherApiStatus?) {

    when (status) {
        WeatherApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        WeatherApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        WeatherApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }

}

@BindingAdapter("unixTime")
fun convertFromUnix(textView: TextView, unix: Long){
    textView.text = SimpleDateFormat("E MMM d y", Locale.getDefault()).format(
        Date(unix * 1000)
    )
}

//@BindingAdapter("dateTime")
//    fun convertToTime(textView: TextView, time: Long){
//       val formatter = SimpleDateFormat("E MMM d y", Locale.getDefault())
//       textView.text = formatter.format(time)

//    // define once somewhere in order to reuse it
//    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//
//// JVM representation of a millisecond epoch absolute instant
//    val instant = Instant.ofEpochMilli(time)
//
//// Adding the timezone information to be able to format it (change accordingly)
//    val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
//    textView.text = date.toString()
//

    //println(formatter.format(date)) // 10/12/2019 06:35:45
 //   }


