package com.example.lorrynwinsh.Gui;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lorrynwinsh.DataModels.MenuItemModel;
import com.example.lorrynwinsh.Fragments.HomeFragment;
import com.example.lorrynwinsh.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DisplayRoute extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView userNameTextView, phoneNumberTv;
    CircleImageView userProfileImageView;
    public TextView toolBarTitleTextView;
    public ImageView settingsBtn, homeMenuButton, homeBackButton;
    RecyclerView menuItemsRV;
    private LinearLayoutManager mLinearLayoutManager;
    MenuItemsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_route);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolBarTitleTextView = (TextView) toolbar.findViewById(R.id.toolbar_title_tv);
        toolBarTitleTextView.setText("Select Pickup Location");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout1, HomeFragment.newInstance(), "HomeFragment").commit();
        }

        menuItemsRV = (RecyclerView) navigationView.findViewById(R.id.main_menu_rv);

        mLinearLayoutManager = new LinearLayoutManager(DisplayRoute.this);
        menuItemsRV.setLayoutManager(mLinearLayoutManager);

        populateMenuItems();

        settingsBtn = (ImageView) navigationView.findViewById(R.id.settings_icon);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout1, SettingsFragment.newInstance(), "SettingsFragment").commit();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        homeMenuButton = (ImageView) toolbar.findViewById(R.id.btnMenuHome);
        homeBackButton = (ImageView) toolbar.findViewById(R.id.btnBackMenu);

        homeMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        homeBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeMenuButton.setVisibility(View.VISIBLE);
                homeBackButton.setVisibility(View.GONE);
                toolBarTitleTextView.setText("Select Pickup Location");
                onBackPressed();
            }
        });


    }

    private void populateMenuItems(){
        ArrayList<MenuItemModel> list = new ArrayList();
        MenuItemModel item1 = new MenuItemModel(R.drawable.ic_room_black_24dp,"Home");
        MenuItemModel item2 = new MenuItemModel(R.drawable.ic_bookmark_black_24dp,"Bookings");
        MenuItemModel item3 = new MenuItemModel(R.drawable.ic_payment_black_24dp,"Payments");
        MenuItemModel item4 = new MenuItemModel(R.drawable.ic_bubble_chart_black_24dp,"Contact Us");
        MenuItemModel item5 = new MenuItemModel(0,"About Us");
        MenuItemModel item6 = new MenuItemModel(0,"Privacy Policy");
        MenuItemModel item7 = new MenuItemModel(0,"Log Out");

        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);
        list.add(item6);
        list.add(item7);

        adapter = new MenuItemsAdapter(list);
        menuItemsRV.setAdapter(adapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    private class MenuItemsAdapter extends RecyclerView.Adapter<MenuItemsAdapter.ViewHolder>{

        private ArrayList<MenuItemModel> dataList;

        public MenuItemsAdapter(ArrayList<MenuItemModel> list){
            dataList = list;

        }

        @Override
        public MenuItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item_layout, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MenuItemsAdapter.ViewHolder holder, int position) {
            final MenuItemModel model = dataList.get(position);
            if (model.getItemName().equalsIgnoreCase("About Us")
                    || model.getItemName().equalsIgnoreCase("Privacy Policy")
                    || model.getItemName().equalsIgnoreCase("Log Out")){
                holder.itemName.setTextColor(Color.parseColor("#30000000"));
            }
            holder.itemName.setText(model.getItemName());
            final int sdk = android.os.Build.VERSION.SDK_INT;
            if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                holder.itemIcon.setImageResource(model.getItemIcon());
            } else {
                holder.itemIcon.setImageResource( model.getItemIcon());
            }
            holder.rootlayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(model.getItemName().equalsIgnoreCase("Home")){
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout1, HomeFragment.newInstance(), "HomeFragment").commit();
                    }
//                    else if(model.getItemName().equalsIgnoreCase("Bookings")){
//                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout1, BookingsFragment.newInstance(), "BookingsFragment").commit();
//                    }
//                    else if(model.getItemName().equalsIgnoreCase("Payments")){
//                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout1, PaymentMethodFragment.newInstance(), "PaymentMethodFragment").commit();
//                    }
//                    else if(model.getItemName().equalsIgnoreCase("About Us")){
//                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout1, AboutFragment.newInstance(), "AboutFragment").commit();
//                    }
//                    else if(model.getItemName().equalsIgnoreCase("Contact Us")){
//                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout1, ContactUsFragment.newInstance(), "ContactUsFragment").commit();
//                    }
//                    else if(model.getItemName().equalsIgnoreCase("Privacy Policy")){
//                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout1, AboutFragment.newInstance(), "AboutFragment").commit();
//                    }
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    if (drawer.isDrawerOpen(GravityCompat.START)) {
                        drawer.closeDrawer(GravityCompat.START);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView itemIcon;
            public TextView itemName;
            public LinearLayout rootlayout;
            public ViewHolder(View itemView) {
                super(itemView);
                itemIcon = (ImageView) itemView.findViewById(R.id.menu_item_icon);
                itemName = (TextView) itemView.findViewById(R.id.menu_item_name);
                itemView.setClickable(true);
                rootlayout = (LinearLayout) itemView.findViewById(R.id.rootlayout);
            }
        }
    }

    @Override
    public void onBackPressed() {
//        Fragment f = getSupportFragmentManager().findFragmentById(R.id.main_frameLayout);
//        if (f != null && f instanceof HomeFragment){
//            if (homeBackButton.getVisibility() == View.VISIBLE){
//                ((HomeFragment) f).actionDestinationCancel();
//            }
//            else {
//                this.finishAffinity();
//                System.exit(0);
//            }
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(getSupportFragmentManager().getBackStackEntryCount() == 0) {
                super.onBackPressed();
            }
            else {
                getSupportFragmentManager().popBackStack();
            }
        }
    }
}
