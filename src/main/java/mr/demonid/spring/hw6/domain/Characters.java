package mr.demonid.spring.hw6.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Characters {
    private Integer id;             // The id of the character.
    private String name;            // The name of the character.
    private String status;          // The status of the character ('Alive', 'Dead' or 'unknown').
    private String species;         // The species of the character.
    private String type;            // The type or subspecies of the character.
    private String gender;          // The gender of the character ('Female', 'Male', 'Genderless' or 'unknown').
    private ObjLink origin;         // Name and link to the character's origin location.
    private ObjLink location;       // Name and link to the character's last known location endpoint.
    private String image;           // Link to the character's image. All images are 300x300px and most are medium shots or portraits since they are intended to be used as avatars.
    private List<String> episode;   // List of episodes in which this character appeared.
    private String url;             // Link to the character's own URL endpoint.
    private LocalDateTime created;  // Time at which the character was created in the database.

    // поля для предварительной загрузки локаций
    private Location originLocation;
    private Location currentLocation;
}
