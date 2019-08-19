/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.sago.hfz.baraja.data.net;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.net.MalformedURLException;
import java.util.List;

import io.reactivex.Observable;
import io.sago.hfz.baraja.data.entity.entity.MovieEntity;
import io.sago.hfz.baraja.data.entity.mapper.MovieEntityJsonMapper;
import io.sago.hfz.baraja.data.exception.NetworkConnectionException;

/**
 * {@link RestApi} implementation for retrieving data from the network.
 */
public class RestApiImpl implements RestApi {

  private final Context context;
  private final MovieEntityJsonMapper movieEntityJsonMapper;

  /**
   * Constructor of the class
   *
   * @param context {@link android.content.Context}.
   * @param movieEntityJsonMapper {@link MovieEntityJsonMapper}.
   */
  public RestApiImpl(Context context, MovieEntityJsonMapper movieEntityJsonMapper) {
    if (context == null || movieEntityJsonMapper == null) {
      throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
    }
    this.context = context.getApplicationContext();
    this.movieEntityJsonMapper = movieEntityJsonMapper;
  }

  @Override
  public Observable<List<MovieEntity>> movieEntityList() {
    return Observable.create(emitter -> {
      if (isThereInternetConnection()) {
        try {
          String responseMovieEntities = getMovieEntitiesFromApi();
          if (responseMovieEntities != null) {
            emitter.onNext(movieEntityJsonMapper.transformMovieEntityCollection(
                responseMovieEntities));
            emitter.onComplete();
          } else {
            emitter.onError(new NetworkConnectionException());
          }
        } catch (Exception e) {
          emitter.onError(new NetworkConnectionException(e.getCause()));
        }
      } else {
        emitter.onError(new NetworkConnectionException());
      }
    });
  }

  @Override
  public Observable<MovieEntity> movieEntityById(final int movieId) {
    return Observable.create(emitter -> {
      if (isThereInternetConnection()) {
        try {
          String responseMovieDetails = getMovieDetailsFromApi(movieId);
          if (responseMovieDetails != null) {
            emitter.onNext(movieEntityJsonMapper.transformMovieEntity(responseMovieDetails));
            emitter.onComplete();
          } else {
            emitter.onError(new NetworkConnectionException());
          }
        } catch (Exception e) {
          emitter.onError(new NetworkConnectionException(e.getCause()));
        }
      } else {
        emitter.onError(new NetworkConnectionException());
      }
    });
  }

  private String getMovieEntitiesFromApi() throws MalformedURLException {
    return ApiConnection.createGET(API_URL_GET_USER_LIST).requestSyncCall();
  }

  private String getMovieDetailsFromApi(int movieId) throws MalformedURLException {
    String apiUrl = API_URL_GET_USER_DETAILS + movieId + ".json";
    return ApiConnection.createGET(apiUrl).requestSyncCall();
  }

  /**
   * Checks if the device has any active internet connection.
   *
   * @return true device with internet connection, otherwise false.
   */
  private boolean isThereInternetConnection() {
    boolean isConnected;

    ConnectivityManager connectivityManager =
        (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
    isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

    return isConnected;
  }
}
