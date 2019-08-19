package io.sago.hfz.baraja.nirwana.base;

/**
 * @author Harris Febryaontony Z (harris.febryantony@dana.id)
 * @version AbstractContract, v 0.1 2019-08-20 02:52 by Harris Febryaontony Z
 */
public interface AbstractContract {
    interface AbstractView {

        void showProgress();

        void dismissProgress();

        void onError(String errorMessage);

    }

    interface AbstractPresenter {

        void onDestroy();

    }
}
