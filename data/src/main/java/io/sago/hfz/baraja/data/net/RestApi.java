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


import java.util.List;

import io.reactivex.Observable;
import io.sago.hfz.baraja.data.entity.entity.MovieEntity;

/**
 * RestApi for retrieving data from the network.
 */
public interface RestApi {
  String API_BASE_URL =
      "https://raw.githubusercontent.com/android10/Sample-Data/master/Android-CleanArchitecture/";

  /** Api url for getting all movies */
  String API_URL_GET_USER_LIST = API_BASE_URL + "movies.json";
  /** Api url for getting a movie profile: Remember to concatenate id + 'json' */
  String API_URL_GET_USER_DETAILS = API_BASE_URL + "movie_";

  /**
   * Retrieves an {@link Observable} which will emit a List of {@link MovieEntity}.
   */
  Observable<List<MovieEntity>> movieEntityList();

  /**
   * Retrieves an {@link Observable} which will emit a {@link MovieEntity}.
   *
   * @param movieId The movie id used to get movie data.
   */
  Observable<MovieEntity> movieEntityById(final int movieId);
}
