package com.wangshuo.chapter12;

/**
 * Created by Administrator on 2017/11/30.
 */
class Ticket implements Runnable{
    private int num=1000;
    Object obj=new Object();
    public void run(){
        while(true){
            synchronized(obj){
                if(num>0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"........sale........"+num--);
                }
            }
        }
    }
}
public class SaleTic {
    public static void main(String[] args){
        Ticket t=new Ticket();
        Thread t1=new Thread(t);
        Thread t2=new Thread(t);
        Thread t3=new Thread(t);
        Thread t4=new Thread(t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
