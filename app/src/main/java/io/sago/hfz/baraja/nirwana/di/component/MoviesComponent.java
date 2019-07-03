package io.sago.hfz.baraja.nirwana.di.component;

import com.squareup.picasso.Picasso;

import javax.inject.Scope;

import dagger.Component;
import io.sago.hfz.baraja.nirwana.di.modules.MoviesModule;
import io.sago.hfz.baraja.nirwana.di.modules.PicassoModule;
import io.sago.hfz.baraja.nirwana.di.scope.MovieApplicationScope;
import io.sago.hfz.baraja.nirwana.services.TmdbApiService;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version MoviesComponent, v 0.1 2019-07-03 10:29 by Harris Febryantony Z
 */
@MovieApplicationScope
@Component(modules = {PicassoModule.class, MoviesModule.class})
public interface MoviesComponent {

    TmdbApiService getTmdbService();

    Picasso getPicasso();
}
