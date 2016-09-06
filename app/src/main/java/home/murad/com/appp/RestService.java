package home.murad.com.appp;

/**
 * Created by Murad on 02/09/2016.
 */
public class RestService {
    //You need to change the  local machine
    //or you may have different URL than we have hereIP if you testing environment is not
    private static final String URL = "http://androidwaiter.somee.com/";
    private retrofit.RestAdapter restAdapter;
    private InstituteService apiService;
    private CategoryService categoryService;
    private DishService dishService;

    public RestService()
    {
        restAdapter = new retrofit.RestAdapter.Builder()
                .setEndpoint(URL)
                .setLogLevel(retrofit.RestAdapter.LogLevel.FULL)
                .build();

        apiService = restAdapter.create(InstituteService.class);
        categoryService = restAdapter.create(CategoryService.class);
        dishService = restAdapter.create(DishService.class);
    }

    public DishService getDishService()
    {
        return dishService;
    }

    public CategoryService getCategoryService()
    {
        return categoryService;
    }


    public InstituteService getInstituteService()
    {
        return apiService;
    }
}
