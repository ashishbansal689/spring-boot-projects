package threadminions.utility.connector;

import org.springframework.http.HttpHeaders;

public class HttpConnector
{
    public Object get(String url, HttpHeaders httpHeaders)
    {
        return "Get request executed successfully";
    }
}

