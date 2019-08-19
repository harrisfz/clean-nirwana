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

import io.sago.hfz.baraja.data.entity.entity.MovieEntity;
import io.sago.hfz.baraja.domain.model.Genre;
import io.sago.hfz.baraja.domain.model.Movie;

/**
 * Mapper class used to transform {@link MovieEntity} (in the data layer) to {@link Movie}
 * in the
 * domain layer.
 */
@Singleton
public class MovieItemEntityDataMapper {

    @Inject
    MovieItemEntityDataMapper() {
    }

    /**
     * Transform a {@link MovieEntity} into an {@link Movie}.
     *
     * @param movieEntity Object to be transformed.
     * @return {@link Movie} if valid {@link MovieEntity} otherwise null.
     */
    public Movie transform(MovieEntity movieEntity) {
        Movie movieDetail = null;
        if (movieEntity != null) {
            movieDetail = new Movie(movieEntity.getId());
            movieDetail.setOriginalLanguage(movieEntity.getOriginalLanguage());
            movieDetail.setOriginalTitle(movieEntity.getOriginalTitle());
            movieDetail.setTitle(movieEntity.getTitle());
            movieDetail.setOverview(movieEntity.getOverview());
            movieDetail.setVideo(movieEntity.isVideo());
            movieDetail.setBackdropPath(movieDetail.getBackdropPath());
            movieDetail.setPosterPath(movieEntity.getPosterPath());
            movieDetail.setPopularity(movieEntity.getPopularity());
            movieDetail.setAdult(movieEntity.isAdult());
            movieDetail.setVoteAverage(movieEntity.getVoteAverage());
            movieDetail.setVoteCount(movieEntity.getVoteCount());
            movieDetail.setReleaseDate(movieEntity.getReleaseDate());
            movieDetail.setImdbId(movieEntity.getImdbId());
            movieDetail.setRevenue(movieEntity.getRevenue());
            movieDetail.setBudget(movieEntity.getBudget());
            movieDetail.setRuntime(movieEntity.getRuntime());
            movieDetail.setTagline(movieEntity.getTagline());
            movieDetail.setHomepage(movieEntity.getHomepage());
            movieDetail.setStatus(movieEntity.getStatus());
            movieDetail.setGenreIds(movieEntity.getGenreIds());
            movieDetail.setGenres(movieDetail.getGenres());
            movieDetail.setVoteCount(movieEntity.getVoteCount());
        }
        return movieDetail;
    }

    private List<Genre> transformGenres(List<Integer> genreIds) {
        List<Genre> genresItems = new ArrayList<>();
        for (Integer id : genreIds) {
            genresItems.add(new Genre(id));
        }
        return genresItems;
    }

    /**
     * Transform a List of {@link MovieEntity} into a Collection of {@link Movie}.
     *
     * @param movieEntityCollection Object Collection to be transformed.
     * @return {@link Movie} if valid {@link MovieEntity} otherwise null.
     */
    public List<Movie> transform(Collection<MovieEntity> movieEntityCollection) {
        final List<Movie> movieDetailList = new ArrayList<>();
        for (MovieEntity movieEntity : movieEntityCollection) {
            final Movie movieDetail = transform(movieEntity);
            if (movieDetail != null) {
                movieDetailList.add(movieDetail);
            }
        }
        return movieDetailList;
    }
}
