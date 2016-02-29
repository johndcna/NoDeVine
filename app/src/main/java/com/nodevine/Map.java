package com.nodevine;

/**
 * Created by John on 2/29/2016.
 */
public class Map {
    int type;
    int level;
    String name;
    int location;
    double time;

    boolean isOccupied;


    public Map() {}
    public Map(int type,int level,String name,int location,double time) {
        this.type = type;
        this.level = level;
        this.name = name;
        this.location = location;
        this.time = time;

    }
    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

 }
