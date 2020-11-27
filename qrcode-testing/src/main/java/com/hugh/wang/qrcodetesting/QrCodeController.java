package com.hugh.wang.qrcodetesting;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "qrcode")
public class QrCodeController {

    @GetMapping(value = "encode")
    public void encode(HttpServletResponse response){

        BitMatrix bitMatrix = QrCodeUtil.encode("wanghuan");
        try {
            MatrixToImageWriter.writeToStream(bitMatrix , "png" , response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
