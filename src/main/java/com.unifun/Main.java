package com.unifun;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        Vector vector1 = new Vector(-3,-1,-9,-3);
        Vector vector2 = new Vector(-2,10,-7,4);
        Vector translation = new Vector(0, -2);
        Operation operation =new Operation();

        Vector suma = operation.sumVector(vector1,vector2);
        LOGGER.info("Suma " + suma.toString());


        LOGGER.info(operation.returnCadran(vector1));
    }
}
