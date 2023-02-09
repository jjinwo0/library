package jinwoo.library.controller;

import com.google.zxing.WriterException;
import jinwoo.library.service.QrService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class QrController {

    private final QrService qrService;

    @RequestMapping("qr.do")
    public String makeQr(HttpServletRequest request, String storeName) throws WriterException, IOException{

        String fileName = qrService.makeqr(request, storeName);

        return fileName + "png";
    }
}
