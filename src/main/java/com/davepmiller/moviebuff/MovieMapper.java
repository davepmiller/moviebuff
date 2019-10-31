package com.davepmiller.moviebuff;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MovieMapper implements RowMapper<Movie> {
  public Movie mapRow(ResultSet rs, int i) throws SQLException {
    Movie movie = new Movie();
    movie.setId(rs.getLong("id"));
    movie.setName(rs.getString("name"));
    movie.setGenre(rs.getString("genre"));
    movie.setRating(rs.getInt("rating"));

    return movie;
  }
}
