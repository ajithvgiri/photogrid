package com.ajithvgiri.gridphoto.assymetric;

import android.os.Parcelable;

public interface AsymmetricItem extends Parcelable {
  int getColumnSpan();
  int getRowSpan();
}
