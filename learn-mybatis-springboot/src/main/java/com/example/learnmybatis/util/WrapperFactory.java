package com.example.learnmybatis.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

public class WrapperFactory<T> {
    public static <T> QueryWrapper<T> getQueryWrapper() {
        return new QueryWrapper<>();
    }

    public static <T> UpdateWrapper<T> getUpdateWrapper() {
        return new UpdateWrapper<>();
    }


    public QueryWrapper<T> queryWrapper() {
        return new QueryWrapper<>();
    }

    public UpdateWrapper<T> updateWrapper() {
        return new UpdateWrapper<>();
    }

    public static <T> WrapperFactory<T> getWrapperFactory() {
        return new WrapperFactory<>();
    }
}
