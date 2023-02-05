package jinwoo.library.apikeys;

import lombok.Getter;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ApiKeys {

    private String smsApiKey = "NCSPSSPAUUMYHEAG";
    private String smsApiSecret = "JITMUFAHSSTWMD2K2DUAARSGNJL3R2A5";

}
