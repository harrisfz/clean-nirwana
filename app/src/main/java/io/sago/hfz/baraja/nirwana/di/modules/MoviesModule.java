package io.sago.hfz.baraja.nirwana.di.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import io.sago.hfz.baraja.nirwana.MainActivity;
import io.sago.hfz.baraja.nirwana.services.TmdbApiService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version MoviesModule, v 0.1 2019-07-03 10:32 by Harris Febryantony Z
 */
@Module(includes = OkHttpClientModule.class)
public class MoviesModule {

    @Provides
    TmdbApiService TmdbService(Retrofit retrofit) {
        return retrofit.create(TmdbApiService.class);
    }

    @Provides
    Retrofit retrofit(OkHttpClient okHttpClient,
        GsonConverterFactory gsonConverterFactory, Gson gson) {
        return new Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(MainActivity.BASE_ULR)
            .addConverterFactory(gsonConverterFactory)
            .build();
    }

    @Provides
    GsonConverterFactory gsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

}
