package io.sago.hfz.baraja.nirwana.di.modules;

import dagger.Module;
import dagger.Provides;
import io.sago.hfz.baraja.nirwana.di.scope.PerActivity;
import io.sago.hfz.baraja.nirwana.view.activity.BaseActivity;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version ActivityModule, v 0.1 2019-07-03 18:58 by Harris Febryantony Z
 */
@Module(includes = ActivityContextModule.class)
public class ActivityModule {

    private final BaseActivity baseActivity;

    public ActivityModule(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    @Provides
    @PerActivity
    BaseActivity activity() {
        return baseActivity;
    }
}
