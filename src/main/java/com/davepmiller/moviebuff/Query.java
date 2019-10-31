package com.davepmiller.moviebuff;

class Query {
  final static String DROP_TABLE = "DROP TABLE movies IF EXISTS";
  final static String CREATE_TABLE =
      "CREATE TABLE movies(id SERIAL, name varchar(255), genre varchar(255), rating int)";
  final static String SELECT = "SELECT * FROM movies WHERE id = ?";
  final static String SELECT_ALL = "SELECT * FROM movies";
  final static String INSERT = "INSERT INTO movies(name, genre, rating) VALUES (?, ?, ?)";
  final static String UPDATE = "UPDATE movies SET name = ?, genre = ?, rating = ? WHERE id = ?";
  final static String DELETE = "DELETE FROM movies WHERE id = ?";
}
