package com.test.code;

/**
 * @author guoyanrui on 2022/3/25
 */
public class April implements Runnable {
    @Override
    public void run() {
        int index=1;
        for(;;){
            System.out.println("这是第"+index+"信息");
            if(index%100==0){
                System.out.println("已经打印了"+index+"消息");
                break;
            }
            index++;
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new April());
        thread.start();
    }
}
