package util;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.util.Set;

@Slf4j
public class JsonUtil {
    public static String toJson(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("toJson异常", e);
        }
        return null;
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true);
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            log.error("fromJson异常，json=" + json, e);
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        String content = "{\n" +
                "\t\"a\": 1,\n" +
                "\t\"b\": 2\n" +
                "}";
        JSON parse = JSONUtil.parse(content);
        JSONObject jsonObject = JSONUtil.parseObj(content);
        Set<String> strings = jsonObject.keySet();
        System.out.println(strings);

    }
}
