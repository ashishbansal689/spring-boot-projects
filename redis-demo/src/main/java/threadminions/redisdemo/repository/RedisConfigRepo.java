package threadminions.redisdemo.repository;

import org.springframework.data.repository.CrudRepository;
import threadminions.redisdemo.model.DemoConfig;

import java.util.List;

public interface RedisConfigRepo extends CrudRepository<DemoConfig, String> {

    List<DemoConfig> findByApiNameAndApiGroup(String apiName, String apiGroup);

    List<DemoConfig> findByOrgIdAndAppId(String orgId, String appId);

    List<DemoConfig> findAllByOrgIdAndAppId(String orgId, String appId);

    List<DemoConfig> findAllByOrgId(String orgId);
}
