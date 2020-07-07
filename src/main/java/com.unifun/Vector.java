package com.unifun;

public class Vector {
    private int ox;
    private int oy;
    private int x;
    private int y;


    public Vector(int ox, int oy, int x, int y) {
        this.x = x;
        this.y = y;
        this.ox = ox;
        this.oy = oy;
    }
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
        this.ox = 0;
        this.oy = 0;
    }

    public Vector(){}

    public int getOx() {
        return ox;
    }

    public int getOy() {
        return oy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "ox=" + ox +
                ", oy=" + oy +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

}
