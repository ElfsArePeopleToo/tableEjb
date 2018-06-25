package ejb.beans.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;

//@JsonDeserialize(using = DeserializerOrders.class)
public class WaggonJson implements Serializable {
    private int allWaggonsCount;
    private int freeWaggonsCount;
    private int busyWaggonsCount;
    private int workingWaggonCount;
    private int brokenWaggonCount;

    public WaggonJson() {

    }
    public WaggonJson(int allWaggonsCount, int freeWaggonsCount, int busyWaggonsCount, int workingWaggonCount, int brokenWaggonCount) {
        this.allWaggonsCount = allWaggonsCount;
        this.freeWaggonsCount = freeWaggonsCount;
        this.busyWaggonsCount = busyWaggonsCount;
        this.workingWaggonCount = workingWaggonCount;
        this.brokenWaggonCount = brokenWaggonCount;
    }

    @Override
    public String toString() {
        return "WaggonJson{" +
                "allWaggonsCount=" + allWaggonsCount +
                ", freeWaggonsCount=" + freeWaggonsCount +
                ", busyWaggonsCount=" + busyWaggonsCount +
                ", workingWaggonCount=" + workingWaggonCount +
                ", brokenWaggonCount=" + brokenWaggonCount +
                '}';
    }

    public int getAllWaggonsCount() {
        return allWaggonsCount;
    }

    public int getFreeWaggonsCount() {
        return freeWaggonsCount;
    }

    public int getBusyWaggonsCount() {
        return busyWaggonsCount;
    }

    public int getWorkingWaggonCount() {
        return workingWaggonCount;
    }

    public int getBrokenWaggonCount() {
        return brokenWaggonCount;
    }

    public void setAllWaggonsCount(int allWaggonsCount) {
        this.allWaggonsCount = allWaggonsCount;
    }

    public void setFreeWaggonsCount(int freeWaggonsCount) {
        this.freeWaggonsCount = freeWaggonsCount;
    }

    public void setBusyWaggonsCount(int busyWaggonsCount) {
        this.busyWaggonsCount = busyWaggonsCount;
    }

    public void setWorkingWaggonCount(int workingWaggonCount) {
        this.workingWaggonCount = workingWaggonCount;
    }

    public void setBrokenWaggonCount(int brokenWaggonCount) {
        this.brokenWaggonCount = brokenWaggonCount;
    }
}

