package com.wangshuo.chapter12;

/**
 * Created by Administrator on 2017/12/1.
 */
class Bank{
    private int sum;
   // Object object=new Object();
    public synchronized void add(int num){
//        synchronized (object){
            sum+=num;
            System.out.println("sum="+sum);
 //       }
    }
}
class Cus implements Runnable{
    private Bank bank=new Bank();
    @Override
    public void run() {
        for(int i=0;i<3;i++){
            bank.add(100);
        }
    }
}
public class BankDemo {
    public static void main(String[] args){
        Cus cus1=new Cus();
        Thread t1=new Thread(cus1);
        Thread t2=new Thread(cus1);
        t1.start();
        t2.start();
    }
}
