package io.sago.hfz.baraja.nirwana.navigation;

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;

import io.sago.hfz.baraja.nirwana.view.activity.MovieDetaisActivity;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version Navigator, v 0.1 2019-07-13 17:33 by Harris Febryantony Z
 */

public class Navigator {

    @Inject
    public Navigator() {
        // empty implementation
    }

    public void navigateToMovieDetail(Context context) {
        if (context == null)
            return;

        Intent intent = new Intent(context, MovieDetaisActivity.class);
        context.startActivity(intent);
    }
}
