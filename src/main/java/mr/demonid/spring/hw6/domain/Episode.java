package mr.demonid.spring.hw6.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Episode {
    Integer id;                 // The id of the episode.
    String name;                // The name of the episode.
    String air_date;            // The air date of the episode.
    String episode;             // The code of the episode.
    List<String> characters;    // List of characters who have been seen in the episode. (urls)
    String url;                 // Link to the episode's own endpoint.
    LocalDateTime created;      // Time at which the episode was created in the database.
}
