package io.sago.hfz.baraja.nirwana.di.modules;

import dagger.Module;
import dagger.Provides;
import io.sago.hfz.baraja.nirwana.services.TmdbApiService;
import io.sago.hfz.baraja.nirwana.view.activity.MainActivity;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version RetrofitModule, v 0.1 2019-07-14 20:43 by Harris Febryantony Z
 */
@Module
public class RetrofitModule {

    @Provides
    TmdbApiService tmdbApiService(Retrofit retrofit) {
        return retrofit.create(TmdbApiService.class);
    }

    @Provides
    HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(
            message -> Timber.d(message));
        interceptor.level(HttpLoggingInterceptor.Level.HEADERS);
        return interceptor;
    }

    @Provides
    Interceptor headerInterceptor() {
        return chain -> {

            Request original = chain.request();
            HttpUrl httpUrl = original.url();

            HttpUrl newHttpUrl = httpUrl.newBuilder()
                .addQueryParameter(MainActivity.API_KEY_TAG, MainActivity.API_KEY).build();

            Request.Builder requestBuilder = original.newBuilder().url(newHttpUrl);

            Request request = requestBuilder.build();
            return chain.proceed(request);
        };


    }

    @Provides
    GsonConverterFactory gsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    RxJava2CallAdapterFactory rxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor,
        Interceptor headerInterceptor) {
        return new OkHttpClient()
            .newBuilder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(headerInterceptor)
            .build();
    }

    @Provides
    Retrofit retrofit(
        OkHttpClient okHttpClient,
        RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
        GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
            .baseUrl(MainActivity.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .addConverterFactory(gsonConverterFactory)
            .build();
    }
}
