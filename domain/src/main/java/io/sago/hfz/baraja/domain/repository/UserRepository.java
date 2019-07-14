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
package io.sago.hfz.baraja.domain.repository;

import java.util.List;

import io.reactivex.Observable;
import io.sago.hfz.baraja.domain.model.Movie;

/**
 * Interface that represents a Repository for getting
 * {@link io.sago.hfz.baraja.domain.model.Movie} related data.
 */
public interface UserRepository {

    /**
     * Get an {@link Observable} which will emit a List of
     * {@link io.sago.hfz.baraja.domain.model.Movie}.
     */
    Observable<List<Movie>> movies();

    /**
     * Get an {@link Observable} which will emit a {@link Movie}.
     *
     * @param userId The user id used to retrieve user data.
     */
    Observable<Movie> movie(final int userId);
}
