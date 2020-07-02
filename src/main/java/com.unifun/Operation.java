package com.unifun;



public class Operation {

    public Vector sumVector(Vector vector1, Vector vector2){
        return new Vector(vector1.getOx(), vector1.getOy(),
                vector1.getX()+vector2.getX(), vector1.getY()+vector2.getY());
    }

    public Vector difVector(Vector vector1, Vector vector2){
        return new Vector(vector1.getOx(), vector1.getOy(),
                vector1.getX()-vector2.getX(), vector1.getY()-vector2.getY());
    }

    public float absVector(Vector vector){
        return (float) Math.sqrt(Math.pow(vector.getX(),2) + Math.pow(vector.getY(),2)
                + Math.pow(vector.getOx(),2) + Math.pow(vector.getOy(),2));
    }

    public int multiplieVector(Vector vector1, Vector vector2){
        return vector1.getX() * vector2.getX() + vector1.getY() * vector2.getY();
    }

    public float angleOfVectors(Vector vector1, Vector vector2){
        int product = multiplieVector(vector1, vector2);
        float cos = (float)product / (absVector(vector1) * absVector(vector2));
        return (float) Math.toDegrees(Math.acos(cos));
    }




}
