package marcin;

import java.util.Deque;

public class TaskProducer implements Runnable{

        private final int size_max=1000;
        private Deque<String> deque;

        TaskProducer(Deque concurrentLinkedDeque){
                this.deque =concurrentLinkedDeque;
        }

        public void run() {
                FormulaGenerator rf=new FormulaGenerator();
                while(true) {
                        while (deque.size() < size_max) {
                                deque.offer(rf.generateRandom());
                        }
                        while(deque.size() < size_max/2) {
                                try {
                                        Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                        e.printStackTrace();
                                }
                        }
                }
        }
}
