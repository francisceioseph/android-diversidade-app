package br.edu.ifce.engcomp.francis.diversidade.activities;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import br.edu.ifce.engcomp.francis.diversidade.R;
import br.edu.ifce.engcomp.francis.diversidade.fragments.DiscoveringFragment;
import br.edu.ifce.engcomp.francis.diversidade.fragments.HealthFragment;
import br.edu.ifce.engcomp.francis.diversidade.fragments.NucleusFragment;
import br.edu.ifce.engcomp.francis.diversidade.fragments.RightsFragment;
import br.edu.ifce.engcomp.francis.diversidade.fragments.SuggestionFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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

        if (id == R.id.nav_nucleus) {
            Fragment fragmentNucleus = new NucleusFragment();
            android.app.FragmentManager fragmentManagerNucleus = getFragmentManager();
            toolbar.setTitle("Núcleos");
            fragmentManagerNucleus.beginTransaction().replace(R.id.content_main_layout, fragmentNucleus).commit();

        } else if (id == R.id.nav_discovery) {
            Fragment fragmentDiscovering = new DiscoveringFragment();
            android.app.FragmentManager fragmentManagerDiscovering = getFragmentManager();
            toolbar.setTitle("Descobrindo-se");
            fragmentManagerDiscovering.beginTransaction().replace(R.id.content_main_layout, fragmentDiscovering).commit();

        } else if (id == R.id.nav_rights) {
            Fragment fragmentRights = new RightsFragment();
            android.app.FragmentManager fragmentManagerRights = getFragmentManager();
            toolbar.setTitle("Direitos");
            fragmentManagerRights.beginTransaction().replace(R.id.content_main_layout, fragmentRights).commit();

        } else if (id == R.id.nav_health) {
            Fragment fragmentHealth = new HealthFragment();
            android.app.FragmentManager fragmentManagerHealth = getFragmentManager();
            toolbar.setTitle("Saúde");
            fragmentManagerHealth.beginTransaction().replace(R.id.content_main_layout, fragmentHealth).commit();

        } else if (id == R.id.nav_sugestion) {
            Fragment fragmentSuggestion = new SuggestionFragment();
            android.app.FragmentManager fragmentManagerSuggestion = getFragmentManager();
            toolbar.setTitle("Sugestão de Núcleo");
            fragmentManagerSuggestion.beginTransaction().replace(R.id.content_main_layout, fragmentSuggestion).commit();

        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(this, DetailNucleusActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}