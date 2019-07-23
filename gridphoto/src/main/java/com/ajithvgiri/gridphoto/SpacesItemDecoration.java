package com.ajithvgiri.gridphoto;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
  private final int padding;

  public SpacesItemDecoration(int padding) {
    this.padding = padding;
  }

  @Override
  public void getItemOffsets(
          Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
    outRect.bottom = padding;
  }
}