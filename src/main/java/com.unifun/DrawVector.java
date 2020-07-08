package com.unifun;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class DrawVector extends JFrame{
    static JLabel drowMessage;
    static JFrame frame;

    private Vector vector1 = new Vector();
    private Vector vector2 = new Vector();
    private Vector outVector = new Vector();
    int width = 400;
    int height = 400;

    // default constructor
    DrawVector(){}

    public DrawVector(Vector vector1, Vector vector2, Vector outVector){
        frame = new JFrame("Rezultate");
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
        setSize(width,height);


    }

    public void paint(Graphics g) {
        super.paint(g);  // fixes the immediate problem.
        Graphics2D g2 = (Graphics2D) g;
       int halfWidth = width/2;
       int halfHeight = height/2;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Line2D ox = new Line2D.Float(0,halfHeight,width,halfHeight);
        Line2D oy = new Line2D.Float(halfWidth, 70, halfHeight, height);

        Line2D lin = new Line2D.Float(vector1.getOx()+halfWidth, Math.abs(halfHeight-vector1.getOy()),
                vector1.getX()+halfWidth, Math.abs(halfHeight-vector1.getY()));
        Line2D lin2 = new Line2D.Float( vector2.getOx()+halfWidth, Math.abs(halfHeight-vector2.getOy()),
                vector2.getX()+halfWidth, Math.abs(halfHeight-vector2.getY()));
        Line2D lin3 = new Line2D.Float(outVector.getOx()+halfWidth, halfHeight-outVector.getOy(),
                outVector.getX()+halfWidth, halfHeight-outVector.getY());

        g2.draw(ox);
        g2.draw(oy);
        g2.setPaint(Color.RED);
        g2.draw(lin);
        g2.draw(lin2);
        g2.draw(lin3);
    }
}
