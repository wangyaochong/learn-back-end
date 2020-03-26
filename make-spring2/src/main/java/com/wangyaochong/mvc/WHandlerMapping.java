package com.wangyaochong.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @author wangyaochong
 * @date 2020/3/25 22:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WHandlerMapping {
    private Object controller;
    private Method method;
    private Pattern pattern;

}
