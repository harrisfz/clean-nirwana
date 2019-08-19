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
import io.sago.hfz.baraja.data.entity.entity.detail.CollectionEntity;
import io.sago.hfz.baraja.data.entity.entity.detail.GenreEntity;
import io.sago.hfz.baraja.data.entity.entity.detail.ProductionCompanyEntity;
import io.sago.hfz.baraja.data.entity.entity.detail.ProductionCountryEntity;
import io.sago.hfz.baraja.data.entity.entity.detail.SpokenLanguageEntity;
import io.sago.hfz.baraja.domain.model.BelongToCollection;
import io.sago.hfz.baraja.domain.model.Genre;
import io.sago.hfz.baraja.domain.model.Movie;
import io.sago.hfz.baraja.domain.model.ProductionCompany;
import io.sago.hfz.baraja.domain.model.ProductionCountry;
import io.sago.hfz.baraja.domain.model.SpokenLanguage;

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
        Movie movie = null;
        if (movieEntity != null) {
            movie = new Movie(movieEntity.getId());
            movie.setOriginalLanguage(movieEntity.getOriginalLanguage());
            movie.setOriginalTitle(movieEntity.getOriginalTitle());
            movie.setTitle(movieEntity.getTitle());
            movie.setOverview(movieEntity.getOverview());
            movie.setVideo(movieEntity.isVideo());
            movie.setBackdropPath(movieEntity.getBackdropPath());
            movie.setPosterPath(movieEntity.getPosterPath());
            movie.setPopularity(movieEntity.getPopularity());
            movie.setAdult(movieEntity.isAdult());
            movie.setVoteAverage(movieEntity.getVoteAverage());
            movie.setVoteCount(movieEntity.getVoteCount());
            movie.setReleaseDate(movieEntity.getReleaseDate());
            movie.setImdbId(movieEntity.getImdbId());
            movie.setRevenue(movieEntity.getRevenue());
            movie.setBudget(movieEntity.getBudget());
            movie.setRuntime(movieEntity.getRuntime());
            movie.setTagline(movieEntity.getTagline());
            movie.setHomepage(movieEntity.getHomepage());
            movie.setStatus(movieEntity.getStatus());
            movie.setGenreIds(transformGenreId(movieEntity.getGenreIds()));
            movie.setGenres(transformGenres(movieEntity.getGenres()));
            movie.setProductionCountries(
                transformProductionCountries(movieEntity.getProductionCountries()));
            movie.setSpokenLanguages(
                transformSpokenLanguages(movieEntity.getSpokenLanguages()));
            movie.setProductionCompanies(
                transformProductionCompanies(movieEntity.getProductionCompanies()));
            movie.setBelongsToCollection(transformCollection(movieEntity.getBelongsToCollection()));
        }
        return movie;
    }

    private BelongToCollection transformCollection(
        CollectionEntity btc) {
        BelongToCollection belongToCollection = new BelongToCollection();
        belongToCollection.setId(btc.getId());
        belongToCollection.setName(btc.getName());
        belongToCollection.setBackdropPath(btc.getBackdropPath());
        belongToCollection.setPosterPath(btc.getPosterPath());
        return belongToCollection;
    }

    private List<ProductionCompany> transformProductionCompanies(
        List<ProductionCompanyEntity> productionCompanies) {
        if (productionCompanies == null) return null;

        List<ProductionCompany> pcl = new ArrayList<>();
        for (ProductionCompanyEntity pce :
            productionCompanies) {
            pcl.add(transformProductionCompany(pce));
        }
        return null;
    }

    private ProductionCompany transformProductionCompany(ProductionCompanyEntity pce) {
        ProductionCompany productionCompany = new ProductionCompany();
        productionCompany.setId(pce.getId());
        productionCompany.setLogoPath(pce.getLogoPath());
        productionCompany.setOriginCountry(pce.getOriginCountry());
        productionCompany.setName(pce.getName());
        return productionCompany;
    }

    private List<SpokenLanguage> transformSpokenLanguages(
        List<SpokenLanguageEntity> spokenLanguages) {
        if (spokenLanguages == null) return null;

        List<SpokenLanguage> sls = new ArrayList<>();
        for (SpokenLanguageEntity sle : spokenLanguages
        ) {
            sls.add(transformSpokenLanguage(sle));
        }
        return null;
    }

    private SpokenLanguage transformSpokenLanguage(SpokenLanguageEntity sle) {
        SpokenLanguage spokenLanguage = new SpokenLanguage();
        spokenLanguage.setIso6391(sle.getIso6391());
        spokenLanguage.setName(sle.getName());
        return spokenLanguage;
    }

    private List<ProductionCountry> transformProductionCountries(
        List<ProductionCountryEntity> productionCountries) {
        if (productionCountries == null) return null;

        List<ProductionCountry> pCountries = new ArrayList<>();
        for (ProductionCountryEntity pc :
            productionCountries) {
            pCountries.add(transformProductionCountry(pc));
        }
        return pCountries;
    }

    private ProductionCountry transformProductionCountry(ProductionCountryEntity pc) {
        ProductionCountry productionCountry = new ProductionCountry();
        productionCountry.setName(pc.getName());
        productionCountry.setIso31661(pc.getIso31661());
        return productionCountry;
    }

    private List<Integer> transformGenreId(List<Integer> genreIds) {
        if (genreIds == null) return null;
        List<Integer> ids = new ArrayList<>(genreIds);
        return ids;
    }

    private List<Genre> transformGenres(List<GenreEntity> genres) {
        if (genres == null) return null;
        List<Genre> genresItems = new ArrayList<>();
        for (GenreEntity genre : genres) {
            genresItems.add(transformGenre(genre));
        }
        return genresItems;
    }

    private Genre transformGenre(GenreEntity genre) {
        Genre g = new Genre(genre.getId());
        g.setName(genre.getName());
        return g;
    }

    /**
     * Transform a List of {@link MovieEntity} into a BelongToCollection of {@link Movie}.
     *
     * @param movieEntityCollection Object BelongToCollection to be transformed.
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
