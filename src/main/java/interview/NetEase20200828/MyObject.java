package interview.NetEase20200828;

public class MyObject {

    private volatile static MyObject instance;

    private MyObject() {

    }

    /**
     * instance = new Instance(),分为三步
     * 1、分配对象内存空间
     * 2、初始化对象
     * 3、设置instance指向分配的内存地址，此时instance != null
     * 2和3不存在数据依赖关系，可能会指令重排
     * @return
     */
    public static MyObject getInstance() {
        //instance不为空的情况，直接返回instance,避免多线程调用getInstance()方法时，每次都要竞争锁
        if (instance == null) {
            synchronized (MyObject.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(100);

                    }catch (Exception e) {

                    }
                    instance = new MyObject();
                }
            }
        }
        return instance;
    }



    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();
        MyThread thread4 = new MyThread();
        MyThread thread5 = new MyThread();
        MyThread thread6 = new MyThread();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}
