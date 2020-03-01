package 手写redis客户端.protocol;


import java.io.IOException;
import java.io.OutputStream;

public class Protocol {
    private static final String STAR = "*";
    public static final String RETURN = "\r\n";
    public static final String DOLLAR = "$";

    public static void sendCommand(OutputStream outputStream, redis.clients.jedis.Protocol.Command command, byte[]... args) {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(STAR).append(args.length + 1).append(RETURN);
        stringBuffer.append(DOLLAR).append(command.name().length()).append(RETURN);
        stringBuffer.append(command).append(RETURN);
        for (byte[] arg : args) {
            stringBuffer.append(DOLLAR).append(arg.length).append(RETURN);
            stringBuffer.append(new String(arg)).append(RETURN);
        }
        try {
            outputStream.write(stringBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
