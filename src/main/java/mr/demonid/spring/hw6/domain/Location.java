package mr.demonid.spring.hw6.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Location {
    private Integer id;             // The id of the location.
    private String name;            // The name of the location.
    private String type;            // The type of the location.
    private String dimension;       // The dimension in which the location is located.
    private List<String> residents; // List of character who have been last seen in the location. (urls)
    private String url;             // Link to the location's own endpoint.
    private LocalDateTime created;  // Time at which the location was created in the database.
}
