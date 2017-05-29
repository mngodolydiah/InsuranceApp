package mng.r.lydia.insuranceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ClaimsCompanyListMarine extends AppCompatActivity {

    String[] ClaimsList={"Company A", "Company B"};
    Integer[] ClaimsImages= {R.drawable.claim_icon, R.drawable.claim_icon};
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
            }
        });

    }
}
