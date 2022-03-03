package marcin;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class FormulaEvaluator {
    public String evaluate(String formula){
        DoubleEvaluator eval = new DoubleEvaluator();
        Double result = eval.evaluate(formula);
        return result.toString();
    }
}
