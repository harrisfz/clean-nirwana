package io.sago.hfz.baraja.nirwana.di.component;

import dagger.Component;
import io.sago.hfz.baraja.nirwana.di.modules.ActivityModule;
import io.sago.hfz.baraja.nirwana.di.modules.ApiModule;
import io.sago.hfz.baraja.nirwana.di.modules.MovieModule;
import io.sago.hfz.baraja.nirwana.di.scope.PerActivity;
import io.sago.hfz.baraja.nirwana.view.fragment.BaseFragment;
import io.sago.hfz.baraja.nirwana.view.fragment.PlaceholderFragment;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version MovieComponent, v 0.1 2019-07-14 22:25 by Harris Febryantony Z
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class,
    MovieModule.class})
public interface MovieComponent {

    void inject(BaseFragment baseFragment);

    void inject(PlaceholderFragment movieListFragment);
}
