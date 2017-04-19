package mng.r.lydia.insuranceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class PrivateInsurance extends AppCompatActivity {

    String[] privateInsuranceList={"Private Car Insurance", "Private Motorcycle Insurance", "Personal Accident Insurance", "Travel Insurance"};
    Integer[] privateInsuranceImages= {R.drawable.private_car_insurance_icon, R.drawable.private_motorcycle_insurance_icon, R.drawable.personal_accident_insurance_icon, R.drawable.travel_insurance_icon};
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
            }
        });
    }
}
