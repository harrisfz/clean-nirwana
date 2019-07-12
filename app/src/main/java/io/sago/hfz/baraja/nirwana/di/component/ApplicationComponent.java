package io.sago.hfz.baraja.nirwana.di.component;

import com.squareup.picasso.Picasso;

import dagger.Component;
import io.sago.hfz.baraja.nirwana.di.modules.NirwanaModule;
import io.sago.hfz.baraja.nirwana.di.modules.PicassoModule;
import io.sago.hfz.baraja.nirwana.di.scope.MovieApplicationScope;
import io.sago.hfz.baraja.nirwana.services.TmdbApiService;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version ApplicationComponent, v 0.1 2019-07-03 10:29 by Harris Febryantony Z
 */
@MovieApplicationScope
@Component(modules = {PicassoModule.class, NirwanaModule.class})
public interface ApplicationComponent {

    TmdbApiService getTmdbService();

    Picasso getPicasso();
}
