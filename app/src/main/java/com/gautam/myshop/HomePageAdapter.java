package com.gautam.myshop;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class HomePageAdapter extends RecyclerView.Adapter {


    private List<HomePageModel> homePageModelList;

    public HomePageAdapter(List<HomePageModel> homePageModelList) {
        this.homePageModelList = homePageModelList;
    }


    @Override
    public int getItemViewType(int position) {
        switch (homePageModelList.get(position).getType()) {
            case 0:
                return HomePageModel.BANNERSLIDER;
            case 1:
                return HomePageModel.STRIP_AD_BANNER;
            case 2:
                return HomePageModel.HORIZONTAL_PRODUCT_VIEW;
            case 3:
                return HomePageModel.GRID_PRODUCT_VIEW;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case HomePageModel.BANNERSLIDER:
                View bannerSliderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sliding_ad_layout, parent, false);
                return new BannerSliderViewHolder(bannerSliderView);
            case HomePageModel.STRIP_AD_BANNER:
                View stripAdView = LayoutInflater.from(parent.getContext()).inflate(R.layout.strip_ad_layout, parent, false);
                return new StripAdBnnerViewHolder(stripAdView);
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                View horizontalProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_layout, parent, false);
                return new HorizontalProductViewHolder(horizontalProductView);
            case HomePageModel.GRID_PRODUCT_VIEW:
                View gridProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_product_layout, parent, false);
                return new GridProdctViewHolder(gridProductView);

            default:
                return null;
        }
        // return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (homePageModelList.get(position).getType()) {
            case HomePageModel.BANNERSLIDER:
                List<slider_model> sliderModelList = homePageModelList.get(position).getSliderModelList();
                ((BannerSliderViewHolder) holder).setBannerSliderViewPager(sliderModelList);
                break;
            case HomePageModel.STRIP_AD_BANNER:
                int resource = homePageModelList.get(position).getResource();
                String color = homePageModelList.get(position).getBackgroungColor();

                ((StripAdBnnerViewHolder) holder).setStripAd(resource, color);
                break;
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                String horizontalLayoutTitle=homePageModelList.get(position).getTitle();
                List<horizontal_product_scroll_model> horizontalProductScrollModelList=homePageModelList.get(position).getHorizontalProductScrollModelList();
                ((HorizontalProductViewHolder)holder).setHorizontalProductLayout(horizontalProductScrollModelList,horizontalLayoutTitle);


                break;
            case HomePageModel.GRID_PRODUCT_VIEW:
                String gridLayoutTitle=homePageModelList.get(position).getTitle();
                List<horizontal_product_scroll_model> gridProductScrollModelList=homePageModelList.get(position).getHorizontalProductScrollModelList();
                ((GridProdctViewHolder)holder).setGridProductLayout(gridProductScrollModelList,gridLayoutTitle);


                break;
            default:
                return;
        }

    }

    @Override
    public int getItemCount() {
        return homePageModelList.size();
    }


    public class BannerSliderViewHolder extends RecyclerView.ViewHolder {


        private ViewPager bannerSliderViewPager;

        // private List<slider_model> sliderModelList;
        private int currentpage = 2;
        private Timer timer;
        final private long DELAY_TIME = 2000;
        final private long PERIODD_TIME = 2000;

        public BannerSliderViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerSliderViewPager = itemView.findViewById(R.id.banner_slider_view_pager);


        }

        private void setBannerSliderViewPager(final List<slider_model> sliderModelList) {

            slider_adapter slider_adapter = new slider_adapter(sliderModelList);

            bannerSliderViewPager.setAdapter(slider_adapter);
            bannerSliderViewPager.setClipToPadding(false);
            bannerSliderViewPager.setPageMargin(20);


            bannerSliderViewPager.setCurrentItem(currentpage);
            ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    currentpage = position;

                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    if (state == ViewPager.SCROLL_STATE_IDLE) {
                        pageLooper(sliderModelList);
                    }

                }
            };


            bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

            startbannerslideshow(sliderModelList);
            bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    pageLooper(sliderModelList);
                    stopbannerslideshow();
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        startbannerslideshow(sliderModelList);
                    }
                    return false;
                }
            });
        }

        private void pageLooper(List<slider_model> sliderModelList) {
            if (currentpage == sliderModelList.size() - 2) {
                currentpage = 2;
                bannerSliderViewPager.setCurrentItem(currentpage, false);
            }


            if (currentpage == 1) {
                currentpage = sliderModelList.size() - 3;
                bannerSliderViewPager.setCurrentItem(currentpage, false);
            }

        }


        private void startbannerslideshow(final List<slider_model> sliderModelList) {
            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if (currentpage >= sliderModelList.size()) {
                        currentpage = 1;
                    }
                    bannerSliderViewPager.setCurrentItem(currentpage++, true);
                }
            };
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(runnable);
                }
            }, DELAY_TIME, PERIODD_TIME);
        }


        private void stopbannerslideshow() {
            timer.cancel();
        }


    }

    public class StripAdBnnerViewHolder extends RecyclerView.ViewHolder {

        private ImageView stripAdImage;
        private ConstraintLayout stripAdContainer;

        public StripAdBnnerViewHolder(@NonNull View itemView) {
            super(itemView);


            stripAdImage = itemView.findViewById(R.id.strip_ad_image);
            stripAdContainer = itemView.findViewById(R.id.strip_ad_container);


        }

        private void setStripAd(int resource, String color) {

            stripAdImage.setImageResource(resource);
            stripAdContainer.setBackgroundColor(Color.parseColor(color));
        }
    }

    public class HorizontalProductViewHolder extends RecyclerView.ViewHolder {

        private TextView horizontalLayoutTitle;
        private Button horizontalViewAll;
        private RecyclerView horizontalRecyclerView;


        public HorizontalProductViewHolder(@NonNull View itemView) {
            super(itemView);

            horizontalLayoutTitle = itemView.findViewById(R.id.horizontal_scroll_layout_title);
            horizontalViewAll = itemView.findViewById(R.id.horizontal_scroll_viewall_button);
            horizontalRecyclerView = itemView.findViewById(R.id.horizontal_scroll_layout_recyclerview);
        }


        private void setHorizontalProductLayout(List<horizontal_product_scroll_model> horizontalProductScrollModelList,String title) {

            horizontalLayoutTitle.setText(title);
            if(horizontalProductScrollModelList.size()>8){
                horizontalViewAll.setVisibility(View.VISIBLE);
                horizontalViewAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(itemView.getContext(),ViewAllActivity.class);
                        intent.putExtra("layout_code",0);
                        itemView.getContext().startActivity(intent);
                    }
                });
            }
            else {
                horizontalViewAll.setVisibility(View.INVISIBLE);
            }
            horizontal_product_scroll_adapter horizontal_product_scroll_adapter = new horizontal_product_scroll_adapter(horizontalProductScrollModelList);

            LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
            horizontalRecyclerView.setLayoutManager(linearLayoutManager1);
            horizontalRecyclerView.setAdapter(horizontal_product_scroll_adapter);
            horizontal_product_scroll_adapter.notifyDataSetChanged();


        }
    }





    public class GridProdctViewHolder extends RecyclerView.ViewHolder{

        private   TextView gridLayoutTitle;
private Button gridLayoutViewallbutton;
        private GridView gridView;
        public GridProdctViewHolder(@NonNull View itemView) {
            super(itemView);


            gridLayoutTitle=itemView.findViewById(R.id.grid_product_layout_title);
            gridLayoutViewallbutton=itemView.findViewById(R.id.grid_product_layout_viewall_button);
             gridView=itemView.findViewById(R.id.grid_product_layout_gridview);
        }
        private void setGridProductLayout(List<horizontal_product_scroll_model>horizontalProductScrollModelList,String title){
            gridLayoutTitle.setText(title);
            gridView.setAdapter(new GridProductLayoutAdapter(horizontalProductScrollModelList));
            gridLayoutViewallbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent intent=new Intent(itemView.getContext(),ViewAllActivity.class);
                    intent.putExtra("layout_code",1);
                    itemView.getContext().startActivity(intent);

                }
            });

        }
    }
}
