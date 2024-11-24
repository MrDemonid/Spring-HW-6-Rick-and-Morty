package mr.demonid.spring.hw6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("mr.demonid.spring.hw6.config")
public class SpringHw6RickAndMortyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHw6RickAndMortyApplication.class, args);
    }

}
