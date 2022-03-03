package marcin;

import org.junit.jupiter.api.Test;

import javax.script.ScriptException;

class RandomFormulaTest {

    @Test
    public void test() throws ScriptException {
        FormulaGenerator rf=new FormulaGenerator();
        System.out.println(rf.generateRandom());

    }
}