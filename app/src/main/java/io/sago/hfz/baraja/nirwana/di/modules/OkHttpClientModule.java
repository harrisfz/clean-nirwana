package io.sago.hfz.baraja.nirwana.di.modules;

import org.jetbrains.annotations.NotNull;

import android.content.Context;

import java.io.File;
import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import io.sago.hfz.baraja.nirwana.MainActivity;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version OkHttpClientModule, v 0.1 2019-07-03 10:55 by Harris Febryantony Z
 */
@Module(includes = ContextModule.class)
public class OkHttpClientModule {

    @Provides
    OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor,
        Interceptor headerInterceptor, Cache cache) {
        return new OkHttpClient()
            .newBuilder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(headerInterceptor)
            .cache(cache)
            .build();
    }

    @Provides
    Cache cache(File cacheFile) {
        return new Cache(cacheFile, 10 * 1000 * 1000); //10 MB
    }

    @Provides
    File file(Context context) {
        File cacheFile = new File(context.getCacheDir(), "httpCache");
        cacheFile.mkdirs();
        return cacheFile;
    }

    @Provides
    HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(
            message -> Timber.i(message));
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
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
}
