package com.wangyaochong.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author wangyaochong
 * @date 2020/3/25 22:43
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WModelAndView {
    String viewName;
    Map<String, Object> model;

}
