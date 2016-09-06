package home.murad.com.appp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Murad on 02/09/2016.
 */
public class CustomAdapterCategory extends ArrayAdapter<Category> {

    public CustomAdapterCategory(Context context, int resource, List<Category> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.view_category, parent, false);
        }

        Category category = getItem(position);

        //Student student = getItem(position);

        if (category != null) {
            TextView textView = (TextView) v.findViewById(R.id.textView);
            textView.setText(category.Category_Name);
            //TextView tvStudentId = (TextView) v.findViewById(R.id.student_Id);
            //TextView tvStudentName = (TextView) v.findViewById(R.id.student_name);
            //tvStudentId.setText( Integer.toString(student.Id));
            //tvStudentName.setText(student.Name);
        }

        return v;
    }
}
