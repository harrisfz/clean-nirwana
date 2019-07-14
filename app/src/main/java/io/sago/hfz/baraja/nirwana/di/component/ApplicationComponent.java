package io.sago.hfz.baraja.nirwana.di.component;

import dagger.Component;
import io.sago.hfz.baraja.nirwana.NirwanaApplication;
import io.sago.hfz.baraja.nirwana.di.modules.ApplicationModule;
import io.sago.hfz.baraja.nirwana.di.scope.MovieApplicationScope;
import io.sago.hfz.baraja.nirwana.view.activity.BaseActivity;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version ApplicationComponent, v 0.1 2019-07-03 10:29 by Harris Febryantony Z
 */
@MovieApplicationScope
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    void inject(NirwanaApplication nirwanaApplication);
}
