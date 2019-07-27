package com.ajithvgiri.gridphoto.Assymetric;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AsymmetricRecyclerView extends RecyclerView {
  private final AsymmetricViewImpl viewImpl;
  private AsymmetricRecyclerViewAdapter<?> adapter;

  public AsymmetricRecyclerView(Context context, AttributeSet attrs) {
    super(context, attrs);
    viewImpl = new AsymmetricViewImpl(context);
    setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));

    final ViewTreeObserver vto = getViewTreeObserver();
    if (vto != null) {
      vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
          //noinspection deprecation
          getViewTreeObserver().removeGlobalOnLayoutListener(this);
          viewImpl.determineColumns(getAvailableSpace());
          if (adapter != null) {
            adapter.recalculateItemsPerRow();
          }
        }
      });
    }
  }

  @Override
  public void setAdapter(@NonNull Adapter adapter) {
    if (!(adapter instanceof AsymmetricRecyclerViewAdapter)) {
      throw new UnsupportedOperationException(
              "Adapter must be an instance of AsymmetricRecyclerViewAdapter");
    }

    this.adapter = (AsymmetricRecyclerViewAdapter<?>) adapter;
    super.setAdapter(adapter);

    this.adapter.recalculateItemsPerRow();
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    viewImpl.determineColumns(getAvailableSpace());
  }


  private int getAvailableSpace() {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }


  public void setRequestedColumnCount(int requestedColumnCount) {
    viewImpl.setRequestedColumnCount(requestedColumnCount);
  }

  public void setRequestedHorizontalSpacing(int spacing) {
    viewImpl.setRequestedHorizontalSpacing(spacing);
  }

  public void setDebugging(boolean debugging) {
    viewImpl.setDebugging(debugging);
  }
}

