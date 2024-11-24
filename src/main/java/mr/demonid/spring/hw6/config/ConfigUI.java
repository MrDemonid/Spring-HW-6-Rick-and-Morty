package mr.demonid.spring.hw6.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Настройки UI. Пока только кол-во кнопок перехода по страницам.
 */
@Data
@ConfigurationProperties(prefix = "config.ui")
public class ConfigUI {
    private Integer windowPageSize;
}
