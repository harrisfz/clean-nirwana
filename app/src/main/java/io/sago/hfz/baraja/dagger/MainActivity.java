package io.sago.hfz.baraja.dagger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.sago.hfz.baraja.dagger.adapters.MovieAdapter;
import io.sago.hfz.baraja.dagger.model.Movie;
import io.sago.hfz.baraja.dagger.model.Resp;
import io.sago.hfz.baraja.dagger.services.TmdbApiService;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

import android.os.Bundle;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY_TAG = "api_key";

    public static final String API_KEY = "3f8171028d2be22d2cea4508627a837b";

    public static final String BASE_ULR = "https://api.themoviedb.org/3/";

    Picasso picasso;

    Retrofit retrofit;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    MovieAdapter movieAdapter;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        initViews();

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        Timber.plant(new Timber.DebugTree());

        File cacheFile = new File(this.getCacheDir(), "HttpCache");
        cacheFile.mkdirs();

        Cache cache = new Cache(cacheFile, 10 * 1000 * 1000);

        HttpLoggingInterceptor httpLoggingInterceptor = new
            HttpLoggingInterceptor(message -> Timber.i(message));

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(chain -> {
                Request original = chain.request();
                HttpUrl httpUrl = original.url();

                HttpUrl newHttpUrl = httpUrl.newBuilder()
                    .addQueryParameter(API_KEY_TAG, API_KEY).build();

                Request.Builder requestBuilder = original.newBuilder().url(newHttpUrl);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            })
            .build();

        OkHttp3Downloader okHttp3Downloader = new OkHttp3Downloader(okHttpClient);

        picasso = new Picasso.Builder(this)
            .downloader(okHttp3Downloader)
            .build();

        retrofit = new Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_ULR)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();


        movieAdapter = new MovieAdapter(picasso);
        recyclerView.setAdapter(movieAdapter);
        populateMovies();
    }

    private void initViews() {
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, 16, true));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void populateMovies() {
        Call<Resp> randomUsersCall = getRandomUserService().getPopular();
        randomUsersCall.enqueue(new Callback<Resp>() {
            @Override
            public void onResponse(Call<Resp> call,
                @NonNull Response<Resp> response) {
                if (response.isSuccessful()) {
                    movieAdapter.submitList(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<Resp> call, Throwable t) {
                Timber.e(t);
            }
        });
    }

    public TmdbApiService getRandomUserService() {
        return retrofit.create(TmdbApiService.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null)
            unbinder.unbind();
    }
}
