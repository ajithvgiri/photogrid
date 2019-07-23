package com.ajithvgiri.gridphoto;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.ajithvgiri.gridphoto.Assymetric.AGVRecyclerViewAdapter;
import com.ajithvgiri.gridphoto.Assymetric.AsymmetricItem;
import com.ajithvgiri.gridphoto.model.ItemImage;
import com.bumptech.glide.Glide;

import java.util.List;

class ChildAdapter extends AGVRecyclerViewAdapter<ViewHolder> {
    private final List<ItemImage> items;
    private int mDisplay = 0;
    private int mTotal = 0;
    Context context;

    public ChildAdapter(List<ItemImage> items, int mDisplay, int mTotal, Context context) {
      this.items = items;
      this.mDisplay = mDisplay;
        this.mTotal = mTotal;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      Log.d("RecyclerViewActivity", "onCreateView");
      return new ViewHolder(parent, viewType,items);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
      Log.d("RecyclerViewActivity", "onBindView position=" + position);
      holder.bind(items,position,mDisplay,mTotal,context);
    }

    @Override
    public int getItemCount() {
      return items.size();
    }

    @Override
    public AsymmetricItem getItem(int position) {
      return (AsymmetricItem) items.get(position);
    }

    @Override
    public int getItemViewType(int position) {
      return position % 2 == 0 ? 1 : 0;
    }


  }

class ViewHolder extends RecyclerView.ViewHolder {
    private final ImageView mImageView;
    private final TextView textView;

    public ViewHolder(ViewGroup parent, int viewType, List<ItemImage> items) {
        super(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_item, parent, false));

        mImageView = (ImageView) itemView.findViewById(R.id.mImageView);
        textView = (TextView) itemView.findViewById(R.id.tvCount);



    }


    public void bind(List<ItemImage> item, int position, int mDisplay, int mTotal,Context context) {
        //TODO: Image Loader
        //ImageLoader.getInstance().displayImage(String.valueOf(item.get(position).getImagePath()), mImageView);

//        mImageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_launcher));

        Glide.with(context).load(String.valueOf(item.get(position).getImagePath())).dontAnimate().into(mImageView);
//


        Log.d("ChildAdapter","position ---------------- "+position);
        Log.d("ChildAdapter","setColumnSpan "+item.get(position).getColumnSpan());
        Log.d("ChildAdapter","setRowSpan "+item.get(position).getColumnSpan());
        Log.d("ChildAdapter","setPosition "+item.get(position).getPosition());
        textView.setText("+"+(mTotal-mDisplay));
        if(mTotal > mDisplay)
        {
            if(position  == mDisplay-1) {
                textView.setVisibility(View.VISIBLE);
                mImageView.setAlpha(72);
                mImageView.setOnClickListener(view -> {
                    Log.d("ChildAdapter","setOnClickListener alpha72");
                });
            }
            else {
                textView.setVisibility(View.INVISIBLE);
                mImageView.setAlpha(255);
                mImageView.setOnClickListener(view -> {
                    Log.d("ChildAdapter","setOnClickListener alpha255");
                });
            }
        }
        else
        {
            mImageView.setAlpha(255);
            textView.setVisibility(View.INVISIBLE);
        }

        mImageView.setOnClickListener(view -> {
            Log.d("ChildAdapter","setOnClickListener");
        });

        // textView.setText(String.valueOf(item.getPosition()));
    }
}

