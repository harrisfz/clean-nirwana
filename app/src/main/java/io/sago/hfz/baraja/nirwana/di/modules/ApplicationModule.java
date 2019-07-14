package io.sago.hfz.baraja.nirwana.di.modules;

import dagger.Module;
import io.sago.hfz.baraja.nirwana.NirwanaApplication;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version ApplicationModule, v 0.1 2019-07-03 10:32 by Harris Febryantony Z
 */
@Module(includes = ApplicationContextModule.class)
public class ApplicationModule {

    private final NirwanaApplication nirwanaApplication;

    public ApplicationModule(NirwanaApplication nirwanaApplication) {
        this.nirwanaApplication = nirwanaApplication;
    }

}
