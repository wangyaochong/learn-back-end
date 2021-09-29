package com.example.feign;

import com.example.feign.interfaces.RemoteService;
import com.netflix.config.ConfigurationManager;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.ribbon.RibbonClient;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        ConfigurationManager.loadPropertiesFromResources("sample-client.properties");

        FeignUser user = new FeignUser();
        user.setUserName("scott");
        System.out.println(user.getUserName());
        RibbonClient client = RibbonClient.create();
        RemoteService service = Feign.builder().client(client).encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder()).target(RemoteService.class, "http://sample-client/");
        for(int i=0;i<10;i++){
            service.getInfo(user);
        }
    }
}
