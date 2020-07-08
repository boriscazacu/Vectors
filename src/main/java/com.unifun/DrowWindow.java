package com.unifun;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DrowWindow {
    private static final Logger LOGGER = Logger.getLogger(DrowWindow.class);
    // JTextField
    static JTextField firstVector;
    static JTextField secondVector;
    static JFrame frame;
    static JButton button;
    static JButton angle;
    static JButton buttonAdd;
    static JButton buttonDiff;
    static JLabel label;
    static JLabel originea;
    static JLabel virtful;
    static JLabel message;


    // main class
    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        Operation operation = new Operation();
        frame = new JFrame("Vectors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("Operations");
        message = new JLabel("");
        originea = new JLabel("First Vector (x,y,..)");
        virtful = new JLabel("Second Vector (x,y,..)");
        button = new JButton("AngleF");
        angle = new JButton("AngleS");
        buttonAdd = new JButton("+");
        buttonDiff = new JButton("-");
        DrowWindow drowWindow = new DrowWindow();
        Font fo = new Font("Serif", Font.BOLD, 15);

        Dimension size = label.getPreferredSize();
        label.setBounds(195, 150, 400, size.height);
        originea.setBounds(170, 25, 200, size.height);
        virtful.setBounds(165, 70, 200, 50);
        message.setBounds(110, 250, 400, 50);
        message.setForeground(Color.RED);

        firstVector = new JTextField(4);
        firstVector.setBounds(160,48, 130,30);
        secondVector = new JTextField(4);
        secondVector.setBounds(160,110, 130,30);


        //         ------------- Action of buttons ----------------------

        button.addActionListener((ActionEvent e) -> {
            try {
                Vector firstVector = drowWindow.getFirstVector();
                JOptionPane.showMessageDialog(frame,
                        "Angle of first Vector is "+operation.angleOfVector(firstVector),
                        "Angle of first Vector",
                        JOptionPane.PLAIN_MESSAGE);
                message.setText("");
            }catch (Exception exception){
                LOGGER.info("Vectorul este null --- "+exception.getMessage());
            }
        });

        buttonAdd.addActionListener((ActionEvent e) -> {
            try {
                Vector vectorFirst = drowWindow.getFirstVector();
                Vector vectorSecond = drowWindow.getSecondVector();
                Vector sum = operation.sumVector(vectorFirst,vectorSecond);
                DrawVector window = new DrawVector(vectorFirst,vectorSecond,sum);
                window.setVisible(true);
                message.setText("");
            }catch (Exception exception){
                LOGGER.info("Vectorul este null --- "+exception.getMessage());
            }
        });

        buttonDiff.addActionListener((ActionEvent e) -> {
            try {
                Vector vectorFirst = drowWindow.getFirstVector();
                Vector vectorSecond = drowWindow.getSecondVector();
                Vector diff = operation.difVector(vectorFirst,vectorSecond);
                DrawVector window = new DrawVector(vectorFirst,vectorSecond,diff);
                window.setVisible(true);
                message.setText("");
            }catch (Exception exception){
                LOGGER.info("Vectorul este null --- "+exception.getMessage());
            }
        });

        angle.addActionListener((ActionEvent e) -> {
            try {
                Vector vectorSecond = drowWindow.getSecondVector();
                JOptionPane.showMessageDialog(frame,
                        "Angle of second Vector is "+operation.angleOfVector(vectorSecond),
                        "Angle of second Vector",
                        JOptionPane.PLAIN_MESSAGE);
                message.setText("");
            }catch (Exception exception){
                LOGGER.info("Vectorul este null --- "+exception.getMessage());
            }
        });

        //  --------------------  End Action ------------------------------



        button.setBounds(215,180, 75,30);
        button.setBackground(Color.PINK);
        buttonAdd.setBounds(160,180, 50,30);
        buttonAdd.setBackground(Color.PINK);
        buttonDiff.setBounds(240,215, 50,30);
        buttonDiff.setBackground(Color.PINK);
        angle.setBounds(160,215, 75,30);
        angle.setBackground(Color.PINK);

        firstVector.setFont(fo);
        secondVector.setFont(fo);
        buttonDiff.setFont(fo);

        JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);
        panel.add(firstVector);
        panel.add(secondVector);
        panel.add(button);
        panel.add(buttonAdd);
        panel.add(buttonDiff);
        panel.add(angle);
        panel.add(label);
        panel.add(originea);
        panel.add(virtful);
        panel.add(message);
        frame.setSize(460, 370);
        frame.setVisible(true);
    }

//  -------------------- Create vectors from input ------------------------
    public Vector getSecondVector(){
        Vector vector = null;
        Operation operation = new Operation();
        if ( !secondVector.getText().isEmpty()) {
            String[] second = secondVector.getText().split(",");
            vector = new Vector(
                    Integer.parseInt(second[0]),
                    Integer.parseInt(second[1]),
                    Integer.parseInt(second[2]),
                    Integer.parseInt(second[3])
            );
        }else {
            message.setText("Enter the coordinates of the second Vector");
        }
        vector = operation.scalingVector(vector, 20);
        return vector;
    }
    public Vector getFirstVector(){
        Vector vector = null;
        Operation operation = new Operation();
        if ( !firstVector.getText().isEmpty()) {
            String[] second = firstVector.getText().split(",");
            vector = new Vector(
                    Integer.parseInt(second[0]),
                    Integer.parseInt(second[1]),
                    Integer.parseInt(second[2]),
                    Integer.parseInt(second[3])
            );
        }else {
            message.setText("Enter the coordinates of the first Vector");
        }
        vector = operation.scalingVector(vector, 20);

        return vector;
    }
}

