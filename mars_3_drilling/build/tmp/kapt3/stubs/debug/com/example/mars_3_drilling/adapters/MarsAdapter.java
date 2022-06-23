package com.example.mars_3_drilling.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/example/mars_3_drilling/adapters/MarsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/example/mars_3_drilling/network/MarsPhoto;", "Lcom/example/mars_3_drilling/adapters/MarsAdapter$MarsViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DiffCall", "MarsViewHolder", "mars_3_drilling_debug"})
public final class MarsAdapter extends androidx.recyclerview.widget.ListAdapter<com.example.mars_3_drilling.network.MarsPhoto, com.example.mars_3_drilling.adapters.MarsAdapter.MarsViewHolder> {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.mars_3_drilling.adapters.MarsAdapter.DiffCall DiffCall = null;
    
    public MarsAdapter() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.mars_3_drilling.adapters.MarsAdapter.MarsViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.mars_3_drilling.adapters.MarsAdapter.MarsViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/example/mars_3_drilling/adapters/MarsAdapter$MarsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/mars_3_drilling/databinding/ItemLayoutBinding;", "(Lcom/example/mars_3_drilling/databinding/ItemLayoutBinding;)V", "getBinding", "()Lcom/example/mars_3_drilling/databinding/ItemLayoutBinding;", "bind", "", "marsPhoto", "Lcom/example/mars_3_drilling/network/MarsPhoto;", "mars_3_drilling_debug"})
    public static final class MarsViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.mars_3_drilling.databinding.ItemLayoutBinding binding = null;
        
        public MarsViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.mars_3_drilling.databinding.ItemLayoutBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.mars_3_drilling.databinding.ItemLayoutBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.mars_3_drilling.network.MarsPhoto marsPhoto) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/example/mars_3_drilling/adapters/MarsAdapter$DiffCall;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/example/mars_3_drilling/network/MarsPhoto;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "mars_3_drilling_debug"})
    public static final class DiffCall extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.mars_3_drilling.network.MarsPhoto> {
        
        private DiffCall() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.example.mars_3_drilling.network.MarsPhoto oldItem, @org.jetbrains.annotations.NotNull()
        com.example.mars_3_drilling.network.MarsPhoto newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.example.mars_3_drilling.network.MarsPhoto oldItem, @org.jetbrains.annotations.NotNull()
        com.example.mars_3_drilling.network.MarsPhoto newItem) {
            return false;
        }
    }
}