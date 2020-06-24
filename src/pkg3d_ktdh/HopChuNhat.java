/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3d_ktdh;

import java.awt.Point;

/**
 *
 * @author Admin
 */
public class HopChuNhat {
    private Point p;
    private int dai,rong,cao;

    public HopChuNhat() {
    }

    public HopChuNhat(Point p, int dai, int rong, int cao) {
        this.p = p;
        this.dai = dai;
        this.rong = rong;
        this.cao = cao;
    }

    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public int getDai() {
        return dai;
    }

    public void setDai(int dai) {
        this.dai = dai;
    }

    public int getRong() {
        return rong;
    }

    public void setRong(int rong) {
        this.rong = rong;
    }

    public int getCao() {
        return cao;
    }

    public void setCao(int cao) {
        this.cao = cao;
    }
    
    
}
