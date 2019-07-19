package threadminions.resttemplateerror.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class RestErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

        String body = new BufferedReader(new InputStreamReader(clientHttpResponse.getBody()))
                .lines().collect(Collectors.joining("\n"));

        String message;
        System.out.println("Status Code from Cloud Server:"+clientHttpResponse.getStatusCode().series());
        if(clientHttpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR)
        {
            message = "Some error occurred when making client request: " + body;
        }
        else if(clientHttpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR)
        {
            message = "Error body receive from target server: " + body;
        }
        else if (clientHttpResponse.getStatusCode() == NOT_FOUND)
        {
            message = "Either URL is wrong and you are trying to hit wrong API: " + body;
        }
        else {
            message = "Some error occurred in making request to target server because of : " + body;
        }

        System.out.println(message);

        throw new CustomException(message);
    }
}
