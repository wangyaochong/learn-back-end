package com.wangyaochong.mvc;

import com.wangyaochong.anno.WRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyaochong
 * @date 2020/3/25 22:42
 */
public class WHandlerAdapter {
    public boolean supports(Object handler) {
        return handler instanceof WHandlerMapping;
    }

    public WModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws InvocationTargetException, IllegalAccessException {
        WHandlerMapping handlerMapping = (WHandlerMapping) handler;
        Map<String, Integer> paramMapping = new HashMap<>();
        Annotation[][] pa = handlerMapping.getMethod().getParameterAnnotations();
        for (int i = 0 ; i < pa.length ; i++) {
            for (Annotation annotation : pa[i]) {
                if (annotation instanceof WRequestParam) {
                    String paramName = ((WRequestParam) annotation).value();
                    if (!"".equals(paramName)) {
                        paramMapping.put(paramName, i);
                    }
                }
            }
        }
        Class<?>[] parameterTypes = handlerMapping.getMethod().getParameterTypes();
        for (int i = 0 ; i < parameterTypes.length ; i++) {
            Class<?> type = parameterTypes[i];
            if (type == HttpServletRequest.class || type == HttpServletResponse.class) {
                paramMapping.put(type.getName(), i);
            }
        }

        Map<String, String[]> reqParamMap = request.getParameterMap();
        Object[] paramValues = new Object[parameterTypes.length];
        for (Map.Entry<String, String[]> param : reqParamMap.entrySet()) {
            String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "").replaceAll("\\s", "");
            if (!paramMapping.containsKey(param.getKey())) {
                continue;
            }
            int index = paramMapping.get(param.getKey());
            paramValues[index] = caseStringValue(value, parameterTypes[index]);
        }

        if (paramMapping.containsKey(HttpServletRequest.class.getName())) {
            int reqIndex = paramMapping.get(HttpServletRequest.class.getName());
            paramValues[reqIndex] = request;
        }
        if (paramMapping.containsKey(HttpServletResponse.class.getName())) {
            int reqIndex = paramMapping.get(HttpServletResponse.class.getName());
            paramValues[reqIndex] = response;
        }
        Object result = handlerMapping.getMethod().invoke(handlerMapping.getController(), paramValues);
        if (result == null) {
            return null;
        }
        boolean isModelAndView = handlerMapping.getMethod().getReturnType() == WModelAndView.class;
        if (isModelAndView) {
            return (WModelAndView) result;
        }
        return null;
    }

    private Object caseStringValue(String value, Class<?> clazz) {
        if (clazz == String.class) {
            return value;
        } else if (clazz == Integer.class) {
            return Integer.valueOf(value);
        } else if (clazz == Long.class) {
            return Long.valueOf(value);
        }
        return null;
    }
}
