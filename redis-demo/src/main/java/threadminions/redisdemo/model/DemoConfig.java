package threadminions.redisdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("CONFIG")
public class DemoConfig implements Serializable {

    private String id;
    private String apiName;
    private String apiGroup;
    private @Indexed String orgId;
    private @Indexed  String appId;
    private RequestDefinition requestDefinition;

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class RequestDefinition implements Serializable{

    String url;
    String method;
    String requestType;
}
