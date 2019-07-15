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

import io.sago.hfz.baraja.data.entity.entity.MovieItemEntity;
import io.sago.hfz.baraja.domain.model.moviedetails.GenresItem;
import io.sago.hfz.baraja.domain.model.moviedetails.MovieDetail;
import io.sago.hfz.baraja.domain.model.MovieItem;

/**
 * Mapper class used to transform {@link MovieItemEntity} (in the data layer) to {@link MovieDetail}
 * in the
 * domain layer.
 */
@Singleton
public class MovieItemEntityDataMapper {

    @Inject
    MovieItemEntityDataMapper() {
    }

    /**
     * Transform a {@link MovieItemEntity} into an {@link MovieItem}.
     *
     * @param movieItemEntity Object to be transformed.
     * @return {@link MovieItem} if valid {@link MovieItemEntity} otherwise null.
     */
    public MovieItem transform(MovieItemEntity movieItemEntity) {
        MovieItem movieDetail = null;
        if (movieItemEntity != null) {
            movieDetail = new MovieItem(movieItemEntity.getId());

            movieDetail.setOverview(movieItemEntity.getOverview());
            movieDetail.setOriginalLanguage(movieItemEntity.getOriginalLanguage());
            movieDetail.setOriginalTitle(movieItemEntity.getOriginalTitle());
            movieDetail.setVideo(movieItemEntity.isVideo());
            movieDetail.setTitle(movieItemEntity.getTitle());
            movieDetail.setGenreIds(movieItemEntity.getGenreIds());
            movieDetail.setPosterPath(movieItemEntity.getPosterPath());
            movieDetail.setBackdropPath(movieItemEntity.getBackdropPath());
            movieDetail.setReleaseDate(movieItemEntity.getReleaseDate());
            movieDetail.setVoteAverage(movieItemEntity.getVoteAverage());
            movieDetail.setPopularity(movieItemEntity.getPopularity());
            movieDetail.setAdult(movieItemEntity.isAdult());
            movieDetail.setVoteCount(movieItemEntity.getVoteCount());
        }
        return movieDetail;
    }

    private List<GenresItem> transformGenres(List<Integer> genreIds) {
        List<GenresItem> genresItems = new ArrayList<>();
        for (Integer id : genreIds) {
            genresItems.add(new GenresItem(id));
        }
        return genresItems;
    }

    /**
     * Transform a List of {@link MovieItemEntity} into a Collection of {@link MovieItem}.
     *
     * @param movieItemEntityCollection Object Collection to be transformed.
     * @return {@link MovieItem} if valid {@link MovieItemEntity} otherwise null.
     */
    public List<MovieItem> transform(Collection<MovieItemEntity> movieItemEntityCollection) {
        final List<MovieItem> movieDetailList = new ArrayList<>(20);
        for (MovieItemEntity movieItemEntity : movieItemEntityCollection) {
            final MovieItem movieDetail = transform(movieItemEntity);
            if (movieDetail != null) {
                movieDetailList.add(movieDetail);
            }
        }
        return movieDetailList;
    }
}
