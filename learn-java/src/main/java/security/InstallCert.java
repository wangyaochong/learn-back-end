package security;

// 1 Subject CN=*.aliyun.com, O="Alibaba (China) Technology Co., Ltd.", L=HangZhou, ST=ZheJiang, C=CN
//   Issuer  CN=GlobalSign Organization Validation CA - SHA256 - G2, O=GlobalSign nv-sa, C=BE
//   sha1    f1 e6 55 4d 32 ef 89 6c d5 e3 fb f4 6e e5 6e 4a 5c 56 92 79
//   md5     5a 13 16 bd 13 10 e5 71 1d 39 ae a0 5a 51 52 a2
//
// 2 Subject CN=GlobalSign Organization Validation CA - SHA256 - G2, O=GlobalSign nv-sa, C=BE
//   Issuer  CN=GlobalSign Root CA, OU=Root CA, O=GlobalSign nv-sa, C=BE
//   sha1    90 2e f2 de eb 3c 5b 13 ea 4c 3d 51 93 62 93 09 e2 31 ae 55
//   md5     d3 e8 70 6d 82 92 ac e4 dd eb f7 a8 bb bd 56 6b
import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.UUID;

//具体信息可以参考博客:https://blog.csdn.net/chaishen10000/article/details/82992291
//将生成的密钥放到jre/lib/security目录下

public class InstallCert {
    public static void main(String[] args) throws Exception {

        args = new String[1];
        args[0] = "maven.aliyun.com";//这个位置输入需要生成证书的地址

        String host;
        int port;
        char[] passphrase;
        if ((args.length == 1) || (args.length == 2)) {
            String[] c = args[0].split(":");
            host = c[0];
            port = (c.length == 1) ? 443 : Integer.parseInt(c[1]);
            String p = (args.length == 1) ? "changeit" : args[1];
            passphrase = p.toCharArray();
        } else {
            System.out.println("Usage: java InstallCert <host>[:port] [passphrase]");
            return;
        }

        File file = new File("jssecacerts");
        if (file.isFile() == false) {
            char SEP = File.separatorChar;
            File dir = new File(System.getProperty("java.home") + SEP
                    + "lib" + SEP + "security");
            file = new File(dir, "jssecacerts");
            if (file.isFile() == false) {
                file = new File(dir, "cacerts");
            }
        }
        System.out.println("Loading KeyStore " + file + "...");
        InputStream in = new FileInputStream(file);
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        ks.load(in, passphrase);
        in.close();

        SSLContext context = SSLContext.getInstance("TLS");
        TrustManagerFactory tmf =
                TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(ks);
        X509TrustManager defaultTrustManager = (X509TrustManager) tmf.getTrustManagers()[0];
        SavingTrustManager tm = new SavingTrustManager(defaultTrustManager);
        context.init(null, new TrustManager[]{tm}, null);
        SSLSocketFactory factory = context.getSocketFactory();

        System.out.println("Opening connection to " + host + ":" + port + "...");
        SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
        socket.setSoTimeout(10000);
        try {
            System.out.println("Starting SSL handshake...");
            socket.startHandshake();
            socket.close();
            System.out.println();
            System.out.println("No errors, certificate is already trusted");
        } catch (SSLException e) {
            System.out.println();
            e.printStackTrace(System.out);
        }

        X509Certificate[] chain = tm.chain;
        if (chain == null) {
            System.out.println("Could not obtain server certificate chain");
            return;
        }

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        System.out.println("Server sent " + chain.length + " certificate(s):");
        System.out.println();
        MessageDigest sha1 = MessageDigest.getInstance("SHA1");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        for (int i = 0; i < chain.length; i++) {
            X509Certificate cert = chain[i];
            System.out.println
                    (" " + (i + 1) + " Subject " + cert.getSubjectDN());
            System.out.println("   Issuer  " + cert.getIssuerDN());
            sha1.update(cert.getEncoded());
            System.out.println("   sha1    " + toHexString(sha1.digest()));
            md5.update(cert.getEncoded());
            System.out.println("   md5     " + toHexString(md5.digest()));
            System.out.println();
        }

//        System.out.println("Enter certificate to add to trusted keystore or 'q' to quit: [1]");
//        String line = reader.readLine().trim();
//        int k;
//        try {
//            k = (line.length() == 0) ? 0 : Integer.parseInt(line) - 1;
//        } catch (NumberFormatException e) {
//            System.out.println("KeyStore not changed");
//            return;
//        }

        for (int i = 0; i < chain.length; i++) {
            X509Certificate cert = chain[i];
            String alias = host + "-" + (i + 1);
            ks.setCertificateEntry(alias, cert);

            OutputStream out = new FileOutputStream("my" + UUID.randomUUID().toString().replaceAll("-", "") + "ssecacerts");
            ks.store(out, passphrase);
            out.close();
        }

//        X509Certificate cert = chain[k];
//        String alias = host + "-" + (k + 1);
//        ks.setCertificateEntry(alias, cert);
//
//        OutputStream out = new FileOutputStream("jssecacerts");
//        ks.store(out, passphrase);
//        out.close();
//
//        System.out.println();
//        System.out.println(cert);
//        System.out.println();
//        System.out.println
//                ("Added certificate to keystore 'jssecacerts' using alias '"
//                        + alias + "'");
    }

    private static final char[] HEXDIGITS = "0123456789abcdef".toCharArray();

    private static String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 3);
        for (int b : bytes) {
            b &= 0xff;
            sb.append(HEXDIGITS[b >> 4]);
            sb.append(HEXDIGITS[b & 15]);
            sb.append(' ');
        }
        return sb.toString();
    }

    private static class SavingTrustManager implements X509TrustManager {

        private final X509TrustManager tm;
        private X509Certificate[] chain;

        SavingTrustManager(X509TrustManager tm) {
            this.tm = tm;
        }

        public X509Certificate[] getAcceptedIssuers() {
            throw new UnsupportedOperationException();
        }

        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
            throw new UnsupportedOperationException();
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
            this.chain = chain;
            tm.checkServerTrusted(chain, authType);
        }
    }

}
