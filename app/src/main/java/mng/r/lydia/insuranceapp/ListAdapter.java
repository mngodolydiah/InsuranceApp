package mng.r.lydia.insuranceapp;

/**
 * Created by user on 4/17/2017.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ListAdapter extends ArrayAdapter<String> {

    private final Activity Context;
    private final String[] ListItemsName;
    private final Integer[] ImageName;

    public ListAdapter(Activity context, String[] content,
                       Integer[] ImageName) {

        super(context, R.layout.activity_list_items, content);
        // TODO Auto-generated constructor stub

        this.Context = context;
        this.ListItemsName = content;
        this.ImageName = ImageName;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = Context.getLayoutInflater();
        View ListViewSingle = inflater.inflate(R.layout.activity_list_items, null, true);

        TextView ListViewItems = (TextView) ListViewSingle.findViewById(R.id.profileTxt);
        ImageView ListViewImage = (ImageView) ListViewSingle.findViewById(R.id.thumbnail);

        ListViewItems.setText(ListItemsName[position]);
        ListViewImage.setImageResource(ImageName[position]);
        return ListViewSingle;
    }


}
