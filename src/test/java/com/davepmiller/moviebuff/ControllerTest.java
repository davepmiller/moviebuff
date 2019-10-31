package com.davepmiller.moviebuff;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ControllerTest {
  @Autowired
  private Controller controller;

  @Test
  void whenCreate_isCreated() {
    int expected = controller.getMovies().size() + 1;
    Movie movie = Movie.builder().name("test").genre("test").rating(0).build();
    controller.create(movie);
    int actual = controller.getMovies().size();
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void whenGetMovie_movieIsReturned() {
    List<Movie> movies = controller.getMovies();
    Movie movie = controller.getMovie(movies.get(0).getId());
    assertThat(movie.getId()).isEqualTo(movies.get(0).getId());
  }

  @Test
  void whenUpdate_isUpdated() {
    Movie movie = controller.getMovies().get(0);
    Movie update = Movie.builder()
        .id(movie.getId())
        .name(movie.getName() + movie.getName())
        .genre(movie.getGenre() + movie.getGenre())
        .rating(movie.getRating())
        .build();
    controller.update(update);
    Movie updatedMovie = controller.getMovie(movie.getId());
    assertThat(updatedMovie).isEqualTo(update);
    assertThat(updatedMovie).isNotEqualTo(movie);
  }

  @Test
  void whenDelete_isDeleted() {
    List<Movie> movies = controller.getMovies();
    int expected = movies.size() - 1;
    controller.delete(movies.get(0).getId());
    movies = controller.getMovies();
    int actual = movies.size();
    assertThat(actual).isEqualTo(expected);
  }
}
