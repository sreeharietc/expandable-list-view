package com.example.qbclct.expandableview.REST;

import android.content.Context;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;


import java.io.File;
import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
/**
 * Created by QBCLCT on 9/8/16.
 */
public class ApiClient {

    private static Retrofit retrofit = null;
    private static OkHttpClient sOkHttpClient;

    public static Retrofit getClient(Context context) {
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getHttpClient(context))
                    .build();
        }
        return retrofit;
    }

    public static OkHttpClient getHttpClient(Context context) {
        if (sOkHttpClient == null) {
            sOkHttpClient = new OkHttpClient();
        }
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        sOkHttpClient.interceptors().add(interceptor);
        sOkHttpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("Accept", ApiConstants.API_ACCEPT_HEADER)
                        .header("Content-Type", ApiConstants.API_CONTENT_TYPE_HEADER)
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        });
        final File baseDir = context.getCacheDir();
        if (baseDir != null) {
            final File cacheDir = new File(baseDir, "HttpResponseCache");

        }

        return sOkHttpClient;
    }
}
