package mr.demonid.spring.hw6.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Базовые адреса удаленных объектов
 */
@Data
@ConfigurationProperties(prefix = "url.rickandmortyapi.api")
public class UrlAPI {
    private String characters;
    private String episodes;
    private String locations;
}
