package com.unifun;



public class Operation {

    public Vector Suma(Vector vector1, Vector vector2){
        return new Vector(vector1.getOx(), vector1.getOy(),
                vector1.getX()+vector2.getX(), vector1.getY()+vector2.getY());
    }

    public Vector Diferenta(Vector vector1, Vector vector2){
        return new Vector(vector1.getOx(), vector1.getOy(),
                vector1.getX()-vector2.getX(), vector1.getY()-vector2.getY());
    }
}
