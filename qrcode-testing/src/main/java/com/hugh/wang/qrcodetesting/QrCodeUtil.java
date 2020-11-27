package com.hugh.wang.qrcodetesting;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SalleyGardens
 */
public class QrCodeUtil {

    public static BitMatrix encode(String content ) {
        //设置图片的文字编码以及内边框
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        //编码
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION , ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN , 2 );
        BitMatrix bitMatrix;
        try {
            //参数分别为：编码内容、编码类型、图片宽度、图片高度，设置参数
            bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 300, 300,hints);
        }catch(WriterException e) {
            e.printStackTrace();
            return null;
        }
        return bitMatrix;

    }
}
