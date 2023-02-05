package jinwoo.library.controller;

import jinwoo.library.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SmsController {

    private final MessageService messageService;

    @GetMapping("/check/sendSMS")
    public String sendSMS(String phoneNumber){

        Random random = new Random();
        String numStr = "";

        for (int i=0; i<4; i++){
            String ran = Integer.toString(random.nextInt(10));
            numStr+=ran;
        }

        log.info("수신자 번호: " + phoneNumber);
        log.info("인증 번호: " + numStr);

        messageService.sendMessage(phoneNumber, numStr);

        return numStr;
    }
}
