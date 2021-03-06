package com.gautam.myshop;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import io.paperdb.Paper;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private FrameLayout frameLayout;
    private static final int HOME_FRAGMENT=0;
    private static final int CART_FRAGMENT=3;

    private static final int ORDERS_FRAGMENT=1;
    private static final int REWARDS_FRAGMENT=4;

    private static final int ACCOUNT_FRAGMENT=5;
    private  NavigationView navigationView;
    private ImageView actionBarLogo;
   private Toolbar toolbar;

    private static int currentFragment;
    private Window window;



    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {






        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        window= getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        actionBarLogo=findViewById(R.id.actionbar_logo);
        frameLayout=findViewById(R.id.main_framelayout);
        setFragment(new HomeFragment(),HOME_FRAGMENT);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(HomeActivity.this,drawer,toolbar,0,0);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(HomeActivity.this);
        //navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.getMenu().getItem(3).setChecked(false);


        // AdView adView=new AdView(this);


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //  mAppBarConfiguration = new AppBarConfiguration.Builder(
        //    R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
        //  R.id.nav_tools, R.id.nav_share, R.id.nav_send)
        //    .setDrawerLayout(drawer)
        //  .build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        // NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if(currentFragment==HOME_FRAGMENT) {
            getMenuInflater().inflate(R.menu.home, menu);


        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {


        int id=item.getItemId();
        if(id==R.id.main_search_icon)
        {
            return true;
        }
        else if(id==R.id.main_notification_icon)
        {
            return true;
        }

        else if(id==R.id.main_cart_icon)
        {
            myCart();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void myCart() {
        actionBarLogo.setVisibility(View.GONE);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("MY CART");
        invalidateOptionsMenu();
        setFragment(new MyCartFragment(),CART_FRAGMENT);
        navigationView.getMenu().getItem(3).setChecked(true);
        navigationView.getMenu().getItem(0).setChecked(false);
    }





    private void myOrder() {
        actionBarLogo.setVisibility(View.GONE);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("MY ORDER");
        invalidateOptionsMenu();
        setFragment(new myOrderFragment(),ORDERS_FRAGMENT);
        navigationView.getMenu().getItem(1).setChecked(true);
        navigationView.getMenu().getItem(0).setChecked(false);
    }




    public boolean onNavigationItemSelected(MenuItem item)
    {

        int id=item.getItemId();



        if(id==R.id.my_mall)

        {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            actionBarLogo.setVisibility(View.VISIBLE);
            invalidateOptionsMenu();
            setFragment(new HomeFragment(),HOME_FRAGMENT);
            navigationView.getMenu().getItem(0).setChecked(true);
            navigationView.getMenu().getItem(3).setChecked(false);
        }

        else if(id==R.id.my_order)
        {
            myOrder();
        }

        else if(id==R.id.my_rewards)
        {
             gotoFragment("My Rewards ",new MyRewardsFragment(),REWARDS_FRAGMENT);
        }
        else if(id==R.id.my_cart)
        {
            myCart();
        }

        else if(id==R.id.my_whishlist)
        {

        }
        else if(id==R.id.my_account)
        {
            gotoFragment("My Account ",new MyAccountFragment(),ACCOUNT_FRAGMENT);

        }
        else if(id==R.id.my_signout)
        {
            Intent intent = new Intent(HomeActivity.this, Main2Activity.class);
            startActivity(intent);

            Paper.book().destroy();


        }
        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
    private void setFragment(Fragment fragment, int fragmentNo)
    {
        if(fragmentNo !=currentFragment) {
            if(fragmentNo== REWARDS_FRAGMENT){
                window.setStatusBarColor(Color.parseColor("#52B04B1"));
                toolbar.setBackgroundColor(Color.parseColor("#52B04B1"));

            }else{
                window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            currentFragment = fragmentNo;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            fragmentTransaction.replace(frameLayout.getId(), fragment);
            fragmentTransaction.commit();
        }

    }
    private void gotoFragment(String title ,Fragment fragment,int fragmentNO)
    {
        actionBarLogo.setVisibility(View.GONE);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
        invalidateOptionsMenu();
        setFragment(fragment,fragmentNO);
        if(fragmentNO==CART_FRAGMENT)
        {
            navigationView.getMenu().getItem(3).setChecked(true);
        }
    }










}
