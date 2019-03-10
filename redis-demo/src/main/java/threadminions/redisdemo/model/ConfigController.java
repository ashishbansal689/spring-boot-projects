package threadminions.redisdemo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import threadminions.redisdemo.repository.RedisRepo;

import java.util.UUID;

@RestController
public class ConfigController {

    @Autowired
    RedisRepo redisRepo;


    @GetMapping("add")
    public String addConfig()
    {
        DemoConfig config = new DemoConfig();
        config.setOrgId("PLATWARE");
        config.setAppId("ADMINPORTAL");
        config.setApiName("AADhAAR_INTEGRATION");
        String id = UUID.randomUUID().toString();

        config.setId(id);

        config.setRequestDefinition(new RequestDefinition());

        redisRepo.add(config);

        return "successfully added with Id: " + id;
    }

    @GetMapping("get/{id}")
    public DemoConfig getConfig(@PathVariable String id)
    {
        return redisRepo.findConfig(id);
    }

    @GetMapping("all")
    public Object getAll()
    {
        return redisRepo.findAll();
    }
}
