package com.wangshuo.chapter12;


/**
 * Created by Administrator on 2017/12/1.
 */
class Test implements Runnable
{
    private boolean flag;
    Test(boolean flag){
        this.flag=flag;
    }

    @Override
    public void run() {
        if(flag){
            synchronized (Mylock.locka){
                System.out.println("if........locka....");
                synchronized (Mylock.lockb){
                    System.out.println("if........lockb....");
                }
            }

        }else{
            synchronized (Mylock.lockb){
                System.out.println("else........lockb....");
                synchronized (Mylock.locka){
                    System.out.println("else........locka....");
                }
            }
        }
    }
}

class Mylock{
    public static final Mylock locka=new Mylock();
    public static final Mylock lockb=new Mylock();
}
public class DeadLockTest {
    public static void main(String[] args){
        Test t=new Test(true);
        Test b=new Test(false);
        Thread t1=new Thread(t);
        Thread t2=new Thread(b);
        t1.start();
        t2.start();

    }
}
