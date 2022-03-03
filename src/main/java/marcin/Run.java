package marcin;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Run {
    public static void main(String[]args){
        final int size_max=1000;
        ConcurrentLinkedDeque<String> blockingQueue = new ConcurrentLinkedDeque<String>();

        Runnable taskProducer = new Runnable() {
            @Override
            public void run() {
                FormulaGenerator rf=new FormulaGenerator();
                while(true) {
                    while (blockingQueue.size() < size_max) {
                            blockingQueue.offer(rf.generateRandom());
                    }
                    while(blockingQueue.size() < size_max/2) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };


        new Thread(taskProducer).start();
        new Thread(taskProducer).start();

        new Thread(new TaskConsumer(blockingQueue)).start();
        new Thread(new TaskConsumer(blockingQueue)).start();
        new Thread(new TaskConsumer(blockingQueue)).start();
        new Thread(new TaskConsumer(blockingQueue)).start();
    }
}
