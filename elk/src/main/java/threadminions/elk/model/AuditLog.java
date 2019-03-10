package threadminions.elk.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.sql.Timestamp;

@SuppressWarnings("WeakerAccess")
@Component
@RequestScope
@Getter
@Setter
@NoArgsConstructor
@Document(indexName = "AUDIT_LOG", type = "logs")
public class AuditLog
{
	@Id
	private int processLogId;
	private String processName;
	private String processSubName;
	private String requestId;
	private Timestamp processRequestTimeStamp;
	private Timestamp processResponseTimeStamp;
	private String responseCode;
	private String responseMessage;
	private String responseStatus;
	private String serverRequestType;
	private String serverUrl;
	private String responseSubCode;
	private String requestInterfaceType;
	private String message;
	private String serverRequestResponseTime;
	private Timestamp serverRequestTime;
	private Timestamp serverResponseTime;
	private String orgId;
	private String appId;
	private String clientRequestHeaders;

	private String igwResponseCode;
	private String apiEndPointRequestMethod;

	private String clientRequestData;
	private String clientResponseData;
	private String serverRequestData;
	private String serverResponseData;


}
