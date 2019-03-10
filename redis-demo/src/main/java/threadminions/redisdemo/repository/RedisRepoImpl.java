package threadminions.redisdemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import threadminions.redisdemo.model.DemoConfig;

import javax.annotation.PostConstruct;

@Service
public class RedisRepoImpl implements RedisRepo {

    private static final String CONFIG_KEY = "DEMO_CONFIG";


    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations hashOperations;

    @Autowired
    public RedisRepoImpl(RedisTemplate<String, Object> redisTemplate)
    {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void setUp()
    {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void add(DemoConfig demoConfig) {

        hashOperations.put(CONFIG_KEY, demoConfig.getId(), demoConfig);
    }

    @Override
    public void delete(String id) {

        hashOperations.delete(CONFIG_KEY, id);
    }

    @Override
    public DemoConfig findConfig(String id) {
        return (DemoConfig) hashOperations.get(CONFIG_KEY, id);
    }

    @Override
    public Object findAll() {
        return  hashOperations.entries(CONFIG_KEY).values();
    }
}
