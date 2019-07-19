package threadminions.resttemplateerror.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import threadminions.resttemplateerror.errorhandler.RestErrorHandler;

@Service
public class HttpServiceCall {

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplateBuilder().errorHandler(new RestErrorHandler()).
                build();
    }
}

