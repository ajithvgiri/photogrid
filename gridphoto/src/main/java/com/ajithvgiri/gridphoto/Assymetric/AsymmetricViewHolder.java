package com.ajithvgiri.gridphoto.Assymetric;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class AsymmetricViewHolder<VH extends RecyclerView.ViewHolder>
    extends RecyclerView.ViewHolder {
  final VH wrappedViewHolder;

  public AsymmetricViewHolder(VH wrappedViewHolder) {
    super(wrappedViewHolder.itemView);
    this.wrappedViewHolder = wrappedViewHolder;
  }

  public AsymmetricViewHolder(View view) {
    super(view);
    wrappedViewHolder = null;
  }
}
