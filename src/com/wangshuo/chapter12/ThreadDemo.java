package com.wangshuo.chapter12;

/**
 * Created by Administrator on 2017/11/30.
 */
class Demo extends Thread{
    private String name;
    public Demo(String name){
        super(name);
        this.name=name;
    }
    @Override
    public void run() {
        for(int y=0;y<999;y++){
            System.out.println(name+".....y="+y);
        }

    }
}
public class ThreadDemo {
    public static void main(String[] args){
        Demo demo=new Demo("王硕");
        demo.start();
        for(int y=0;y<999;y++){
            System.out.println("main.....y="+y);
        }

    }
}
