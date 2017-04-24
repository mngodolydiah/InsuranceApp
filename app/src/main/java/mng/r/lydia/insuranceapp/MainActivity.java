package mng.r.lydia.insuranceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String[] ListItemsName={"Profile/Account", "Private Insurance", "Claim", "My Documents"};
    Integer[] ImageName= {R.drawable.profile_icon, R.drawable.private_insurance_icon, R.drawable.claim_icon, R.drawable.document_icon};
    ListView listView;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //THE EXPANDABLE
        ExpandableListView elv=(ExpandableListView) findViewById(R.id.expanded_menu);
        final ArrayList<CompanyList> company= getData();
        //CREATE AND BIND TO ADAPTER
        CustomAdapter adapter=new CustomAdapter(MainActivity.this, company);
        elv.setAdapter(adapter);
        //SET ONCLICK LISTENER
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPostion,
                                        int childPosition, long id) {
                Toast.makeText(getApplicationContext(), company.get(groupPostion).categories.get(childPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        //ADD AND GET DATA

        listView = (ListView)findViewById(R.id.HomeList);

        listAdapter = new ListAdapter(MainActivity.this ,ListItemsName, ImageName);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ListItemsName[position], Toast.LENGTH_LONG).show();
                if(ListItemsName[position] == "Private Insurance"){
                    startActivity(new Intent(MainActivity.this, PrivateInsurance.class));
                }
            }
        });

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

        if (id == R.id.nav_my_profile) {
            // Handle the camera action
        } else if (id == R.id.nav_private_insurance) {
            startActivity(new Intent(this, PrivateInsurance.class));
        } else if (id == R.id.nav_claims) {

        } else if (id == R.id.nav_my_documents) {

        } else if (id == R.id.nav_share_this_app) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private ArrayList<CompanyList> getData()
    {
        CompanyList t1=new CompanyList("Company 1");
        t1.categories.add("Third Party Only");
        t1.categories.add("Third Party Fire and Insurance");
        t1.categories.add("Comprehensive Insurance ");

        CompanyList t2=new CompanyList("Company 2");
        t1.categories.add("Third Party Only");
        t1.categories.add("Third Party Fire and Insurance");
        t1.categories.add("Comprehensive Insurance ");

        CompanyList t3=new CompanyList("Company 3");
        t1.categories.add("Third Party Only");
        t1.categories.add("Third Party Fire and Insurance");
        t1.categories.add("Comprehensive Insurance ");
        ArrayList<CompanyList> allTeams=new ArrayList<CompanyList>();
        allTeams.add(t1);
        allTeams.add(t2);
        allTeams.add(t3);
        return allTeams;
    }

}
