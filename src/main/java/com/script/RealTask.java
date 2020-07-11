package com.script;

// 模拟一个实时任务
public class RealTask {
    public static void main(String[] args) throws InterruptedException {
        Script script = new Script();
        int loop = 0;
        while (loop>100){
            script.run();
            Thread.sleep(5000);
            loop++;
        }
    }
}
