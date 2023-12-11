/**
 * A class that keeps track of time in 24-hour digital format.
 *
 * @author Farhan Karim
 */
public class Time {

    /**
     * Hours on the clock
     */
    private int h;

    /**
     * Minutes on the clock
     */
    private int m;

    /**
     * Seconds on the clock
     */
    private int s;

    /**
     * Instantiates a Time object with the initial time set based on the parameters.
     * @param h hours
     * @param m minutes
     * @param s seconds
     */
    public Time(int h, int m, int s) {
        this.h = h;
        this.m = m;
        this.s = s;
    }

    /**
     * Default constructor that instantiates the Time object with an initial time of 00:00:00.
     */
    public Time() {
        this.h = 0;
        this.m = 0;
        this.s = 0;
    }

    /**
     * Acquires hours value of the object.
     *
     * @return hours
     */
    public int getH() {
        return h;
    }

    /**
     * Updates the hours value of the object
     *
     * @param h new h value
     */
    public void setH(int h) {
        this.h = h;
    }

    /**
     * Acquires minutes value of the object.
     *
     * @return minutes
     */
    public int getM() {
        return m;
    }

    /**
     * Updates the minutes value of the object
     *
     * @param m new m value
     */
    public void setM(int m) {
        this.m = m;
    }

    /**
     * Acquires seconds value of the object.
     *
     * @return seconds
     */
    public int getS() {
        return s;
    }

    /**
     * Updates the seconds value of the object
     *
     * @param s new s value
     */
    public void setS(int s) {
        this.s = s;
    }

    /**
     * Creates a string with the time in HH:MM:SS digital format
     *
     * @return times string
     */
    public String info() {
        String info = "";
        if (h>=10) {
            info += h;
        } else {
            info += "0"+h;
        }
        info += ":";
        if (m >=10) {
            info += m;
        } else {
            info += "0"+m;
        }
        info += ":";
        if (s>=10) {
            info += s;
        } else {
            info += "0"+s;
        }
        return info;
    }

    /**
     * Adds a second to the time.
     * <p>
     * If seconds reach 60, minutes increment 1 and seconds is set to 0.
     * <p>
     * If minutes reach 60, hours increment 1 and minutes is set to 0.
     * <p>
     * If hours reach 24, hours is set to 0.
     */
    public void tick() {
        s++;
        if(s == 60) {
            m++;
            s = 0;
        }
        if (m == 60) {
            h++;
            m = 0;
        }
        if (h == 24) {
            h = 0;

        }
    }

    /**
     * Adds the time from another time object
     *
     * @param t Time object
     */
    public void add(Time t) {
        int addH = t.getH();
        int addM = t.getM();
        int addS = t.getS();

        this.s += addS;
        if (s >= 60) {
            this.s = s - 60;
            this.m++;
        }
        this.m += addM;
        if (m>=60) {
            this.m = m - 60;
            this.h++;
        }
        this.h += addH;
        if (h >=24) {
            this.h = h-24;
        }
    }
}