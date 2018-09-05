package com.app.actech.swineapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.NoSuchElementException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    WebView myWebView;
    String FNAME="";
    NavigationView navigationView;
    TextView tvw;
    int w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setItemIconTintList(null);

        Fragment fragment=new FixturesTabs(1);
        if(fragment!=null){
            //myWebView.setVisibility(View.GONE);

            FragmentManager fmg=getSupportFragmentManager();
            FragmentTransaction ft=fmg.beginTransaction();

            ft.replace(R.id.content_frame,fragment);



            ft.commit();
        }

        navigationView.getMenu().getItem(0).setChecked(true);

        tvw=findViewById(R.id.hd);

        tvw.setText("Introduction");


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.app_name);
            builder.setIcon(R.drawable.logo);
            builder.setMessage("Do you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finishAffinity();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();



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
        if (id == R.id.share) {
            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "SwineApp");
                String sAux = "\nLet me recommend you this application SwineApp\n\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id=com.app.actech.swineapp \n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "choose one"));
            } catch (Exception e) {

            }
        }
        if(id==R.id.info){
            Intent intent=new Intent(getApplicationContext(), Acknowledgements.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment=null;

        if (id == R.id.nav_intro) {
            ////getSupportActionBar().setTitle("Introduction");
            tvw.setText("Introduction");
            fragment=new FixturesTabs(1);
        } else if (id == R.id.nav_imp_farm) {
            //getSupportActionBar().setTitle("Importance of Pig Farming");
            tvw.setText("Importance of Pig Farming");
            fragment=new FixturesTabs(2);
        }  else if (id == R.id.b1) {
            //getSupportActionBar().setTitle("Breeds of pig");
            tvw.setText("Indegenous Pig Breeds");
            fragment=new FixturesTabs(31);

        }
        else if (id == R.id.b2) {
            //getSupportActionBar().setTitle("Breeds of pig");
            tvw.setText("Exotic Pig Breeds");
            fragment=new FixturesTabs(32);

        }
        else if (id == R.id.b3) {
            //getSupportActionBar().setTitle("Breeds of pig");
            tvw.setText("Crossbreeds");
            fragment=new FixturesTabs(33);

        }else if (id == R.id.nav_sel_breed) {
            //getSupportActionBar().setTitle("Selection and Breeding");
            tvw.setText("Selection and Breeding plan of pig farm ");
            fragment=new FixturesTabs(4);

        } else if (id == R.id.nav_reprod_breed) {
            //getSupportActionBar().setTitle("Reproduction in pig");
            tvw.setText("Reproduction in pig");
            fragment=new FixturesTabs(5);

        }
        else if (id == R.id.nav_feed_pig) {
            //getSupportActionBar().setTitle("Feeding of pig");
            tvw.setText("Feeding of pig ");
            fragment=new FixturesTabs(7);
        }
        else if (id == R.id.nav_manage_pig) {
            //getSupportActionBar().setTitle("Management of pig");
            tvw.setText("Management of pig ");
            fragment=new FixturesTabs(6);

        }
        else if (id == R.id.nav_housing) {
            //getSupportActionBar().setTitle("Housing for pig");
            tvw.setText("Housing for pig ");
            fragment=new FixturesTabs(8);
        } else if (id == R.id.nav_am_measures) {
            //getSupportActionBar().setTitle("Ameliorative measure");
             tvw.setText("Ameliorative measure for climatic stress ");
            fragment=new FixturesTabs(9);
        } else if (id == R.id.nav_dises) {
            //getSupportActionBar().setTitle("Diseases of pig");
            tvw.setText("Diseases of pig ");
            fragment=new FixturesTabs(10);
        }
        else if (id == R.id.nav_health) {
            //getSupportActionBar().setTitle("Health calendar");
            tvw.setText("Health calendar for Pig");
            fragment=new FixturesTabs(11);
        }  else if (id == R.id.nav_transport) {
            //getSupportActionBar().setTitle("Transportation of Pig");
            tvw.setText("Transportation of pig ");
            fragment=new FixturesTabs(12);
        } else if (id == R.id.nav_rfarm) {
            //getSupportActionBar().setTitle("Routine farm activities");
            tvw.setText("Routine farm activities ");
            fragment=new FixturesTabs(13);
        } else if (id == R.id.nav_guide) {
            //getSupportActionBar().setTitle("Biosecurity guidelines");
            tvw.setText("Biosecurity guidelines of pig farm ");
            fragment=new FixturesTabs(14);
        }
        else if (id == R.id.nav_ipg) {
            //getSupportActionBar().setTitle("Integrated pig farming");
            fragment=new FixturesTabs(15);
            tvw.setText("Integrated pig farming ");
        }  else if (id == R.id.nav_sm) {
            //getSupportActionBar().setTitle("Slaughter management");
            tvw.setText("Slaughter management ");
            fragment=new FixturesTabs(16);
        } else if (id == R.id.nav_wastd) {
            //getSupportActionBar().setTitle("Waste disposal");
            tvw.setText("Waste disposal");
            fragment=new FixturesTabs(17);
        } else if (id == R.id.nav_rec) {
            //getSupportActionBar().setTitle("Record keeping");
            tvw.setText("Record keeping ");
            fragment=new FixturesTabs(18);
        }
        else if (id == R.id.nav_tpvc) {
            //getSupportActionBar().setTitle("Pig Value Chain");
            tvw.setText("Traceability in Pig Value Chain");
            fragment=new FixturesTabs(19);
        }  else if (id == R.id.nav_fepp) {
            //getSupportActionBar().setTitle("Efficient piggery project");
            tvw.setText("Formulation of efficient piggery project");
            fragment=new FixturesTabs(20);
        } else if (id == R.id.nav_aipg) {
            //getSupportActionBar().setTitle("Improved pig germplasm");
            tvw.setText("Availability of improved pig germplasm ");
            fragment=new FixturesTabs(21);
        } else if (id == R.id.nav_rate) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
            tvw.setText("Introduction");
            fragment=new FixturesTabs(1);
        }
        else if(id==R.id.nav_share){
            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "SwineApp");
                String sAux = "\nLet me recommend you this application SwineApp\n\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id=com.app.actech.swineapp \n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "choose one"));
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),"No Compatible Share Option Found !!",Toast.LENGTH_SHORT).show();
            }

            tvw.setText("Introduction");
            fragment=new FixturesTabs(1);
        }
        else if (id == R.id.nav_info) {
            Intent intent=new Intent(getApplicationContext(), Acknowledgements.class);
            startActivity(intent);
        }


        if(fragment!=null){
            //myWebView.setVisibility(View.GONE);

            FragmentManager fmg=getSupportFragmentManager();
            FragmentTransaction ft=fmg.beginTransaction();

            ft.replace(R.id.content_frame,fragment);



            ft.commit();
        }
        else
            findViewById(R.id.content_frame).setVisibility(View.GONE);



        /*
        myWebView.loadUrl("file:///android_asset/image001.png");
        myWebView.setWebViewClient(new WebViewClient());
*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
