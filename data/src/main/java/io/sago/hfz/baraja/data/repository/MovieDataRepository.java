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
package io.sago.hfz.baraja.data.repository;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.sago.hfz.baraja.data.entity.mapper.MovieItemEntityDataMapper;
import io.sago.hfz.baraja.data.repository.datasource.MovieDataStore;
import io.sago.hfz.baraja.data.repository.datasource.MovieDataStoreFactory;
import io.sago.hfz.baraja.domain.model.moviedetails.MovieDetail;
import io.sago.hfz.baraja.domain.repository.MovieRepository;

/**
 * {@link MovieRepository} for retrieving movie data.
 */
@Singleton
public class MovieDataRepository implements MovieRepository {

  private final MovieDataStoreFactory movieDataStoreFactory;
  private final MovieItemEntityDataMapper movieItemEntityDataMapper;

  /**
   * Constructs a {@link MovieRepository}.
   *
   * @param dataStoreFactory A factory to construct different data source implementations.
   * @param movieItemEntityDataMapper {@link MovieItemEntityDataMapper}.
   */
  @Inject
  MovieDataRepository(MovieDataStoreFactory dataStoreFactory,
      MovieItemEntityDataMapper movieItemEntityDataMapper) {
    this.movieDataStoreFactory = dataStoreFactory;
    this.movieItemEntityDataMapper = movieItemEntityDataMapper;
  }

  @Override
  public Observable<List<MovieDetail>> movies() {
    //we always get all movies from the cloud
    final MovieDataStore movieDataStore = this.movieDataStoreFactory.createCloudDataStore();
    return movieDataStore.userEntityList().map(this.movieItemEntityDataMapper::transform);
  }

  @Override
  public Observable<MovieDetail> movie(int movieId) {
    final MovieDataStore movieDataStore = this.movieDataStoreFactory.create(movieId);
    return movieDataStore.userEntityDetails(movieId).map(this.movieItemEntityDataMapper::transform);
  }
}
