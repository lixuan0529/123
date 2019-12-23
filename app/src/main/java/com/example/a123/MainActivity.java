package com.example.a123;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.a123.UI.ui.about.AboutFragment;
import com.example.a123.UI.ui.bus.BusFragment;
import com.example.a123.UI.ui.car.CarFragment;
import com.example.a123.UI.ui.env.EnvFragment;
import com.example.a123.UI.ui.home.HomeFragment;
import com.example.a123.UI.ui.road.RoadFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        gotoFragment(R.id.content_main, new HomeFragment());
        MainActivity.this.setTitle(R.string.menu_home);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_car) {
            gotoFragment(R.id.content_main,new CarFragment());
            MainActivity.this.setTitle(R.string.menu_car);
        } else if (id == R.id.nav_env) {
            gotoFragment(R.id.content_main,new EnvFragment());
            MainActivity.this.setTitle(R.string.menu_env);
        } else if (id == R.id.nav_road) {
            gotoFragment(R.id.content_main,new RoadFragment());
            MainActivity.this.setTitle(R.string.menu_road);
        } else if (id == R.id.nav_bus) {
            gotoFragment(R.id.content_main,new BusFragment());
            MainActivity.this.setTitle(R.string.menu_bus);
        } else if (id == R.id.nav_custom) {

        } else if (id == R.id.nav_about) {
            gotoFragment(R.id.content_main,new AboutFragment());
            MainActivity.this.setTitle(R.string.menu_about);
        }else if (id == R.id.nav_help) {
            Uri uri = Uri.parse("tel:13763860642");
            Intent intent = new Intent(Intent.ACTION_DIAL, uri);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void gotoFragment(int content, Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(content,fragment)
                .commit();
    }
}
