
package clock;

public class Hour {
    
    private double t;

    public Hour(double t) {
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
        return t/120;
    }
 
}
