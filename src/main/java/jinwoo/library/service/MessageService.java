package jinwoo.library.service;

import jinwoo.library.api.ApiKeys;
import lombok.RequiredArgsConstructor;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
@RequiredArgsConstructor
public class MessageService {

    private final ApiKeys keys;

    private String apiKey = keys.getSmsApiKey();
    private String apiSecret = keys.getSmsApiSecret();

    public void sendMessage(String toNumber, String randNumber){

        Message coolsms = new Message(apiKey, apiSecret);

        HashMap<String, String> params = new HashMap<>();
        params.put("to", toNumber);
        params.put("from", "02-123-4567");
        params.put("type", "SMS");
        params.put("text", "[Somnium] 인증번호 "+randNumber+" 를 입력하세요.");
        params.put("app_version", "test app 1.2"); // application name and version

        try{
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        }catch (CoolsmsException e){
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }
    }
}
