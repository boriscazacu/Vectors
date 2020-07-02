package com.unifun;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        Vector vector1 = new Vector(0,0,5,9);
        Vector vector2 = new Vector(0,0,8,3);
        Operation operation =new Operation();

        Vector suma = operation.Suma(vector1,vector2);
        LOGGER.info(suma.toString());

        Vector dif = operation.Diferenta(vector1, vector2);
        LOGGER.info(dif.toString());
    }
}
