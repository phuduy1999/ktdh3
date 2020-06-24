/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktdh_nhom3;

import java.awt.Point;

/**
 *
 * @author Admin
 */
public class HinhCau {
    private Point p;
    private int R,h;

    public HinhCau() {
    }

    public HinhCau(Point p, int R, int h) {
        this.p = p;
        this.R = R;
        this.h = h;
    }

    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public int getR() {
        return R;
    }

    public void setR(int R) {
        this.R = R;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
    
    
}
