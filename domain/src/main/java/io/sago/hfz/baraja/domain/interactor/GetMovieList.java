/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.sago.hfz.baraja.domain.interactor;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.sago.hfz.baraja.domain.executor.PostExecutionThread;
import io.sago.hfz.baraja.domain.executor.ThreadExecutor;
import io.sago.hfz.baraja.domain.model.Movie;
import io.sago.hfz.baraja.domain.repository.UserRepository;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link Movie}.
 */
public class GetMovieList extends UseCase<List<Movie>, Void> {

  private final UserRepository userRepository;

  @Inject
  GetMovieList(UserRepository userRepository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.userRepository = userRepository;
  }

  @Override Observable<List< Movie>> buildUseCaseObservable(Void unused) {
    return this.userRepository.movies();
  }
}
