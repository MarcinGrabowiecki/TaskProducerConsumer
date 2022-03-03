package marcin;

import java.util.concurrent.ConcurrentLinkedDeque;

public class TaskConsumer implements Runnable{

        private ConcurrentLinkedDeque<String>concurrentLinkedDeque;

        TaskConsumer(ConcurrentLinkedDeque concurrentLinkedDeque){
            this.concurrentLinkedDeque=concurrentLinkedDeque;
        }

        FormulaEvaluator formulaEvaluator=new FormulaEvaluator();

        @Override
        public void run() {
            while(true){
                String formula = concurrentLinkedDeque.poll();
                if(formula!=null) {
                    System.out.println(formulaEvaluator.evaluate(formula)+"\t"+formula);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

}
