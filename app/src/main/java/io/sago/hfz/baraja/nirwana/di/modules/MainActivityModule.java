package io.sago.hfz.baraja.nirwana.di.modules;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import io.sago.hfz.baraja.nirwana.view.activity.MainActivity;
import io.sago.hfz.baraja.nirwana.adapters.MovieAdapter;
import io.sago.hfz.baraja.nirwana.di.scope.MainActivityScope;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version MainActivityModule, v 0.1 2019-07-03 18:58 by Harris Febryantony Z
 */
@Module
public class MainActivityModule {

    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainActivityScope
    public MovieAdapter movieAdapter(Picasso picasso) {
        return new MovieAdapter(picasso);
    }
}
