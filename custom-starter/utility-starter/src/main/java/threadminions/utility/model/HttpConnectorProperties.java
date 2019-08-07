package threadminions.utility.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;

@Getter
@Setter
@ConfigurationProperties(prefix = "threadminions.connector.http")
public class HttpConnectorProperties {

    private boolean enabled;

    private final Environment environment;

    public HttpConnectorProperties(Environment environment) {
        this.environment = environment;
    }
}
