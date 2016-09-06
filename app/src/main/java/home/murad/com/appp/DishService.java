package home.murad.com.appp;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Murad on 03/09/2016.
 */
public interface DishService {

    @GET("/AndroidWaiter/Dish")
    public void getDish(Callback<List<Dish>> callback);


    //Get student record base on ID
    @GET("/AndroidWaiter/Dish/{id}")
    public void getDishById(@Path("id") Integer id, Callback<Dish> callback);


}
