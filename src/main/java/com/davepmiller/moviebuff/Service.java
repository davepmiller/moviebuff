package com.davepmiller.moviebuff;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
class Service {
    private JdbcTemplate jdbcTemplate;
    private static String[] genres = new String[]{
        "Suspense",
        "Comedy",
        "Romance",
        "Fantasy",
        "Sci-Fi",
        "Action",
        "Thriller",
        "Horror",
        "Documentary",
        "Drama"
    };

    @Autowired
    Service(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        initDb();
    }

    Movie getMovie(Long id) {
        return jdbcTemplate.queryForObject(Query.SELECT, new Object[] { id }, new MovieMapper());
    }

    List<Movie> getMovies() {
        return jdbcTemplate.query(Query.SELECT_ALL, new MovieMapper());
    }

    String[] getGenres() {
        return genres;
    }

    boolean createMovie(Movie movie) {
        return jdbcTemplate.update(Query.INSERT, movie.getName(), movie.getGenre(), movie.getRating()) > 0;
    }

    boolean deleteMovie(Long id) {
        return jdbcTemplate.update(Query.DELETE, id) > 0;
    }

    boolean updateMovie(Movie newData) {
        return jdbcTemplate.update(
            Query.UPDATE, newData.getName(), newData.getGenre(), newData.getRating(), newData.getId()) > 0;
    }

    private void initDb() {
        jdbcTemplate.execute(Query.DROP_TABLE);
        jdbcTemplate.execute(Query.CREATE_TABLE);
        final List<Movie> movies = Arrays.asList(
            Movie.builder().name("High Fidelity").genre("Comedy").rating(4).build(),
            Movie.builder().name("The Dark Crystal").genre("Fantasy").rating(5).build(),
            Movie.builder().name("Purple Rain").genre("Romance").rating(3).build(),
            Movie.builder().name("Heat").genre("Suspense").rating(3).build());
        jdbcTemplate.batchUpdate(Query.INSERT, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, movies.get(i).getName());
                ps.setString(2, movies.get(i).getGenre());
                ps.setInt(3, movies.get(i).getRating());
            }

            @Override
            public int getBatchSize() {
                return movies.size();
            }
        });
    }
}
