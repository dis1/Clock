/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

/**
 *
 * @author Romashka
 */
public class Second {
private double t;

    public Second(double t) {
        this.t = t;
    }

    public double getX(double t) {
        return Math.sin(this.getAngle(t)*Math.PI/180);
    }

    public double getY(double t) {
        return Math.cos(this.getAngle(t)*Math.PI/180);
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    public double getAngle(double t) {
        return t*6;
    }
 
}
