package com.learnspringboot;

import java.util.Enumeration;
import java.util.Properties;

public class UtilProperties {
    public static void display(Properties properties){
        Enumeration<String> enumeration = (Enumeration<String>) properties.propertyNames();
        while (enumeration.hasMoreElements()){
            String key = enumeration.nextElement();
            String property = properties.getProperty(key);
            System.out.println("key="+key+"|value="+property);
        }
    }
}
