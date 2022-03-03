package marcin;

import org.junit.jupiter.api.Test;

import javax.script.ScriptException;

class RandomFormulaTest {

    @Test
    public void test() throws ScriptException {
        Formula rf=new Formula();
        System.out.println(rf.generateRandom());

    }
}