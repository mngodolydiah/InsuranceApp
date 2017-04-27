package mng.r.lydia.insuranceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ClaimsCategories extends AppCompatActivity {

    String[] ClaimsList={"Private Car", "Motorcycle-Motorcycle PSV", "Commercial Vehicle-Motor Commercial PSV","Theft Insurance","Windscreen","Car Entertainment", "Personal Accident","Travel Insurance","Marine"};
    Integer[] ClaimsImages= {R.drawable.claim_icon, R.drawable.claim_icon, R.drawable.claim_icon, R.drawable.claim_icon, R.drawable.claim_icon, R.drawable.claim_icon, R.drawable.claim_icon, R.drawable.claim_icon, R.drawable.claim_icon};
    ListView ClaimsListView;
    ListAdapter claimsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_insurance);

        ClaimsListView = (ListView) findViewById(R.id.privateList);
        claimsListAdapter = new ListAdapter(this, ClaimsList, ClaimsImages);
        ClaimsListView.setAdapter(claimsListAdapter);

        ClaimsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ClaimsList[position], Toast.LENGTH_LONG).show();

                if(ClaimsList[position] == "Private Car"){
                    startActivity(new Intent(ClaimsCategories.this, ClaimsCompanyListPrivateCar.class));
                } else if(ClaimsList[position] == "Motorcycle-Motorcycle PSV"){
                    startActivity(new Intent(ClaimsCategories.this, ClaimsCompanyListMotorcyle.class));
                }else if(ClaimsList[position] == "Commercial Vehicle-Motor Commercial PSV"){
                    startActivity(new Intent(ClaimsCategories.this, ClaimsCompanyListCommericial.class));
                }else if(ClaimsList[position] == "Theft Insurance"){
                    startActivity(new Intent(ClaimsCategories.this, ClaimsCompanyListTheft.class));
                }else if(ClaimsList[position] == "Windscreen"){
                    startActivity(new Intent(ClaimsCategories.this, ClaimsCompanyListWindscreen.class));
                }else if(ClaimsList[position] == "Car Entertainment"){
                    startActivity(new Intent(ClaimsCategories.this, ClaimsCompanyCarEntertainment.class));
                }else if(ClaimsList[position] == "Personal Accident"){
                    startActivity(new Intent(ClaimsCategories.this, ClaimsCompanyListPersonalAccident.class));
                }else if(ClaimsList[position] == "Travel Insurance"){
                    startActivity(new Intent(ClaimsCategories.this, ClaimsCompanyListTravel.class));
                }else if(ClaimsList[position] == "Marine"){
                    startActivity(new Intent(ClaimsCategories.this, ClaimsCompanyListMarine.class));
                }
            }
        });

    }
}
