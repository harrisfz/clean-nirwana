package io.sago.hfz.baraja.nirwana;

import android.app.Activity;
import android.app.Application;

import io.sago.hfz.baraja.nirwana.di.component.ApplicationComponent;
import io.sago.hfz.baraja.nirwana.di.component.DaggerApplicationComponent;
import timber.log.Timber;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version NirwanaApplication, v 0.1 2019-07-03 19:07 by Harris Febryantony Z
 */
public class NirwanaApplication extends Application {

    private ApplicationComponent applicationComponent;

    public static NirwanaApplication get(Activity activity) {
        return (NirwanaApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initializeTimber();
        initializeInjector();

    }

    private void initializeTimber() {
        Timber.plant(new Timber.DebugTree());
    }

    private void initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
            .build();
    }
}
