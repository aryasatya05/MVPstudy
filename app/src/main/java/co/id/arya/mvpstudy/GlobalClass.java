package co.id.arya.mvpstudy;

import android.app.Application;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;

import okhttp3.OkHttpClient;

public class GlobalClass extends Application {

    public static final String BASE_URL = "http://192.168.70.42/api_rpla/index.php/Api/";

    @Override
    public void onCreate() {
        super.onCreate();
//http client yang bisa melakukan method yang ada di API ngebacaa request dan response
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addNetworkInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("mas", message);
            }
//untuk ngebaca requestnya
        }).setLevel(HttpLoggingInterceptor.Level.BODY)).build();
        AndroidNetworking.initialize(this, okHttpClient);

    }
}
