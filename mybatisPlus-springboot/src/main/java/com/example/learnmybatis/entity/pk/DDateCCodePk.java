package com.example.learnmybatis.entity.pk;//package wangyaochong.tfp.entity.pk;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.io.Serializable;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class DDateCCodePk implements Serializable {
//    String dDate;
//    String cCode;
//    @Override
//    public boolean equals(Object obj) {
//        DDateCCodePk t= (DDateCCodePk) obj;
//        return this.dDate.equals(t.dDate)&&this.cCode.equals(t.cCode);//只要是同一天，同一个代码，就作为一条记录
//    }
//    @Override
//    public int hashCode() {
//        return Integer.parseInt(this.cCode);
//    }
//}