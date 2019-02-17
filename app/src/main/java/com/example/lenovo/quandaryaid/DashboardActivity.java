package com.example.lenovo.quandaryaid;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

public class DashboardActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        createNotificationChannel();
        Toolbar dash= findViewById(R.id.toolbar);
        setSupportActionBar(dash);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,dash,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Menu menu = navigationView.getMenu();

        MenuItem tools= menu.findItem(R.id.nav_support);
        SpannableString s = new SpannableString(tools.getTitle());
        s.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance44), 0, s.length(), 0);
        tools.setTitle(s);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = new AskForHelp();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content_frame,fragment);
        ft.commit();

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        Intent intent = null;

        switch (id) {

            case R.id.nav_faid:
                fragment = new FirstAid();
                break;
            case R.id.nav_fnb:
                fragment = new FindNearby();
                break;
            case R.id.nav_phelp:
                fragment = new ProvideHelp();
                break;
            case R.id.nav_dash:
                fragment = new DashboardFragment();
                break;
            case R.id.nav_mh:
                fragment = new MajorHelpers();
                break;
            case R.id.nav_sponsers:
                fragment = new OurSponsers();
                break;
//            case R.id.nav_qastore:
//                fragment = new QA_Store();
//                break;

            case R.id.nav_coninf:
                intent = new Intent(this,ContactInformation.class);
                break;

            default:
                fragment = new AskForHelp();

        }

        if(fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame,fragment);
            ft.commit();
        }
        else {
            startActivity(intent);
        }

        DrawerLayout layout = findViewById(R.id.drawer_layout);
        layout.closeDrawer(Gravity.START);
        return true;
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        finish();
//    }

    @Override
    public void onBackPressed() {
        DrawerLayout layout = findViewById(R.id.drawer_layout);
        if(layout.isDrawerOpen(Gravity.START)) {
            layout.closeDrawer(Gravity.START);
        }
        else {
            super.onBackPressed();
        }
    }

    private void createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String name = "Notification Channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(com.example.lenovo.quandaryaid.Data.CHANNEL_ID,name,importance);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
