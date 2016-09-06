package home.murad.com.appp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DishActivity extends ActionBarActivity {

    ListView listView;
    RestService restService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish);


        onResume();
        //refreshScreen();
    }

    public void onResume() {

        super.onResume();
        //refreshScreen();
    }


    private void refreshScreen(){

        //Call to server to grab list of student records. this is a asyn
        //restService.getInstituteService().getStudent(new Callback<List<Student>>()
        // restService.getCategoryService().getCategory(new Callback<List<Category>>() {
        // });
        restService.getDishService().getDish(new Callback<List<Dish>>() {
            @Override
            public void success(List<Dish> dish, Response response) {
                ListView lv = (ListView) findViewById(R.id.listView);

                //CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, R.layout.view_category, students);
                //CustomAdapterDish customAdapter = new CustomAdapterDish(DishActivity.this, R.layout.view_dish, dish);
                //lv.setAdapter(customAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(DishActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
