package jinwoo.library.api;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class ApiKeys {

    @Value("${coolsms-api-key}")
    private String smsApiKey;

    @Value("${coolsms-api-secret}")
    private String smsApiSecret;
}
