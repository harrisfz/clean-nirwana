package io.sago.hfz.baraja.nirwana.di.modules;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.sago.hfz.baraja.nirwana.di.ApplicationContex;
import io.sago.hfz.baraja.nirwana.di.scope.MovieApplicationScope;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version ApplicationContextModule, v 0.1 2019-07-03 13:54 by Harris Febryantony Z
 */
@Module
public class ApplicationContextModule {

    private final Context context;

    public ApplicationContextModule(Context context) {
        this.context = context;
    }

    @ApplicationContex
    @MovieApplicationScope
    @Provides
    Context context() {
        return context.getApplicationContext();
    }
}
