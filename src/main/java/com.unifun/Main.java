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



        JButton b = new JButton("click");//creating instance of JButton
        f = new JFrame("textfield");
        b.setBounds(130,100,100, 40);//x axis, y axis, width, height

        f.add(b);//adding button in JFrame

        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
    }


}
