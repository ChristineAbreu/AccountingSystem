package za.ac.nwu.logic.flow.impl;

public class Modulo {

    public Integer doMod(int divided, int divisor) throws Exception {
if (divisor == 0){
    throw new Exception("Exception");
}

        return divided % divisor;
    }
}
