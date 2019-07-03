package io.sago.hfz.baraja.nirwana.di.component;

import android.app.Activity;

import dagger.Component;
import io.sago.hfz.baraja.nirwana.adapters.MovieAdapter;
import io.sago.hfz.baraja.nirwana.di.modules.MainActivityModule;
import io.sago.hfz.baraja.nirwana.di.scope.MainActivityScope;
import io.sago.hfz.baraja.nirwana.services.TmdbApiService;
import io.sago.hfz.baraja.nirwana.view.activity.MainActivity;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version MainActivityComponent, v 0.1 2019-07-03 18:54 by Harris Febryantony Z
 */
@Component(modules = MainActivityModule.class, dependencies = NirwanaComponent.class)
@MainActivityScope
public interface MainActivityComponent {

    void inject(MainActivity main);
}
