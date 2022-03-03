package marcin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormulaEvaluatorTest {

    @Test
    void evaluateShouldCalculateFormula() {
        //given
        final String formula="2+2*2";
        //when
        final String result=new FormulaEvaluator().evaluate(formula);
        //then
        assertEquals(result,"6.0");
    }

    @Test
    void evaluateShouldThrowExpressionWhenFormulaIncorrect() {
        //given
        final String formula="2+2*2x";
        //when
        //then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            final String result=new FormulaEvaluator().evaluate(formula);
        });
    }

}