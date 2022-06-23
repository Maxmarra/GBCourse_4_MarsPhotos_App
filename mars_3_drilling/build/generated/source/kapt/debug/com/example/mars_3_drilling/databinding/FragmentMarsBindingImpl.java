package com.example.mars_3_drilling.databinding;
import com.example.mars_3_drilling.R;
import com.example.mars_3_drilling.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentMarsBindingImpl extends FragmentMarsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentMarsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private FragmentMarsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (androidx.recyclerview.widget.RecyclerView) bindings[1]
            , (android.widget.ImageView) bindings[2]
            );
        this.fragmentRecyclerview.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.statusImage.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewmodel == variableId) {
            setViewmodel((com.example.mars_3_drilling.viewmodel.MarsViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewmodel(@Nullable com.example.mars_3_drilling.viewmodel.MarsViewModel Viewmodel) {
        this.mViewmodel = Viewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewmodel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewmodelPhotos((androidx.lifecycle.LiveData<java.util.List<com.example.mars_3_drilling.network.MarsPhoto>>) object, fieldId);
            case 1 :
                return onChangeViewmodelStatus((androidx.lifecycle.LiveData<com.example.mars_3_drilling.viewmodel.ConnectionStatus>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewmodelPhotos(androidx.lifecycle.LiveData<java.util.List<com.example.mars_3_drilling.network.MarsPhoto>> ViewmodelPhotos, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelStatus(androidx.lifecycle.LiveData<com.example.mars_3_drilling.viewmodel.ConnectionStatus> ViewmodelStatus, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        androidx.lifecycle.LiveData<java.util.List<com.example.mars_3_drilling.network.MarsPhoto>> viewmodelPhotos = null;
        androidx.lifecycle.LiveData<com.example.mars_3_drilling.viewmodel.ConnectionStatus> viewmodelStatus = null;
        java.util.List<com.example.mars_3_drilling.network.MarsPhoto> viewmodelPhotosGetValue = null;
        com.example.mars_3_drilling.viewmodel.MarsViewModel viewmodel = mViewmodel;
        com.example.mars_3_drilling.viewmodel.ConnectionStatus viewmodelStatusGetValue = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.photos
                        viewmodelPhotos = viewmodel.getPhotos();
                    }
                    updateLiveDataRegistration(0, viewmodelPhotos);


                    if (viewmodelPhotos != null) {
                        // read viewmodel.photos.getValue()
                        viewmodelPhotosGetValue = viewmodelPhotos.getValue();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.status
                        viewmodelStatus = viewmodel.getStatus();
                    }
                    updateLiveDataRegistration(1, viewmodelStatus);


                    if (viewmodelStatus != null) {
                        // read viewmodel.status.getValue()
                        viewmodelStatusGetValue = viewmodelStatus.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            com.example.mars_3_drilling.adapters.BindingAdaptersKt.bindGridAdapter(this.fragmentRecyclerview, viewmodelPhotosGetValue);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            com.example.mars_3_drilling.adapters.BindingAdaptersKt.bindStatus(this.statusImage, viewmodelStatusGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewmodel.photos
        flag 1 (0x2L): viewmodel.status
        flag 2 (0x3L): viewmodel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}