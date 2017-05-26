package modelo;

import retrofit2.Retrofit;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;
import com.google.gson.Gson;


public class API{

    private static MercadoLibreAPI getAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create( new Gson() ))
                .baseUrl("https://api.mercadolibre.com/")
                .build();
        MercadoLibreAPI service = retrofit.create(MercadoLibreAPI.class);
        return service;
    }
    public static void getArticle(String id, Callback<Articulo> callback) {
        getAPI().getArticle(id).enqueue(callback);
    }
}
