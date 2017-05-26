package com.example.marcos.mercadotrucho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import butterknife.BindView;
import butterknife.ButterKnife;
import modelo.API;
import modelo.Articulo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MainActivity extends AppCompatActivity {

    @BindView(R.id.imgprod)
    ImageView imgprod;

    @BindView(R.id.tv)
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        API.getArticle("MLA644287324", new Callback<Articulo>() {

            @Override
            public void onResponse(Call<Articulo> call, Response<Articulo> response) {
                if(response.isSuccessful()) {
                    Articulo received = response.body();

                    Picasso.with(getApplicationContext()).load(received.getThumbnail()).into(imgprod);
                    tv1.setText("Artículo descargado: " + received.getTitle());
                }
            }

            @Override
            public void onFailure(Call<Articulo> call, Throwable t) {


                tv1.setText("FALLO");
            }

        });


    }
}
