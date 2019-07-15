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
package io.sago.hfz.baraja.data.repository.datasource;


import java.util.List;

import io.reactivex.Observable;
import io.sago.hfz.baraja.data.cache.MovieCache;
import io.sago.hfz.baraja.data.entity.entity.MovieItemEntity;
import io.sago.hfz.baraja.data.net.RestApi;

/**
 * {@link MovieDataStore} implementation based on connections to the api (Cloud).
 */
class CloudMovieDataStore implements MovieDataStore {

  private final RestApi restApi;
  private final MovieCache movieCache;

  /**
   * Construct a {@link MovieDataStore} based on connections to the api (Cloud).
   *
   * @param restApi The {@link RestApi} implementation to use.
   * @param movieCache A {@link MovieCache} to cache data retrieved from the api.
   */
  CloudMovieDataStore(RestApi restApi, MovieCache movieCache) {
    this.restApi = restApi;
    this.movieCache = movieCache;
  }

  @Override
  public Observable<List<MovieItemEntity>> movieEntityList() {
    return this.restApi.movieEntityList();
  }

  @Override
  public Observable<MovieItemEntity> movieEntityDetails(final int movieId) {
    return this.restApi.movieEntityById(movieId).doOnNext(CloudMovieDataStore.this.movieCache::put);
  }
}
