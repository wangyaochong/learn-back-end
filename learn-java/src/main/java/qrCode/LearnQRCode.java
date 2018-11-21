package qrCode;

import io.nayuki.qrcodegen.QrCode;
import org.springframework.util.StopWatch;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LearnQRCode {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        QrCode qr0 = QrCode.encodeText("http://www.baidu.com", QrCode.Ecc.MEDIUM);
        BufferedImage img = qr0.toImage(4, 5);
        try {
            ImageIO.write(img, "png", new File("qr-code.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stopWatch.stop();
        ;
        System.out.println(stopWatch.getLastTaskTimeMillis());
    }
}
