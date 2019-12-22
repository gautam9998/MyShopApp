package com.gautam.myshop;


import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }
private RecyclerView categoryRecyclerView;
    private Category_adapter category_adapter;

    //////////


    private ViewPager bannerSliderViewPager;

    private List<slider_model> sliderModelList;
    private  int currentpage=2;
    private Timer timer;
    final private long DELAY_TIME=2000;
    final private long PERIODD_TIME=3000;

    ////////




    ///////////////////////////////*



    private ImageView stripAdImage;
    private ConstraintLayout stripAdContainer;








    /////////////////////////////




/////////////////////**


private TextView horizontalLayoutTitle;
private Button horizontalViewAll;
private RecyclerView horizontalRecyclerView;



///////////////////////**


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home2, container, false);
        categoryRecyclerView=view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(linearLayoutManager);
        List<Category_model> category_modelList=new ArrayList<Category_model>();
        category_modelList.add(new Category_model("link","Home"));
        category_modelList.add(new Category_model("link","Electronics"));
        category_modelList.add(new Category_model("link","Home"));
        category_modelList.add(new Category_model("link","Home"));
        category_modelList.add(new Category_model("link","Home"));
        category_modelList.add(new Category_model("link","Electronics"));
        category_modelList.add(new Category_model("link","Home"));
        category_modelList.add(new Category_model("link","Home"));
        category_modelList.add(new Category_model("link","Home"));
        category_modelList.add(new Category_model("link","Electronics"));
        category_modelList.add(new Category_model("link","Home"));
        category_modelList.add(new Category_model("link","Home"));

        category_adapter=new Category_adapter(category_modelList);
        categoryRecyclerView.setAdapter(category_adapter);
        category_adapter.notifyDataSetChanged();


        ////////////////



        bannerSliderViewPager=view.findViewById(R.id.banner_slider_view_pager);





        sliderModelList =new ArrayList<slider_model>();





        sliderModelList.add(new slider_model(R.drawable.my_rewards,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.search,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.app_icon,"#077AE4"));







        sliderModelList.add(new slider_model(R.drawable.banner,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.profile,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.my_order,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.my_wishlist,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.my_rewards,"#077AE4"));







        sliderModelList.add(new slider_model(R.drawable.search,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.app_icon,"#077AE4"));
        sliderModelList.add(new slider_model(R.drawable.profile,"#077AE4"));

        slider_adapter slider_adapter=new slider_adapter(sliderModelList);

        bannerSliderViewPager.setAdapter(slider_adapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);


        bannerSliderViewPager.setCurrentItem(currentpage);
        ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentpage=position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state==ViewPager.SCROLL_STATE_IDLE)
                {
                    pageLooper();
                }

            }
        };


        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

        startbannerslideshow();
        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pageLooper();
                stopbannerslideshow();
                if(event.getAction()==MotionEvent.ACTION_UP)
                {
                    startbannerslideshow();
                }
                return false;
            }
        });
        ////////////






        ///////////////////////////////*


stripAdImage=view.findViewById(R.id.strip_ad_image);
stripAdContainer=view.findViewById(R.id.strip_ad_container);






stripAdImage.setImageResource(R.drawable.banner);
stripAdContainer.setBackgroundColor(Color.parseColor("#000000"));






        ///////////////////////////////*





















        //////////////////**




horizontalLayoutTitle=view.findViewById(R.id.horizontal_scroll_layout_title);
horizontalViewAll=view.findViewById(R.id.horizontal_scroll_viewall_button);
horizontalRecyclerView=view.findViewById(R.id.horizontal_scroll_layout_recyclerview);

List<horizontal_product_scroll_model> horizontalProductScrollModelList=new ArrayList<>();
horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.profile,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.my_rewards,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.app_icon,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.my_wishlist,"Iphone 11 ","Triple camera","Rs 100000"));
        horizontalProductScrollModelList.add(new horizontal_product_scroll_model(R.drawable.shopping,"Iphone 11 ","Triple camera","Rs 100000"));



        horizontal_product_scroll_adapter horizontal_product_scroll_adapter=new horizontal_product_scroll_adapter(horizontalProductScrollModelList);

        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
horizontalRecyclerView.setLayoutManager(linearLayoutManager1);
horizontalRecyclerView.setAdapter(horizontal_product_scroll_adapter);
horizontal_product_scroll_adapter.notifyDataSetChanged();




//////////////////***




        TextView gridLayoutTitle=view.findViewById(R.id.grid_product_layout_title);
        Button gridLayoutViewallbutton=view.findViewById(R.id.grid_product_layout_viewall_button);
        GridView gridView=view.findViewById(R.id.grid_product_layout_gridview);


        gridView.setAdapter(new GridProductLayoutAdapter(horizontalProductScrollModelList));


        //////////////////***




        //////////////////**


        return view;
    }




    ///////////////





    private void pageLooper(){
        if(currentpage==sliderModelList.size()-2)
        {
            currentpage=2;
            bannerSliderViewPager.setCurrentItem(currentpage,false);
        }



        if(currentpage==1)
        {
            currentpage=sliderModelList.size()-3;
            bannerSliderViewPager.setCurrentItem(currentpage,false);
        }

    }


    private  void startbannerslideshow(){
        final Handler handler =new Handler();
        final Runnable runnable=new Runnable() {
            @Override
            public void run() {
                if(currentpage>=sliderModelList.size()){
                    currentpage=1;
                }
                bannerSliderViewPager.setCurrentItem(currentpage++,true);
            }
        };
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },DELAY_TIME,PERIODD_TIME);
    }


    private void stopbannerslideshow()
    {
        timer.cancel();
    }

    /////////

}
