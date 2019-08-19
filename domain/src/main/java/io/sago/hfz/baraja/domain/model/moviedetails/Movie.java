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
package io.sago.hfz.baraja.domain.model.moviedetails;

import java.util.List;

/**
 * Class that represents a Movie in the domain layer.
 */
public class Movie {

    private int id;

    private String originalLanguage;

    private String originalTitle;

    private String title;

    private String overview;

    private boolean video;

    private String backdropPath;

    private String posterPath;

    private double popularity;

    private boolean adult;

    private double voteAverage;

    private int voteCount;

    private String releaseDate;

    private String imdbId;

    private int revenue;

    private int budget;

    private int runtime;

    private String tagline;

    private String homepage;

    private String status;

    private List<Integer> genreIds;

    private List<GenresItem> genres;

    private List<ProductionCountriesItem> productionCountries;

    private List<SpokenLanguagesItem> spokenLanguages;

    private List<ProductionCompaniesItem> productionCompanies;

    private BelongsToCollection belongsToCollection;

    public Movie(int id) {
        this.id = id;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
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

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public List<GenresItem> getGenres() {
        return genres;
    }

    public void setGenres(List<GenresItem> genres) {
        this.genres = genres;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public List<ProductionCountriesItem> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountriesItem> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<SpokenLanguagesItem> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguagesItem> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public List<ProductionCompaniesItem> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompaniesItem> productionCompanies) {
        this.productionCompanies = productionCompanies;
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

    public BelongsToCollection getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setBelongsToCollection(BelongsToCollection belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
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

    @Override
    public String toString() {
        return
            "Response{" +
                "original_language = '" + originalLanguage + '\'' +
                ",imdb_id = '" + imdbId + '\'' +
                ",video = '" + video + '\'' +
                ",title = '" + title + '\'' +
                ",backdrop_path = '" + backdropPath + '\'' +
                ",revenue = '" + revenue + '\'' +
                ",genres = '" + genres + '\'' +
                ",popularity = '" + popularity + '\'' +
                ",production_countries = '" + productionCountries + '\'' +
                ",id = '" + id + '\'' +
                ",vote_count = '" + voteCount + '\'' +
                ",budget = '" + budget + '\'' +
                ",overview = '" + overview + '\'' +
                ",original_title = '" + originalTitle + '\'' +
                ",runtime = '" + runtime + '\'' +
                ",poster_path = '" + posterPath + '\'' +
                ",spoken_languages = '" + spokenLanguages + '\'' +
                ",production_companies = '" + productionCompanies + '\'' +
                ",release_date = '" + releaseDate + '\'' +
                ",vote_average = '" + voteAverage + '\'' +
                ",belongs_to_collection = '" + belongsToCollection + '\'' +
                ",tagline = '" + tagline + '\'' +
                ",adult = '" + adult + '\'' +
                ",homepage = '" + homepage + '\'' +
                ",status = '" + status + '\'' +
                "}";
    }
}
