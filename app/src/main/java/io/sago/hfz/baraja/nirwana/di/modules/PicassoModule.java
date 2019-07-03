package io.sago.hfz.baraja.nirwana.di.modules;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version PicassoModule, v 0.1 2019-07-03 10:52 by Harris Febryantony Z
 */
@Module(includes = {OkHttpClientModule.class})
public class PicassoModule {

    @Provides
    Picasso picasso(Context context, OkHttp3Downloader downloader) {
        return new Picasso.Builder(context)
            .downloader(downloader)
            .build();
    }

    @Provides
    OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }
}
