package threadminions.resttemplateerror;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import threadminions.resttemplateerror.errorhandler.CustomException;
import threadminions.resttemplateerror.errorhandler.RestErrorHandler;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@RunWith(SpringRunner.class)
@RestClientTest
public class RestTemplateErrorApplicationTests {


    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private RestTemplateBuilder builder;

    @Test(expected = CustomException.class)
    public void contextLoads() {

        Assert.assertNotNull(this.builder);
        Assert.assertNotNull(this.server);

        RestTemplate restTemplate = this.builder
                .errorHandler(new RestErrorHandler())
                .build();

        this.server
                .expect(ExpectedCount.once(), requestTo("/abc/com"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.NOT_FOUND));

        restTemplate.getForObject("abc/com",Object.class);
        this.server.verify();
    }

}
