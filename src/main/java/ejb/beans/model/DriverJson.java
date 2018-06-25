package ejb.beans.model;

import java.io.Serializable;

public class DriverJson implements Serializable {

    private int driversCount;
    private int freeDriversCount;
    private int busyDriversCount;

    public DriverJson(int driversCount, int freeDriversCount, int busyDriversCount) {
        this.driversCount = driversCount;
        this.freeDriversCount = freeDriversCount;
        this.busyDriversCount = busyDriversCount;
    }

    public DriverJson() {

    }

    @Override
    public String toString() {
        return "DriverJson{" +
                "driversCount=" + driversCount +
                ", freeDriversCount=" + freeDriversCount +
                ", busyDriversCount=" + busyDriversCount +
                '}';
    }

    public int getDriversCount() {
        return driversCount;
    }

    public int getFreeDriversCount() {
        return freeDriversCount;
    }

    public int getBusyDriversCount() {
        return busyDriversCount;
    }

    public void setDriversCount(int driversCount) {
        this.driversCount = driversCount;
    }

    public void setFreeDriversCount(int freeDriversCount) {
        this.freeDriversCount = freeDriversCount;
    }

    public void setBusyDriversCount(int busyDriversCount) {
        this.busyDriversCount = busyDriversCount;
    }
}
