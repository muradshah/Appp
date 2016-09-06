package home.murad.com.appp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Murad on 03/09/2016.
 */
public class CustomAdapterDish extends ArrayAdapter<Dish> {

    public CustomAdapterDish(Context context, int resource, List<Dish> objects) {
        super(context, resource, objects);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.view_dish, parent, false);
        }

        Dish dish = getItem(position);

        //Student student = getItem(position);

        if (dish != null) {
            TextView textView = (TextView) v.findViewById(R.id.child_food);
            TextView price = (TextView) v.findViewById(R.id.item_price);

            textView.setText(dish.Dish_Name);
            price.setText(Float.toString(dish.Dish_Price));




            //textView.setText(category.Category_Name);
            //TextView tvStudentId = (TextView) v.findViewById(R.id.student_Id);
            //TextView tvStudentName = (TextView) v.findViewById(R.id.student_name);
            //tvStudentId.setText( Integer.toString(student.Id));
            //tvStudentName.setText(student.Name);
        }

        return v;
    }
}
