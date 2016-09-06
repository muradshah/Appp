package home.murad.com.appp;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by Murad on 02/09/2016.
 */
public interface InstituteService {
    //Retrofit turns our institute WEB API into a Java interface.
    //So these are the list available in our WEB API and the methods look straight forward
    //http://androidwaiter.somee.com/AndroidWaiter/Students
    //i.e. http://localhost/api/institute/Students
    @GET("/AndroidWaiter/Students")
    public void getStudent(Callback<List<Student>> callback);

    //i.e. http://localhost/api/institute/Students/1
    //Get student record base on ID
    @GET("/AndroidWaiter/Students/{id}")
    public void getStudentById(@Path("id") Integer id, Callback<Student> callback);

    //i.e. http://localhost/api/institute/Students/1
    //Delete student record base on ID
    @DELETE("/AndroidWaiter/Students/{id}")
    public void deleteStudentById(@Path("id") Integer id, Callback<Student> callback);

    //i.e. http://localhost/api/institute/Students/1
    //PUT student record and post content in HTTP request BODY
    @PUT("/AndroidWaiter/Students/{id}")
    public void updateStudentById(@Path("id") Integer id, @Body Student student, Callback<Student> callback);

    //i.e. http://localhost/api/institute/Students
    //Add student record and post content in HTTP request BODY
    @POST("/AndroidWaiter/Students")
    public void addStudent(@Body Student student, Callback<Student> callback);

}
