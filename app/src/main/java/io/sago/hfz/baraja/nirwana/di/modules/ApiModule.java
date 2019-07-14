package io.sago.hfz.baraja.nirwana.di.modules;

import dagger.Module;
import dagger.Provides;
import io.sago.hfz.baraja.nirwana.services.TmdbApiService;
import retrofit2.Retrofit;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version ApiModule, v 0.1 2019-07-14 22:26 by Harris Febryantony Z
 */
@Module(includes = RetrofitModule.class)
public class ApiModule {

    @Provides
    TmdbApiService tmdbApiService(Retrofit retrofit) {
        return retrofit.create(TmdbApiService.class);
    }
}
