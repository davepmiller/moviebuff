package com.dm.moviebuff;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
public class MoviebuffController {
    private MoviebuffRepository repository;

    MoviebuffController() {
        this.repository = new MoviebuffRepository();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/movie-genres")
    public String[] movieGenres() {
        return this.repository.getGenres();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/movies")
    public List<Movie> movies() {
        return this.repository.getMovies();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/movies")
    public Movie newEmployee(@RequestBody Movie newEmployee) {
        return this.repository.addMovie(newEmployee);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/movies/{name}")
    public void deleteMovie(@PathVariable String name) {
        this.repository.deleteMovie(name);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/movies/{name}")
    public Movie updateMovie(@PathVariable String name, @RequestBody Movie newData) {
        return this.repository.updateMovie(name, newData);
    }
}