package io.sago.hfz.baraja.nirwana;

import android.app.Activity;
import android.app.Application;

import io.sago.hfz.baraja.nirwana.di.component.DaggerNirwanaComponent;
import io.sago.hfz.baraja.nirwana.di.component.NirwanaComponent;
import io.sago.hfz.baraja.nirwana.di.modules.ApplicationContextModule;
import timber.log.Timber;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version NirwanaApplication, v 0.1 2019-07-03 19:07 by Harris Febryantony Z
 */
public class NirwanaApplication extends Application {

    private NirwanaComponent nirwanaComponent;

    public static NirwanaApplication get(Activity activity) {
        return (NirwanaApplication) activity.getApplication();
    }

    public NirwanaComponent getNirwanaComponent() {
        return nirwanaComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        nirwanaComponent = DaggerNirwanaComponent.builder()
            .applicationContextModule(new ApplicationContextModule(this))
            .build();
    }
}
