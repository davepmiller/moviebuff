package com.davepmiller.moviebuff;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Movie {
    private @Getter long id;
    private @Getter @Setter String name;
    private @Getter @Setter String genre;
    private @Getter @Setter int rating;
}
