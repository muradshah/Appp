package home.murad.com.appp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends ActionBarActivity {

    ListView listView;

    RestService restService;
    //TextView student_Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restService = new RestService();
        setContentView(R.layout.activity_main);




        //btnGetAll = (Button) findViewById(R.id.btnGetAll);


        //btnGetAll.setOnClickListener(this);

        //btnAdd= (Button) findViewById(R.id.btnAdd);
        //btnAdd.setOnClickListener(this);


    }

    //This function will call when the screen is activate
    @Override
    public void onResume() {

        super.onResume();
        refreshScreen();
    }
/*
    @Override
    public void onClick(View v) {
        if (v== findViewById(R.id.btnAdd)){

            Intent intent = new Intent(this,StudentDetail.class);
            intent.putExtra("student_Id",0);
            startActivity(intent);

        }else {
            // You should use refreshScreen() instead, just show you an easier method only :P
            refreshScreen_SimpleWay();
        }
    }*/
    private void refreshScreen(){

    //Call to server to grab list of student records. this is a asyn
    //restService.getInstituteService().getStudent(new Callback<List<Student>>()
    // restService.getCategoryService().getCategory(new Callback<List<Category>>() {
    // });
    restService.getDishService().getDish(new Callback<List<Dish>>() {
        @Override
        public void success(List<Dish> catgory, Response response) {
            ListView lv = (ListView) findViewById(R.id.listView);

            //CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, R.layout.view_category, students);
            CustomAdapterDish customAdapter = new CustomAdapterDish(MainActivity.this, R.layout.view_dish, catgory);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //student_Id = (TextView) view.findViewById(R.id.student_Id);
                    //String studentId = student_Id.getText().toString();
                    //Intent objIndent = new Intent(getApplicationContext(), StudentDetail.class);
                    //objIndent.putExtra("student_Id", Integer.parseInt(studentId));
                    Intent objIndent = new Intent(getApplicationContext(), DishActivity.class);
                    startActivity(objIndent);
                }
            });
            lv.setAdapter(customAdapter);
        }

        @Override
        public void failure(RetrofitError error) {
            Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
        }
    });

}

    private void refreshScreeen(){

        //Call to server to grab list of student records. this is a asyn
        //restService.getInstituteService().getStudent(new Callback<List<Student>>()
       // restService.getCategoryService().getCategory(new Callback<List<Category>>() {
       // });
        restService.getCategoryService().getCategory(new Callback<List<Category>>() {
            @Override
            public void success(List<Category> catgory, Response response) {
                ListView lv = (ListView) findViewById(R.id.listView);

                //CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, R.layout.view_category, students);
                CustomAdapterCategory customAdapter = new CustomAdapterCategory(MainActivity.this, R.layout.view_category, catgory);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //student_Id = (TextView) view.findViewById(R.id.student_Id);
                        //String studentId = student_Id.getText().toString();
                        //Intent objIndent = new Intent(getApplicationContext(), StudentDetail.class);
                        //objIndent.putExtra("student_Id", Integer.parseInt(studentId));
                        Intent objIndent = new Intent(getApplicationContext(), DishActivity.class);
                        startActivity(objIndent);
                    }
                });
                lv.setAdapter(customAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });

    }

    //I Don't like the idea of loop the List<Student> and put data into ArrayList, but I DON'T WANT
    //made a complicated tutorial also:D, So I showed you this simple way but is not encourage
    //just to make you easy to understand without knowing the CustomAdapter method
/*
    private void refreshScreen_SimpleWay(){

        restService.getInstituteService().getStudent(new Callback<List<Student>>() {
            @Override
            public void success(List<Student> students, Response response) {
                ListView lv = (ListView) findViewById(R.id.listView);


                ArrayList<HashMap<String, String>> studentList = new ArrayList<HashMap<String, String>>();

                for (int i = 0; i < students.size(); i++) {
                    HashMap<String, String> student = new HashMap<String, String>();
                    student.put("id", String.valueOf(students.get(i).Id));
                    student.put("name", String.valueOf(students.get(i).Name));

                    studentList.add(student);
                }

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                        student_Id = (TextView) view.findViewById(R.id.student_Id);
                        String studentId = student_Id.getText().toString();
                        Intent objIndent = new Intent(getApplicationContext(),StudentDetail.class);
                        objIndent.putExtra("student_Id", Integer.parseInt( studentId));
                        startActivity(objIndent);
                    }
                });
                ListAdapter adapter = new SimpleAdapter(MainActivity.this, studentList, R.layout.viw_student_entry, new String[]{"id", "name"}, new int[]{R.id.student_Id, R.id.student_name});
                lv.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
*/
}