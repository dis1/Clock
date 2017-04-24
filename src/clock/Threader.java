
package clock;

import java.util.TreeMap;

public class Threader extends Thread{
    
    private static final double distance = Math.sqrt(3);
    
    private TreeMap<Double, String> map;
    
    private final int time;
    
    private final int threads;

    public Threader(int t, int threads) {
        this.time = t;
        this.threads = threads;
    }
    
    @Override
    public void run(){
        Hour h = new Hour(time);
        Minute m = new Minute(time);
        Second s = new Second(time);
        TreeMap<Double,String> map = new TreeMap();
        double min_delta = 1;
        for (int t = 100*time; t <= 100*time + 8640000/threads; t++) {
            Double currentTime = 0.01*t;
            h.setT(currentTime);
            m.setT(currentTime);
            s.setT(currentTime);
            double delta = getDeltaHM(h, m, currentTime) + getDeltaMS(m, s, currentTime) + getDeltaSH(h, s, currentTime);
            
            if(delta<0.03){
                map.put(delta, getTime(currentTime));
                if(min_delta>delta){
                    min_delta=delta;
                }
            }
        }
        setMap(map);
        System.out.println("delta = " + min_delta + " time is " + map.get(min_delta));
    }
    
    public static double getDeltaHM(Hour h, Minute m, double t){
        return Math.abs(Math.sqrt(Math.pow((h.getX(t)-m.getX(t)), 2) + Math.pow((h.getY(t)-m.getY(t)), 2)) - distance);
    }
    
    public static double getDeltaMS(Minute m, Second s, double t){
        return Math.abs(Math.sqrt(Math.pow((s.getX(t)-m.getX(t)), 2) + Math.pow((s.getY(t)-m.getY(t)), 2)) - distance);
    }
    
    public static double getDeltaSH(Hour h, Second s, double t){
        return Math.abs(Math.sqrt(Math.pow((h.getX(t)-s.getX(t)), 2) + Math.pow((h.getY(t)-s.getY(t)), 2)) - distance);
    }
    
    public static String getTime(double t){
        int hour = (int)t/3600;
        int minute = (int)(t - hour*3600)/60;
        int second = (int)(t - hour*3600 - minute*60);
        double time = t*1000;
        int miliseconds = (int)time - 1000*((int)t);
        return hour + " hours and " + minute + " minutes and " + second + " seconds and " + miliseconds + " miliseconds";
    }

    public TreeMap<Double, String> getMap() {
        return map;
    }

    public void setMap(TreeMap<Double, String> map) {
        this.map = map;
    }

}
