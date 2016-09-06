package home.murad.com.appp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Murad on 02/09/2016.
 */
public class StudentDetail extends ActionBarActivity implements android.view.View.OnClickListener{

    Button btnSave ,  btnDelete;
    Button btnClose;
    EditText editTextName;
    EditText editTextEmail;
    EditText editTextAge;
    private int _Student_Id=0;
    RestService restService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restService = new RestService();
        setContentView(R.layout.activity_student_detail);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnClose = (Button) findViewById(R.id.btnClose);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextAge = (EditText) findViewById(R.id.editTextAge);

        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClose.setOnClickListener(this);


        _Student_Id =0;
        Intent intent = getIntent();
        _Student_Id =intent.getIntExtra("student_Id", 0);
        if (_Student_Id>0){
            restService.getInstituteService().getStudentById(_Student_Id, new Callback<Student>() {
                @Override
                public void success(Student student, Response response) {

                    editTextAge.setText(String.valueOf(student.Age));
                    editTextName.setText(student.Name);
                    editTextEmail.setText(student.Email);
                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(StudentDetail.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();

                }
            });
        }
    }




    @Override
    public void onClick(View v) {
        if (findViewById(R.id.btnDelete)==v){
            restService.getInstituteService().deleteStudentById(_Student_Id, new Callback<Student>() {
                @Override
                public void success(Student student, Response response) {
                    Toast.makeText(StudentDetail.this, "Student Record Deleted", Toast.LENGTH_LONG).show();
                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(StudentDetail.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();

                }

            });

            finish();
        }else if (v== findViewById(R.id.btnClose)){
            finish();
        }else if (findViewById(R.id.btnSave)==v){

            Student student=new Student();
            Integer status =0;
            student.Email= editTextEmail.getText().toString();
            student.Name=editTextName.getText().toString();
            student.Age= Integer.parseInt(editTextAge.getText().toString());
            student.Id = _Student_Id;

            if (_Student_Id == 0) {
                restService.getInstituteService().addStudent(student, new Callback<Student>() {
                    @Override
                    public void success(Student student, Response response) {
                        Toast.makeText(StudentDetail.this, "New Student Inserted.", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(StudentDetail.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();

                    }
                });
            }else{
                restService.getInstituteService().updateStudentById(_Student_Id,student , new Callback<Student>() {
                    @Override
                    public void success(Student student, Response response) {
                        Toast.makeText(StudentDetail.this, "Student Record updated.", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(StudentDetail.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();

                    }
                });
            }

        }
    }
}