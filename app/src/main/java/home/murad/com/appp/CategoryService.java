package home.murad.com.appp;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Murad on 02/09/2016.
 */
public interface CategoryService {
    @GET("/AndroidWaiter/Category")
    public void getCategory(Callback<List<Category>> callback);


    //Get student record base on ID
    @GET("/AndroidWaiter/Category/{id}")
    public void getCategoryById(@Path("id") Integer id, Callback<Category> callback);

}
