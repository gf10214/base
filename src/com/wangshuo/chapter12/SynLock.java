package com.wangshuo.chapter12;

/**
 * Created by Administrator on 2017/12/1.
 */

class Ticket1 implements Runnable{
    private static int num=300;
    boolean flag=true;
  //  Object obj=new Object();
    public  void run(){
        if(flag){
            while(true){
                this.show();
            }
        }else{
            while(true){
                synchronized (this.getClass()){
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

    public static synchronized void show(){
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
public class SynLock {
    public static void main(String[] args){
        Ticket1 t=new Ticket1();
        Thread t1=new Thread(t);
        Thread t2=new Thread(t);

        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag=false;
        t2.start();

    }
}
