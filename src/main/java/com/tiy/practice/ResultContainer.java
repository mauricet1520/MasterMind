package com.tiy.practice;

import java.util.ArrayList;

/**
 * Created by crci1 on 1/24/2017.
 */
public class ResultContainer {
    ArrayList<String> colors;
    ArrayList<String> pins;
    ArrayList<String> otherColors;
    ArrayList<String> otherPins;

    public ArrayList<String> getOtherColors() {
        return otherColors;
    }

    public void setOtherColors(ArrayList<String> otherColors) {
        this.otherColors = otherColors;
    }

    public ArrayList<String> getOtherPins() {
        return otherPins;
    }

    public void setOtherPins(ArrayList<String> otherPins) {
        this.otherPins = otherPins;
    }

    public ResultContainer() {

    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public ArrayList<String> getPins() {
        return pins;
    }

    public void setPins(ArrayList<String> pins) {
        this.pins = pins;
    }
}
