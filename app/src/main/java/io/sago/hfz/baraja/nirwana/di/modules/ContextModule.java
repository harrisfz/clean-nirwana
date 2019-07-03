package io.sago.hfz.baraja.nirwana.di.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version ContextModule, v 0.1 2019-07-03 13:54 by Harris Febryantony Z
 */
@Module
public class ContextModule {

    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    Context context() {
        return context;
    }
}
