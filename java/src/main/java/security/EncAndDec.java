package security;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import javax.crypto.SecretKey;
import java.nio.charset.Charset;

/**
 * @author wangyaochong
 * @date 2020/3/24 15:44
 */
public class EncAndDec {
    public static void main(String[] args) {
//        String content = "test中文，这是需要加密的内容";
        String content = "www.baidu.com";

        SecretKey secretKey = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue(), "123456789sjkwdfj".getBytes());//
        byte[] key = secretKey.getEncoded();
        System.out.println(new String(key));
        System.out.println(secretKey.getFormat());

// 如果不想生成，可以指定自己的key，其实对于访问地址的加密，是可以每次都生成不同的key的
// （不过需要确保不同的服务器上的密钥相同）
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);


        byte[] encrypt = aes.encrypt(content, Charset.forName("utf-8"));
        byte[] decrypt = aes.decrypt(encrypt);
        System.out.println(new String(decrypt, Charset.forName("utf-8")));

        //加密为16进制表示
        String encryptHex = aes.encryptHex(content);
        System.out.println("加密16进制=" + encryptHex);
        String decryptStr16 = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println("解密16进制=" + decryptStr16);

        //加密为base64
        String encryptBase64 = aes.encryptBase64(content);
        System.out.println("加密base64=" + encryptBase64);
        String decryptStr64 = aes.decryptStr(encryptBase64);
        System.out.println("解密base64=" + decryptStr64);

    }
}
