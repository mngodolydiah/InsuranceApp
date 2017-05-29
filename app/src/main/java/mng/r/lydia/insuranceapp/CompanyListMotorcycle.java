package mng.r.lydia.insuranceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CompanyListMotorcycle extends AppCompatActivity {

    String[] companyList={"Company A", "Company B"};
    Integer[] companyImages= {R.drawable.company_a, R.drawable.company_b};
    ListView companyListView;
    ListAdapter companyListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_insurance);

        companyListView = (ListView) findViewById(R.id.privateList);
        companyListAdapter = new ListAdapter(this, companyList, companyImages);
        companyListView.setAdapter(companyListAdapter);

        companyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), companyList[position], Toast.LENGTH_LONG).show();
                startActivity(new Intent(CompanyListMotorcycle.this, CategoriesforPrivateMotorcycle.class));
            }
        });

    }
}