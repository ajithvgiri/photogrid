package com.ajithvgiri.gridphoto;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.ajithvgiri.gridphoto.assymetric.AsymmetricRecyclerView;
import com.ajithvgiri.gridphoto.assymetric.AsymmetricRecyclerViewAdapter;
import com.ajithvgiri.gridphoto.assymetric.Utils;
import com.ajithvgiri.gridphoto.model.ItemImage;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    public String Image1 = "https://homepages.cae.wisc.edu/~ece533/images/airplane.png";
    public String Image2 = "https://homepages.cae.wisc.edu/~ece533/images/airplane.png";
    public String Image3 = "https://homepages.cae.wisc.edu/~ece533/images/airplane.png";
    public String Image4 = "https://homepages.cae.wisc.edu/~ece533/images/airplane.png";

    int currentOffset = 0;
    int mMaxDisplay_Size = 2;
    int mTotal_Size = 0;

    ArrayList<ItemImage> Pathitems = new ArrayList<>();
    //private List<ItemList> mItemList = new ArrayList<>();


    public AsymmetricRecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_view);


        recyclerView = (AsymmetricRecyclerView) findViewById(R.id.recyclerView);


        recyclerView.setRequestedColumnCount(3);
        recyclerView.setDebugging(true);
        recyclerView.setRequestedHorizontalSpacing(Utils.dpToPx(this, 3));
        recyclerView.addItemDecoration(new SpacesItemDecoration(getResources().getDimensionPixelSize(R.dimen.recycler_padding)));





        prepareMovieData(0);




    }


    private void prepareMovieData(int k) {


        ArrayList<ItemImage> mPathitems = new ArrayList<>();
        boolean isCol2Avail = false;

        ItemImage i1 = new ItemImage(1,Image1,Image1);

        i1.setColumnSpan(2);
        i1.setRowSpan(3);
        i1.setPosition( currentOffset + 0);

        ItemImage i2 = new ItemImage(2,Image2,Image2);
        i2.setColumnSpan(1);
        i2.setRowSpan(3);
        i2.setPosition( currentOffset + 1);


        ItemImage i3 = new ItemImage(3,Image3,Image3);
        i3.setColumnSpan(1);
        i3.setRowSpan(1);
        i3.setPosition( currentOffset + 2);

        ItemImage i4 = new ItemImage(4,Image4,Image4);
        int colSpan4 = Math.random() < 0.2f ? 2 : 1;
        if(colSpan4 == 2 && !isCol2Avail)
            isCol2Avail = true;
        else if(colSpan4 == 2 && isCol2Avail)
            colSpan4 = 1;

        int rowSpan4 = colSpan4;
        i4.setColumnSpan(colSpan4);
        i4.setRowSpan(rowSpan4);
        i4.setPosition( currentOffset + 3);

        ItemImage i5 = new ItemImage(5,Image1,Image1);
        int colSpan5 = Math.random() < 0.2f ? 2 : 1;
        if(colSpan5 == 2 && !isCol2Avail)
            isCol2Avail = true;
        else if(colSpan5 == 2 && isCol2Avail)
            colSpan5 = 1;

        int rowSpan5 = colSpan5;
        i5.setColumnSpan(colSpan5);
        i5.setRowSpan(rowSpan5);
        i5.setPosition( currentOffset + 4);

        ItemImage i6 = new ItemImage(6,Image2,Image2);
        int colSpan6 = Math.random() < 0.2f ? 2 : 1;

        if(colSpan6 == 2 && !isCol2Avail)
            isCol2Avail = true;
        else if(colSpan6 == 2 && isCol2Avail)
            colSpan6 = 1;

        int rowSpan6 = colSpan6;
        i6.setColumnSpan(colSpan6);
        i6.setRowSpan(rowSpan6);
        i6.setPosition( currentOffset + 5);

        ItemImage i7 = new ItemImage(7,Image3,Image3);
        int colSpan7 = Math.random() < 0.2f ? 2 : 1;
        if(colSpan7 == 2 && !isCol2Avail)
            isCol2Avail = true;
        else if(colSpan7 == 2 && isCol2Avail)
            colSpan7 = 1;

        int rowSpan7 = colSpan7;
        i7.setColumnSpan(colSpan7);
        i7.setRowSpan(rowSpan7);
        i7.setPosition( currentOffset + 6);

        ItemImage i8 = new ItemImage(8,Image4,Image4);
        int colSpan8 = Math.random() < 0.2f ? 2 : 1;
        if(colSpan8 == 2 && !isCol2Avail)
            isCol2Avail = true;
        else if(colSpan8 == 2 && isCol2Avail)
            colSpan8 = 1;

        int rowSpan8 = colSpan8;
        i8.setColumnSpan(colSpan8);
        i8.setRowSpan(rowSpan8);
        i8.setPosition( currentOffset + 7);

        ItemImage i9 = new ItemImage(9,Image2,Image2);
        int colSpan9 = Math.random() < 0.2f ? 2 : 1;
        if(colSpan9 == 2 && !isCol2Avail)
            isCol2Avail = true;
        else if(colSpan9 == 2 && isCol2Avail)
            colSpan9 = 1;

        int rowSpan9 = colSpan9;
        i9.setColumnSpan(colSpan9);
        i9.setRowSpan(rowSpan9);
        i9.setPosition( currentOffset + 8);


        Pathitems.clear();

        Pathitems.add(i1);
        Pathitems.add(i2);
//        Pathitems.add(i3);
//        Pathitems.add(i4);
//        Pathitems.add(i5);
//        Pathitems.add(i6);
//        Pathitems.add(i7);
//        Pathitems.add(i8);
//        Pathitems.add(i9);

        for(int i = 0; i < mMaxDisplay_Size;i++)
        {

            mPathitems.add(Pathitems.get(i));
        }

        //ItemList itemList = new ItemList(k,"User "+(k+1),mPathitems);
        //mItemList.add(itemList);
        currentOffset += mPathitems.size();


        mTotal_Size = Pathitems.size();


        ChildAdapter adapter = new ChildAdapter(mPathitems, mMaxDisplay_Size, mTotal_Size,this);
        recyclerView.setAdapter(new AsymmetricRecyclerViewAdapter<>(this, recyclerView, adapter));

    }
}
