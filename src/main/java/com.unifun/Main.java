package com.unifun;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        Vector vector1 = new Vector(2,2);
        Vector vector2 = new Vector(0,3);
        Operation operation =new Operation();

        Vector suma = operation.sumVector(vector1,vector2);
        LOGGER.info("Suma " + suma.toString());

        Vector dif = operation.difVector(vector1, vector2);
        LOGGER.info("Diferenta " + dif.toString());

        LOGGER.info(operation.angleOfVectors(vector1,vector2));
    }
}
