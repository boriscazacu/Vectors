package com.unifun;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        Vector vector1 = new Vector(1,1,3,-3);
        Vector vector2 = new Vector(1,1,4,1);
        Operation operation =new Operation();
        JFrame f=new JFrame();//creating instance of JFrame

        /*Vector sum = operation.sumVector(vector1, vector2);
        LOGGER.info(sum.toString());*/
        float angle = operation.angleOfVector(vector1);
        LOGGER.info("Unghiul " + angle);
        new Json(vector2, angle);

    }


}
