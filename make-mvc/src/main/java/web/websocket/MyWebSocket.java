package web.websocket;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.function.*;

/**
 * 这个案例是给每个客户端打印sessionId
 *
 * @author wangyaochong
 * @date 2020/3/29 14:06
 */

@ServerEndpoint(value = "/hello", configurator = GetHttpSessionConfig.class)
@Data
@EqualsAndHashCode(callSuper = true)
public class MyWebSocket extends Endpoint {
    private static Map<Session, HttpSession> onlineSession = new HashMap<>();

    interface MyFunc {
        void method(Session session, Supplier<String> param, BiConsumer<Session, String> send);
    }

    BiConsumer<Session, String> sessionSendMethod = (session, text) -> {
        try {
            session.getBasicRemote().sendText(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
    MyFunc fullSendMethod = (session, param, func) -> {
        func.accept(session, param.get());
    };

    //    如果不继承，需要使用@OnOpen注解
    @Override
    public void onOpen(Session session, EndpointConfig config) {
        onlineSession.put(session, (HttpSession) config.getUserProperties().get(HttpSession.class.getName()));
        System.out.println(getNames());
        onlineSession.keySet().forEach(oneSession -> fullSendMethod.method(oneSession, MyWebSocket::getNames, sessionSendMethod));//发送所有session的Id
        session.addMessageHandler(String.class, message -> //添加消息处理器，广播消息
                onlineSession.keySet().forEach(oneSession -> fullSendMethod.method(oneSession, () -> "新消息：" + message, sessionSendMethod)));
    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        HttpSession remove = onlineSession.remove(session);//发送一个session的Id
        onlineSession.keySet().forEach(oneSession -> fullSendMethod.method(oneSession, () -> "下线了：" + remove.getId(), sessionSendMethod));
    }

    private static String getNames() {
        return Arrays.toString(onlineSession.values().stream().map(HttpSession::getId).toArray());
    }
}
