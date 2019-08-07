package threadminions.utility.connector;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import threadminions.utility.conditions.HttpCondition;
import threadminions.utility.model.HttpConnectorProperties;

@Configuration
@Conditional({HttpCondition.class})
@EnableConfigurationProperties(HttpConnectorProperties.class)
public class HttpConnectorAutoConfiguration {

    @Bean
    public HttpConnector httpConnector()
    {
        return new HttpConnector();
    }
}
