package threadminions.redisdemo.repository;

import threadminions.redisdemo.model.DemoConfig;

public interface RedisRepo {

    void add(DemoConfig demoConfig);

    void delete(String id);

    DemoConfig findConfig(String id);

    Object findAll();
}
