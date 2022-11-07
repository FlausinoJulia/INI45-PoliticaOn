package br.unicamp.politicaon;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// configurar o retrofit
public class RetrofitConfig {

    private static final String URL = "http://192.168.0.10:3000/usuarios/";
    //private static final String URL = "http://177.220.18.37:3000/usuarios/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
