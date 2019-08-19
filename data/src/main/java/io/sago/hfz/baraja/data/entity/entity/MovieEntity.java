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
package io.sago.hfz.baraja.data.entity.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.sago.hfz.baraja.data.entity.entity.detail.CollectionEntity;
import io.sago.hfz.baraja.data.entity.entity.detail.GenreEntity;
import io.sago.hfz.baraja.data.entity.entity.detail.ProductionCompanyEntity;
import io.sago.hfz.baraja.data.entity.entity.detail.ProductionCountryEntity;
import io.sago.hfz.baraja.data.entity.entity.detail.SpokenLanguageEntity;

/**
 * User Entity used in the data layer.
 */
public class MovieEntity {

    @SerializedName("id")
    private int id;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private String overview;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("video")
    private boolean video;

    @SerializedName("adult")
    private boolean adult;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("imdb_id")
    private String imdbId;

    @SerializedName("revenue")
    private int revenue;

    @SerializedName("budget")
    private int budget;

    @SerializedName("runtime")
    private int runtime;

    @SerializedName("tagline")
    private String tagline;

    @SerializedName("homepage")
    private String homepage;

    @SerializedName("status")
    private String status;

    @SerializedName("genre_ids")
    private List<Integer> genreIds;

    @SerializedName("genres")
    private List<GenreEntity> genres;

    @SerializedName("production_countries")
    private List<ProductionCountryEntity> productionCountries;

    @SerializedName("spoken_languages")
    private List<SpokenLanguageEntity> spokenLanguages;

    @SerializedName("production_companies")
    private List<ProductionCompanyEntity> productionCompanies;

    @SerializedName("belongs_to_collection")
    private CollectionEntity belongsToCollection;

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<GenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreEntity> genres) {
        this.genres = genres;
    }

    public List<ProductionCountryEntity> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountryEntity> productionCountries) {
        this.productionCountries = productionCountries;
    }

    @Override
    public String toString() {
        return
            "MovieEntity{" +
                "overview = '" + overview + '\'' +
                ",original_language = '" + originalLanguage + '\'' +
                ",original_title = '" + originalTitle + '\'' +
                ",video = '" + video + '\'' +
                ",title = '" + title + '\'' +
                ",genre_ids = '" + genreIds + '\'' +
                ",poster_path = '" + posterPath + '\'' +
                ",backdrop_path = '" + backdropPath + '\'' +
                ",release_date = '" + releaseDate + '\'' +
                ",vote_average = '" + voteAverage + '\'' +
                ",popularity = '" + popularity + '\'' +
                ",id = '" + id + '\'' +
                ",adult = '" + adult + '\'' +
                ",vote_count = '" + voteCount + '\'' +
                "}";
    }

    public List<SpokenLanguageEntity> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(
        List<SpokenLanguageEntity> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public List<ProductionCompanyEntity> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(
        List<ProductionCompanyEntity> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public CollectionEntity getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setBelongsToCollection(
        CollectionEntity belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }
}
