package io.sago.hfz.baraja.nirwana.view;

import android.content.Context;

import javax.inject.Inject;

import io.sago.hfz.baraja.domain.interactor.GetMovieList;

/**
 * @author Harris Febryaontony Z (harris.febryantony@dana.id)
 * @version HomePresenter, v 0.1 2019-08-20 02:55 by Harris Febryaontony Z
 */
public class HomePresenter implements HomeContranct.Presenter {

    private final Context context;

    private final GetMovieList getMovieList;

    @Inject
    public HomePresenter(Context context,
        GetMovieList getMovieList) {
        this.context = context;
        this.getMovieList = getMovieList;
    }

    @Override
    public void getMovies() {

    }

    @Override
    public void onDestroy() {

    }
}
