package threadminions.utility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class UtilityStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtilityStarterApplication.class, args);
    }

}
