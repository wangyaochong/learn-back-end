package com.wangyaochong.aop;

import lombok.Data;

/**
 * @author wangyaochong
 * @date 2020/3/27 11:12
 */
@Data
public class WAopConfig {
    String pointCut;
    String aspectBefore;
    String aspectAfter;
    String aspectClass;
    String aspectAfterThrow;
    String aspectAfterThrowingName;
}
