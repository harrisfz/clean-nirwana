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
import io.sago.hfz.baraja.domain.model.moviedetails.Movie;

/**
 * Mapper class used to transform {@link MovieItemEntity} (in the data layer) to {@link Movie}
 * in the
 * domain layer.
 */
@Singleton
public class MovieItemEntityDataMapper {

    @Inject
    MovieItemEntityDataMapper() {
    }

    /**
     * Transform a {@link MovieItemEntity} into an {@link Movie}.
     *
     * @param movieItemEntity Object to be transformed.
     * @return {@link Movie} if valid {@link MovieItemEntity} otherwise null.
     */
    public Movie transform(MovieItemEntity movieItemEntity) {
        Movie movieDetail = null;
        if (movieItemEntity != null) {
            movieDetail = new Movie(movieItemEntity.getId());
            movieDetail.setOriginalLanguage(movieItemEntity.getOriginalLanguage());
            movieDetail.setOriginalTitle(movieItemEntity.getOriginalTitle());
            movieDetail.setTitle(movieItemEntity.getTitle());
            movieDetail.setOverview(movieItemEntity.getOverview());
            movieDetail.setVideo(movieItemEntity.isVideo());
            movieDetail.setBackdropPath(movieDetail.getBackdropPath());
            movieDetail.setPosterPath(movieItemEntity.getPosterPath());
            movieDetail.setPopularity(movieItemEntity.getPopularity());
            movieDetail.setAdult(movieItemEntity.isAdult());
            movieDetail.setVoteAverage(movieItemEntity.getVoteAverage());
            movieDetail.setVoteCount(movieItemEntity.getVoteCount());
            movieDetail.setReleaseDate(movieItemEntity.getReleaseDate());
            movieDetail.setImdbId(movieItemEntity.getImdbId());
            movieDetail.setRevenue(movieItemEntity.getRevenue());
            movieDetail.setBudget(movieItemEntity.getBudget());
            movieDetail.setRuntime(movieItemEntity.getRuntime());
            movieDetail.setTagline(movieItemEntity.getTagline());
            movieDetail.setHomepage(movieItemEntity.getHomepage());
            movieDetail.setStatus(movieItemEntity.getStatus());
            movieDetail.setGenreIds(movieItemEntity.getGenreIds());
            movieDetail.setGenres(movieDetail.getGenres());
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
     * Transform a List of {@link MovieItemEntity} into a Collection of {@link Movie}.
     *
     * @param movieItemEntityCollection Object Collection to be transformed.
     * @return {@link Movie} if valid {@link MovieItemEntity} otherwise null.
     */
    public List<Movie> transform(Collection<MovieItemEntity> movieItemEntityCollection) {
        final List<Movie> movieDetailList = new ArrayList<>();
        for (MovieItemEntity movieItemEntity : movieItemEntityCollection) {
            final Movie movieDetail = transform(movieItemEntity);
            if (movieDetail != null) {
                movieDetailList.add(movieDetail);
            }
        }
        return movieDetailList;
    }
}
