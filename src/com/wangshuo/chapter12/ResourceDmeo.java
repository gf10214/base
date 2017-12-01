package com.wangshuo.chapter12;

/**
 * Created by Administrator on 2017/12/1.
 */
//资源
class Resource{
    boolean flag=false;
    String name;
    String sex;
}
//输入
class Input implements Runnable{
    Resource r;
    public Input(Resource r){
        this.r=r;
    }
    @Override
    public void run() {
        int x=0;

        while(true){

            synchronized (r) {
                if (r.flag) {
                    try {
                        r.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (x == 0) {
                    r.name = "王硕";
                    r.sex = "13";
                } else {
                    r.name = "张三";
                    r.sex = "5";
                }
                r.flag = true;
                r.notify();
            }
            x=(x+1)%2;

        }
    }
}
class Output implements Runnable{
    Resource r;
    public Output(Resource r){
        this.r=r;
    }
    @Override
    public void run() {
        while (true){
            synchronized (r){
                if(!r.flag) {
                    try {
                        r.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(r.name+"......."+r.sex);
                r.flag=false;
                r.notify();
            }
        }
    }
}
public class ResourceDmeo {

    public static void main(String[] args){
        Resource r=new Resource();
        Input in=new Input(r);
        Output out=new Output(r);
        Thread t1=new Thread(in);
        Thread t2=new Thread(out);
        t1.start();
        t2.start();

    }
}
