package mng.r.lydia.insuranceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class CompanyList extends AppCompatActivity {

    public String name;
    public String image;
    public ArrayList<String> categories= new ArrayList<String>();

    public CompanyList(String name){
        this.name=name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);
    }
    @Override
    public String toString() {
        return name;
    }
}
