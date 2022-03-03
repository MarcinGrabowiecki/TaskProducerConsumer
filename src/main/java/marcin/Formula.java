package marcin;

import java.util.Random;

public class Formula {
    private final static int MAX_NUM=9999999;
    private final static int MIN_FORMULA_LEN=10;
    private final static int MAX_FORMULA_LEN=1000;
    private final static String OPERATION_POOL ="+/*-";
    private final Random ran=new Random();

    public String generateRandom(){
        StringBuffer formula=new StringBuffer();
        while(formula.length()< ran.nextInt(MAX_FORMULA_LEN)+MIN_FORMULA_LEN) {
            formula.append(ran.nextInt(MAX_NUM));
            formula.append(OPERATION_POOL.charAt(ran.nextInt(OPERATION_POOL.length())));
        }
        return formula.toString().substring(0,formula.length()-1);
    }
}
