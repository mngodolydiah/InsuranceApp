package mng.r.lydia.insuranceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class PrivateInsurance extends AppCompatActivity {

    String[] privateInsuranceList={"Private Car Insurance", "Private Motorcycle Insurance"};
    Integer[] privateInsuranceImages= {R.drawable.private_car_insurance_icon, R.drawable.private_motorcycle_insurance_icon};
    ListView privateListView;
    ListAdapter privateListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_insurance);

        privateListView = (ListView) findViewById(R.id.privateList);
        privateListAdapter = new ListAdapter(this, privateInsuranceList, privateInsuranceImages);
        privateListView.setAdapter(privateListAdapter);

        privateListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), privateInsuranceList[position], Toast.LENGTH_LONG).show();

                if(privateInsuranceList[position] == "Private Car Insurance"){
                    startActivity(new Intent(PrivateInsurance.this, CompanyListPrivateCar.class));
                }else if(privateInsuranceList[position] == "Private Motorcycle Insurance"){
                    startActivity(new Intent(PrivateInsurance.this, CompanyListMotorcycle.class));
                }
            }
        });
    }
}
