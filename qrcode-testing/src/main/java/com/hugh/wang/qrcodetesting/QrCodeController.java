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

        StringBuffer buffer = new StringBuffer();
        buffer.append("BEGIN:VCARD");
        buffer.append("\nFN:").append("王欢"); //vcard对象的名称，一个vcard对象必须包含FN类型
//        buffer.append("\nNICKNAME:").append("无"); //表示别名
//        buffer.append("\nPHOTO:").append("无"); // 头像地址
//        buffer.append("\nBDAY:").append("无"); // 出生日期

        // 联系地址有不同的类型,添加自己需要的即可
        /**
         "dom" 国内地址
         "intl" 国际地址
         "parcel"包裹递送地址
         "home" 居住地址;
         "work"工作地址;
         "pref" 有多个地址的时候，优先的地址
         */
        buffer.append("\nADR;TYPE=pref:").append("无");

        // LABEL
        /**
         "dom" 国内地址
         "intl" 国际地址
         "parcel"包裹递送地址
         "home" 居住地址;
         "work"工作地址;
         "pref" 有多个地址的时候，优先的地址
         */
        buffer.append("\nLABEL;TYPE=pref:").append("无");

        // 电话
        /**
         "home"表示家庭电话
         "msg" 表示这个号码支持语音
         "work" 工作电话
         "pref" 表示多个电话中最喜欢使用的电话
         "voice" 声音电话号码
         "fax"传真号码
         "cell" 表示手机电话
         "video" 视频电话
         "pager" 调度电话，估计是总机的电话
         "bbs" 公开的广播系统的电话
         "modem" 调制解调器电话
         "car"汽车电话
         "isdn" ISDN连接电话号码
         "pcs" 个人通信服务电话
         */
        buffer.append("\nTEL;TYPE=work:").append("13699998888");

        // 邮件
        /**
         "internet" 表示一个internet 类型地址
         "x400" 表示是一个 X.400 地址
         "pref"最喜欢使用的邮件电子
         */
        buffer.append("\nEMAIL;TYPE=pref:").append("777777777@qq.com");
        buffer.append("\nGEO:").append("无"); //地理位置信息,经度;纬度
        buffer.append("\nTITLE:").append("无"); //工作位置，工作职能
        buffer.append("\nROLE:").append("无"); //公司的职业
        buffer.append("\nUID:").append("无"); //指定一个全球唯一的个人或资源标识
        buffer.append("\nVERSION:").append("无"); //指定Vcard使用的vcard规范的版本
        buffer.append("\nORG:").append("无");
        buffer.append("END:VCARD");



        BitMatrix bitMatrix = QrCodeUtil.encode(buffer.toString());
        try {
            MatrixToImageWriter.writeToStream(bitMatrix , "png" , response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
