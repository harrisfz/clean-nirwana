package io.sago.hfz.baraja.nirwana.di.component;

import dagger.Component;
import io.sago.hfz.baraja.nirwana.di.modules.ActivityModule;
import io.sago.hfz.baraja.nirwana.di.scope.PerActivity;
import io.sago.hfz.baraja.nirwana.view.activity.BaseActivity;
import io.sago.hfz.baraja.nirwana.view.activity.MainActivity;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version ActivityComponent, v 0.1 2019-07-03 18:54 by Harris Febryantony Z
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    BaseActivity activity();
}
