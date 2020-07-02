package com.unifun;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class Vector {
    private int ox;
    private int oy;
    private int x;
    private int y;


    public Vector( int ox, int oy, int x, int y) {
        this.x = x;
        this.y = y;
        this.ox = ox;
        this.oy = oy;
    }
}
