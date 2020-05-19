package com.example.covid;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity<HttpHeader> extends AppCompatActivity {


    private AppBarConfiguration mAppBarConfiguration;
    public static int paisSelecionado = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        String url = "https://covid-193.p.rapidapi.com/statistics";
        OkHttpHandler okHttpHandler = new OkHttpHandler();
        okHttpHandler.execute(url);


        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View.OnClickListener undoOnClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("plain/text");
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "jdmedeiros@gmail.com" });
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Android Covid experiment!");
                        startActivity(Intent.createChooser(intent, ""));

                        Snackbar.make(view, "Item removed", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                };

                Snackbar.make(view, "Send the author an email", Snackbar.LENGTH_LONG)
                        .setAction("Action", undoOnClickListener).show();

            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_welcome, R.id.nav_casos, R.id.nav_mortes, R.id.nav_testes)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override

    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}
