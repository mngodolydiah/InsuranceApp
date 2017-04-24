package mng.r.lydia.insuranceapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 4/24/2017.
 */

public class CustomAdapter extends BaseExpandableListAdapter{

public Context c;
    public ArrayList<CompanyList> company;
    public LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList<CompanyList> company) {
        this.c = c;
        this.company = company;
         inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return company.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return company.get(groupPosition).categories.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return company.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return company.get(groupPosition).categories.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            convertView=inflater.inflate(R.layout.parent_list, null);
        }
        //GET GROUP/TEAM ITEM
        CompanyList t=(CompanyList) getGroup(groupPosition);
        //SET GROUP NAME
        TextView nameTv=(TextView) convertView.findViewById(R.id.profileTxt);
        ImageView img=(ImageView) convertView.findViewById(R.id.thumbnail);
        String name=t.name;
        nameTv.setText(name);
        //ASSIGN TEAM IMAGES ACCORDING TO TEAM NAME
        if(name=="company 1")
        {
            img.setImageResource(R.drawable.ic_menu_gallery);
        }else if(name=="company 2")
        {
            img.setImageResource(R.drawable.ic_menu_camera);
        }else if(name=="company 3")
        {
            img.setImageResource(R.drawable.ic_menu_camera);
        }
        //SET TEAM ROW BACKGROUND COLOR
        convertView.setBackgroundColor(Color.LTGRAY);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.child_list,null);
        }

        String child=(String) getChild(groupPosition,childPosition);

        TextView nametv=(TextView) convertView.findViewById(R.id.profileTxt);
        ImageView img=(ImageView) convertView.findViewById(R.id.thumbnail);

        nametv.setText(child);

        String downlist = getGroup(groupPosition).toString();
        if(downlist=="company 1, company 2, company 3")
        {
            if(child=="Third Party Only")
            {
                img.setImageResource(R.drawable.ic_menu_camera)  ;
            }else if(child=="Third Party Fire and Insurance")
            {
                img.setImageResource(R.drawable.ic_menu_camera)  ;
            }else if(child=="Comprehensive Insurance")
            {
                img.setImageResource(R.drawable.ic_menu_camera)  ;
            }
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
