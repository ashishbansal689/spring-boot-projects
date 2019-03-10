package threadminions.redisdemo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import threadminions.redisdemo.repository.RedisConfigRepo;
import threadminions.redisdemo.repository.RedisRepo;

import java.util.List;
import java.util.UUID;

@RestController
public class ConfigController1 {

    @Autowired
    RedisRepo redisRepo;

    @Autowired
    RedisConfigRepo repo;


    @GetMapping("add1")
    public String addConfig()
    {
        DemoConfig config = new DemoConfig();
        config.setOrgId("PLATWARE");
        config.setAppId("ADMINPORTAL");
        config.setApiName("AADhAAR_INTEGRATION");
        String id = UUID.randomUUID().toString();

        config.setId(id);

        config.setRequestDefinition(new RequestDefinition());

       repo.save(config);

        return "successfully added with Id: " + id;
    }

    @GetMapping("get1/{id}")
    public DemoConfig getConfig(@PathVariable String id)
    {
        return repo.findById(id).get();
    }

    @GetMapping("all1")
    public Iterable<DemoConfig> getAll()
    {
        return repo.findAll();
    }

    @GetMapping("findBy/{orgId}/{appId}")
    public List<DemoConfig> findby(@PathVariable String orgId, @PathVariable String appId){

        repo.findAllByOrgIdAndAppId(orgId, appId);
        return repo.findByOrgIdAndAppId(orgId, appId);}
}
