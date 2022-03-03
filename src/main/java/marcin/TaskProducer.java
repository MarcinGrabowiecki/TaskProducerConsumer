package marcin;

import java.util.concurrent.ConcurrentLinkedDeque;

public class TaskProducer implements Runnable{

        private final int size_max=1000;
        private ConcurrentLinkedDeque<String> concurrentLinkedDeque;

        TaskProducer(ConcurrentLinkedDeque concurrentLinkedDeque){
                this.concurrentLinkedDeque=concurrentLinkedDeque;
        }


        public void run() {
                FormulaGenerator rf=new FormulaGenerator();
                while(true) {
                        while (concurrentLinkedDeque.size() < size_max) {
                                concurrentLinkedDeque.offer(rf.generateRandom());
                        }
                        while(concurrentLinkedDeque.size() < size_max/2) {
                                try {
                                        Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                        e.printStackTrace();
                                }
                        }
                }
        }



}
