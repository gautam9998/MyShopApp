package com.gautam.myshop;

import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
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
                    int resource =homePageModelList.get(position).getResource();
                    String color =homePageModelList.get(position).getBackgroungColor();

((StripAdBnnerViewHolder)holder).setStripAd(resource,color);
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

    public class StripAdBnnerViewHolder extends RecyclerView.ViewHolder{

        private ImageView stripAdImage;
        private ConstraintLayout stripAdContainer;

        public StripAdBnnerViewHolder(@NonNull View itemView) {
            super(itemView);


            stripAdImage=itemView.findViewById(R.id.strip_ad_image);
            stripAdContainer=itemView.findViewById(R.id.strip_ad_container);



        }
        private void setStripAd(int resource,String color){

            stripAdImage.setImageResource(resource);
            stripAdContainer.setBackgroundColor(Color.parseColor(color));
        }
    }
}
