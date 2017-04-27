package mng.r.lydia.insuranceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CategoriesforPrivateMotorcycle extends AppCompatActivity {

    String[] privateMotorcyleList={"Third Party Only", "Comprehensive Insurance"};
    Integer[] privateMotorcyleImages= {R.drawable.private_insurance_icon, R.drawable.private_insurance_icon};
    ListView privateMotorcyleListView;
    ListAdapter privateMotorcyleListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_insurance);

        privateMotorcyleListView = (ListView) findViewById(R.id.privateList);
        privateMotorcyleListAdapter= new ListAdapter(this, privateMotorcyleList, privateMotorcyleImages);
        privateMotorcyleListView.setAdapter(privateMotorcyleListAdapter);

        privateMotorcyleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), privateMotorcyleList[position], Toast.LENGTH_LONG).show();

                if(privateMotorcyleList[position] == "Third Party Only"){
                    startActivity(new Intent(CategoriesforPrivateMotorcycle.this, ThirdPartyOnlyCompanyA.class));
                } else if(privateMotorcyleList[position] == "Comprehensive Insurance"){
                    startActivity(new Intent(CategoriesforPrivateMotorcycle.this, ComprehensiveInsuranceComapnyA.class));
                }
            }
        });

    }
}
