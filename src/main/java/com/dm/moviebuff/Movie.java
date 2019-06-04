package com.dm.moviebuff;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Movie {
    private @Getter @Setter String name;
    private @Getter @Setter String genre;
    private @Getter @Setter int rating;
}
