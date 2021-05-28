package myjava;

public class ForCoverage {

    public int testCoverage(int type){
        if(type==0){
            return method0();
        } else if (type == 1) {
            return method1();
        }else{
            return method2();
        }
    }

    public int method0(){
        return 0;
    }
    public int method1(){
        return 1;
    }
    public int method2(){
        return 2;
    }
}
