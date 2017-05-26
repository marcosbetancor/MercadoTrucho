package modelo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by Marcos on 26/05/2017.
 */

public interface MercadoLibreAPI {

    @GET("items/{itemId}")
    public Call<Articulo> getArticle(@Path("itemId") String id);
    @GET("sites/MLA/search")
    public Call<Articulo> search(@Query("q") String query);
}
