package com.example.learnmybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KDataBackTest {
    @TableId(type = IdType.AUTO)
    Long id;
    String code;
    String date;
    Double open;
    Double high;
    Double close;
    Double low;
    Double volume;
    Double turnover;
    Integer zigzagFlag;
    String kType;
    Long linuxTime;
    Double lastClose;//昨收
    Double amount;//成交额
    Double trueRange;//真实波动数值
    Double trueRangeR;//真实波幅百分比
    Double ma10TrueRangeR;//近10日平均真实振幅
    Double openChangePercent;//开盘涨跌幅
    Double closeChangePercent;//涨跌幅
    Double score1;//当日打分
    Double score2;//前2日打分
    Double score3;//前3日上涨打分
    Double score4;//前4日上涨打分
    Double score5;//前5日上涨打分
    Integer score5Index;
    Double score1w;
    Double score2w;
    Double score3w;
    Double score4w;
    Double score5w;
}
