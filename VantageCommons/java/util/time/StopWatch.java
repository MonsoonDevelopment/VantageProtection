package util.time;

/**
 * This is a simple Stopwatch util, used for timing stuff
 *
 * @author Auth
 * @since 17/10/2021
 */
public class StopWatch {

    private long millis;

    public StopWatch() {
        reset();
    }

    public boolean finished(final long delay) {
        return System.currentTimeMillis() - delay >= millis;
    }

    public void reset() {
        this.millis = System.currentTimeMillis();
    }

    public long getMillis() {
        return millis;
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - this.millis;
    }
}