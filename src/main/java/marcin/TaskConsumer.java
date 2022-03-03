package marcin;

import java.util.Deque;

public class TaskConsumer implements Runnable{

        private Deque<String> deque;

        TaskConsumer(Deque concurrentLinkedDeque){
            this.deque =concurrentLinkedDeque;
        }

        FormulaEvaluator formulaEvaluator=new FormulaEvaluator();

        @Override
        public void run() {
            while(true){
                String formula = deque.poll();
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
