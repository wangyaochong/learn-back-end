package io.network;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class IOUtil {
    //读取网络流正确的写法，因为网络流的available可能不能完整的长度，所以需要分多次读取，available每次读取的值不同
    public static byte[] readNetworkStream(InputStream in) throws IOException {
        int size = 0;
        int read;
        List<byte[]> bufferResult = new ArrayList<>();
        do {
            byte[] buffer = new byte[in.available()];
            read = in.read(buffer);
            bufferResult.add(buffer);
            if (read != -1) {
                size += read;
            }
        } while (read != -1);
        byte[] buf = new byte[size];
        int loc = 0;
        for (byte[] bytes : bufferResult) {
            for (int i = 0; i < bytes.length; i++) {
                buf[loc] = bytes[i];
                loc++;
                if (loc >= buf.length) {
                    break;
                }
            }
        }
        in.close();
        return buf;
    }
}
