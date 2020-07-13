package com.unifun;


public class Operation {

    public Vector sumVector(Vector vector1, Vector vector2){
        vector2 = getVector(vector1, vector2);
        return new Vector(vector1.getOx(), vector1.getOy(),
                vector1.getX()+vector2.getX(), vector1.getY()+vector2.getY());
    }

    public Vector difVector(Vector vector1, Vector vector2){
        vector2 = getVector(vector1, vector2);
        return new Vector(vector1.getOx(), vector1.getOy(),
                vector1.getX()-vector2.getX(), vector1.getY()-vector2.getY());
    }

    private Vector getVector(Vector vector1, Vector vector2) {
        if (vector1.getOx() != vector2.getOx() && vector1.getOy() != vector2.getOy()){
            int x = vector1.getOx() - vector2.getOx();
            int y = vector1.getOy() - vector2.getOy();
            Vector translation = new Vector(x, y, x, y);
            vector2 = translationVector(vector2,translation);
        }
        return vector2;
    }

    public float absVector(Vector vector){
        return (float) Math.sqrt(Math.pow(vector.getX() - vector.getOx(),2) +
                Math.pow(vector.getY() - vector.getOy() ,2));
    }

    public float multiplieVector(Vector vector1, Vector vector2){
        return (vector1.getX() - vector1.getOx()) * (vector2.getX() - vector2.getOx()) +
                (vector1.getY() - vector1.getOy()) * (vector2.getOy() - vector2.getY());
    }

    public float angleOfTwoVectors(Vector vector1, Vector vector2){
        float product = multiplieVector(vector1, vector2);
        System.out.println("produsul "+product);
        float cos = product / (absVector(vector1) * absVector(vector2));
        return (float) Math.toDegrees(Math.acos(cos));
    }

    public float angleOfVector(Vector vector){
        Vector translation = new Vector(vector.getOx(), vector.getOy(), vector.getX(),vector.getOy() );
        float angle = angleOfTwoVectors(vector, translation);
        int cadran = getCadran(vector);

        if (cadran == 10 || cadran == 2){
            angle = 180f - angle;
        }else
            if (cadran == 15 || cadran == 3){
            angle += 180f;
        }else
            if (cadran == 1 || cadran == 5){
            angle = 360f - angle;
        }

        return angle;
    }

    public int getCadran(Vector vector){
        int [] cadran = new int[]{0,0,0,0};
        int [] bit = new int[]{8,4,2,1};
        int number = 0; String cadranul = "";
        if (vector.getOx() < 0){
            cadran[0] = 1;
        }
        if (vector.getOy() < 0){
            cadran[1] = 1;
        }
        if (vector.getX() < 0){
            cadran[2] = 1;
        }
        if (vector.getY() < 0){
            cadran[3] = 1;
        }

        for (int i = 0; i < 4; i++) {
            if (cadran[i] == 1){
                number += bit[i];
            }
        }

        return number;
    }

    public Vector translationVector(Vector vector, Vector translation){
        return new Vector(vector.getOx()+translation.getOx(), vector.getOy()+translation.getOy(),
                vector.getX()+translation.getX(), vector.getY()+translation.getY());
    }

    public Vector scalingVector(Vector vector, int scaler){
        return new Vector(vector.getOx() * scaler, vector.getOy() * scaler,
                vector.getX() * scaler, vector.getY() * scaler);
    }


}
