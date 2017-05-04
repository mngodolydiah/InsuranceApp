package mng.r.lydia.insuranceapp;

import java.util.ArrayList;

public class CompanyList {

    public String name;
//    public String image;
    public ArrayList<String> categories= new ArrayList<String>();

    public CompanyList(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return name;
    }
}
