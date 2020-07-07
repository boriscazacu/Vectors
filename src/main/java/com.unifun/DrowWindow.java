package com.unifun;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import javax.swing.*;


public class DrowWindow extends JFrame implements ActionListener {
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
    static JLabel drowMessage;

    private Vector vector1 = new Vector();
    private Vector vector2 = new Vector();
    private Vector outVector = new Vector();

    // default constructor
    DrowWindow(){}

    public DrowWindow(Vector vector1, Vector vector2, Vector outVector){
        this.vector1 = vector1;
        this.vector2 = vector2;
        this.outVector = outVector;
        drowMessage = new JLabel("");
        frame = new JFrame("Rezultate");

        drowMessage.setBounds(130, 10, 200, 50);
        drowMessage.setText(String.valueOf(outVector));
        JPanel panel=new JPanel();
        panel.add(drowMessage);
        getContentPane().add(panel);
        setSize(350,350);


    }

    public void paint(Graphics g) {
        super.paint(g);  // fixes the immediate problem.
        Graphics2D g2 = (Graphics2D) g;
        System.out.println(vector1.toString());
        System.out.println(vector1.getX());

        Line2D lin = new Line2D.Float(100, 100, 250, 260);
        Line2D lin2 = new Line2D.Float((float) vector2.getOx(), (float)vector2.getOy(),
                (float)vector2.getX(), (float)vector2.getY());
        Line2D lin3 = new Line2D.Float(outVector.getOx()*1.0f, outVector.getOy()*1.0f,
                outVector.getX()*1.0f, outVector.getY()*1.0f);

        g2.draw(lin);
        g2.draw(lin2);
        g2.draw(lin3);
    }

    // main class
    public static void main(String[] args)
    {
        frame = new JFrame("Vectors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("Operations");
        message = new JLabel("");
        originea = new JLabel("First Vector (x,y,..)");
        virtful = new JLabel("Second Vector (x,y,..)");
        button = new JButton("AngleF");
        angle = new JButton("AngleL");
        buttonAdd = new JButton("+");
        buttonDiff = new JButton("-");
        DrowWindow te = new DrowWindow();
        Font fo = new Font("Serif", Font.BOLD, 15);

        Dimension size = label.getPreferredSize();
        label.setBounds(195, 150, 400, size.height);
        originea.setBounds(170, 25, 200, size.height);
        virtful.setBounds(165, 70, 200, 50);
        message.setBounds(130, 240, 200, 50);
        message.setForeground(Color.RED);

        firstVector = new JTextField(4);
        firstVector.setBounds(160,48, 130,30);
        secondVector = new JTextField(4);
        secondVector.setBounds(160,110, 130,30);

        button.addActionListener(te);
        buttonAdd.addActionListener(te);
        buttonDiff.addActionListener(te);
        angle.addActionListener(te);

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
       // frame.add(panel);
        frame.setSize(490, 370);
        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e)
    {
        if (!firstVector.getText().isEmpty() && !secondVector.getText().isEmpty()){
            String s = e.getActionCommand();
            String[] first = firstVector.getText().split(",");
            String[] second = firstVector.getText().split(",");


            Vector vector1 = new Vector(
                    Integer.parseInt(first[0]),
                    Integer.parseInt(first[1]),
                    Integer.parseInt(first[2]),
                    Integer.parseInt(first[3])
            );
            Vector vector2 = new Vector(
                    Integer.parseInt(second[0]),
                    Integer.parseInt(second[1]),
                    Integer.parseInt(second[2]),
                    Integer.parseInt(second[3])
            );
            Operation operation =new Operation();

            if (s.equals("AngleF")) {
                //custom title, no icon
                JOptionPane.showMessageDialog(frame,
                        String.valueOf(operation.angleOfVector(vector1)),
                        "Angle of first Vector",
                        JOptionPane.PLAIN_MESSAGE);


            }else
                if (s.equals("+")){
                    Vector sum = operation.sumVector(vector1,vector2);
                    DrowWindow window = new DrowWindow(vector1,vector2,sum);
                    window.setVisible(true);
                } else
                    if (s.equals("-")){
                        Vector diff = operation.difVector(vector1,vector2);
                        JOptionPane.showMessageDialog(frame,
                                String.valueOf(diff),
                                "Sum of Vectors",
                                JOptionPane.PLAIN_MESSAGE);
                    }else
                        if (s.equals("AngleL")){
                            JOptionPane.showMessageDialog(frame,
                                    String.valueOf(operation.angleOfVector(vector2)),
                                    "Angle of second Vector",
                                    JOptionPane.PLAIN_MESSAGE);
                        }


    }else {
            message.setText("Introduceti coordonatele la Vectori");
        }
    }
}

