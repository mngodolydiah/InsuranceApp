package mng.r.lydia.insuranceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CategoriesPrivateCar extends AppCompatActivity {

    String[] privateCarInsuranceList={"Third Party Only", "Third Party Fire and Theft Insurance", "Comprehensive Insurance"};
    Integer[] privateCarInsuranceImages= {R.drawable.private_insurance_icon, R.drawable.private_insurance_icon, R.drawable.private_insurance_icon};
    ListView privateCarListView;
    ListAdapter privateCarListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_insurance);

        privateCarListView = (ListView) findViewById(R.id.privateList);
        privateCarListAdapter = new ListAdapter(this, privateCarInsuranceList, privateCarInsuranceImages);
        privateCarListView.setAdapter(privateCarListAdapter);

        privateCarListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), privateCarInsuranceList[position], Toast.LENGTH_LONG).show();

                if(privateCarInsuranceList[position] == "Third Party Only"){
                    startActivity(new Intent(CategoriesPrivateCar.this, ThirdPartyOnlyCompanyA.class));
                } else if(privateCarInsuranceList[position] == "Third Party Fire and Theft Insurance"){
                    startActivity(new Intent(CategoriesPrivateCar.this, ThirdPartyFireandTheftCompanyA.class));
                }else if(privateCarInsuranceList[position] == "Comprehensive Insurance"){
                    startActivity(new Intent(CategoriesPrivateCar.this, ComprehensiveInsuranceComapnyA.class));
                }
            }
        });

    }
}
