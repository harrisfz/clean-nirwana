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
package io.sago.hfz.baraja.data.entity.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.sago.hfz.baraja.data.entity.MovieEntity;
import io.sago.hfz.baraja.domain.model.Movie;

/**
 * Mapper class used to transform {@link MovieEntity} (in the data layer) to {@link Movie} in the
 * domain layer.
 */
@Singleton
public class MovieEntityDataMapper {

    @Inject
    MovieEntityDataMapper() {
    }

    /**
     * Transform a {@link MovieEntity} into an {@link Movie}.
     *
     * @param movieEntity Object to be transformed.
     * @return {@link Movie} if valid {@link MovieEntity} otherwise null.
     */
    public Movie transform(MovieEntity movieEntity) {
        Movie movie = null;
        if (movieEntity != null) {
            movie = new Movie(movieEntity.getUserId());
            movie.setCoverUrl(movieEntity.getCoverUrl());
            movie.setFullName(movieEntity.getFullname());
            movie.setDescription(movieEntity.getDescription());
            movie.setFollowers(movieEntity.getFollowers());
            movie.setEmail(movieEntity.getEmail());
        }
        return movie;
    }

    /**
     * Transform a List of {@link MovieEntity} into a Collection of {@link Movie}.
     *
     * @param movieEntityCollection Object Collection to be transformed.
     * @return {@link Movie} if valid {@link MovieEntity} otherwise null.
     */
    public List<Movie> transform(Collection<MovieEntity> movieEntityCollection) {
        final List<Movie> movieList = new ArrayList<>(20);
        for (MovieEntity movieEntity : movieEntityCollection) {
            final Movie movie = transform(movieEntity);
            if (movie != null) {
                movieList.add(movie);
            }
        }
        return movieList;
    }
}
