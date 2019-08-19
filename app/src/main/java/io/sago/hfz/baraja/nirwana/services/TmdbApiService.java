package io.sago.hfz.baraja.nirwana.services;

import io.sago.hfz.baraja.data.entity.Resp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author Harris Febryantony Z (harris.febryantony@dana.id)
 * @version TmdbApiService, v 0.1 2019-06-26 16:32 by Harris Febryantony Z
 */
public interface TmdbApiService {

    @GET("movie/{movieId}")
    Call<Resp> getMovie(@Path("movieId") int id);

    @GET("movie/popular")
    Call<Resp>  getPopular();

    @GET("movie/top_rated")
    Call<Resp>  getTopRated();

    @GET("movie/{movieId}/videos")
    Call<Resp>  getMovieVideos(@Path("movieId") int movieId);
}