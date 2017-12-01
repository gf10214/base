package com.wangshuo.chapter12;

/**
 * Created by Administrator on 2017/12/1.
 */
//饿汉
class Single1{
    private static final Single1 s=new Single1();
    private Single1(){
    }
    public static Single1 getInstance(){
        return s;
    }
}
//懒汉 会有同步问题
class Single2{
    private static Single2 s=null;
    private Single2(){}
    public static  Single2 getInstance(){
        if(s==null){
            synchronized (Single2.class){
                if(s==null){
                    s=new Single2();
                }
            }
        }
        return s;
    }
}
public class SingleDemo {
    public static void main(String[] args){

    }
}
