package io.sago.hfz.baraja.nirwana.di.modules;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import io.sago.hfz.baraja.nirwana.di.ApplicationContex;
import io.sago.hfz.baraja.nirwana.di.scope.MovieApplicationScope;
import io.sago.hfz.baraja.nirwana.services.TmdbApiService;
import retrofit2.Retrofit;
import timber.log.Timber;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version ApplicationModule, v 0.1 2019-07-03 10:32 by Harris Febryantony Z
 */
@Module(includes = ApplicationContextModule.class)
public class ApplicationModule {

    @Provides
    @MovieApplicationScope
    File file(@ApplicationContex Context context) {
        File file = new File(context.getCacheDir(), "HttpCache");
        file.mkdirs();
        return file;
    }

}
