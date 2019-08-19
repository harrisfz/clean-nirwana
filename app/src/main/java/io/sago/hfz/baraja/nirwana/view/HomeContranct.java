package io.sago.hfz.baraja.nirwana.view;

import java.util.List;

import io.sago.hfz.baraja.nirwana.base.AbstractContract;
import io.sago.hfz.baraja.nirwana.model.MovieModel;

/**
 * @author Harris Febryaontony Z (harris.febryantony@dana.id)
 * @version HomeContranct, v 0.1 2019-08-20 02:50 by Harris Febryaontony Z
 */
public interface HomeContranct {
    interface Presenter extends AbstractContract.AbstractPresenter{
        void getMovies();
    }
    interface View extends AbstractContract.AbstractView{
        void onGetMoviesSuccess(List<MovieModel> movieModels);
    }
}
