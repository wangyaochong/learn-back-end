package com.example.learnmybatis.enums;

public enum EnumSex {
    MALE(0,"男性"),
    FEMALE(1,"女性");

    private int code;
    private String desc;

    EnumSex(Integer code,String desc){
      this.code=code;
      this.desc=desc;
    }

    public int getCode(){
        return this.code;
    }

    public static EnumSex getFromCode(int code){
        EnumSex[] values = EnumSex.values();
        for (EnumSex value : values) {
            if(code==value.getCode()){
                return value;
            }
        }
        return null;
    }

}
