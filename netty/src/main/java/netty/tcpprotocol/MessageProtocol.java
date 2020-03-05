package netty.tcpprotocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageProtocol {
    private int len;
    private byte[] content;
}
