package threadminions.utility.conditions;

import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import threadminions.utility.model.HttpConnectorProperties;

public class HttpCondition extends SpringBootCondition {

    public HttpCondition() {}

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        HttpConnectorProperties httpConnectorProperties = getHttpConnectorProperties(context);

        if(!httpConnectorProperties.isEnabled())
            return ConditionOutcome.noMatch("Http Connector is disabled, because threadminions.connector.http.enabled is false" );

        return ConditionOutcome.match();
    }

    private HttpConnectorProperties getHttpConnectorProperties(ConditionContext context) {
        HttpConnectorProperties connectorProperties = new HttpConnectorProperties(context.getEnvironment());
        Binder.get(context.getEnvironment()).bind("threadminions.connector.http", Bindable.ofInstance(connectorProperties));
        return connectorProperties;
    }
}
