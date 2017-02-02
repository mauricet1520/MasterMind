package com.tiy.practice;

import java.util.ArrayList;

/**
 * Created by crci1 on 1/19/2017.
 */
public class SlotHolder {
    private ArrayList<String> colors;
    static ArrayList<String> sharedColors = new ArrayList<>();
    private String color;
    private ArrayList<String> pins = new ArrayList<>();
    private MyPins myPins;

    public MyPins getMyPins() {
        return myPins;
    }

    public void setMyPins(MyPins myPins) {
        this.myPins = myPins;
    }

    public ArrayList<String> getPins() {
        return pins;
    }

    public void setPins(ArrayList<String> pins) {
        this.pins = pins;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<String> getTheColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public SlotHolder(Player player) {

    }

    public SlotHolder(CpuPlayer cpuPlayer) {
    }

    public SlotHolder getCpuSlot(CpuPlayer cpuPlayer) {
        SlotHolder cpuSlot = cpuPlayer.createColorsForSlot();

        return cpuSlot;
    }

    public SlotHolder getPlayerSlot(Player player, String color1) {
        colors.add(color1);

        SlotHolder playerSlot = player.createSlotForPlayer(colors);
        return playerSlot;
    }

    public SlotHolder getPlayerSlot(String color1, String color2, String color3, String color4) {
        SlotHolder playerSlot = new SlotHolder();

        playerSlot.colors.add(color1);
        playerSlot.colors.add(color2);
        playerSlot.colors.add(color3);
        playerSlot.colors.add(color4);

        sharedColors.addAll(playerSlot.getColors());

        return playerSlot;
    }

    public ArrayList<String> guessCpuSlot(SlotHolder cpuSlot, SlotHolder playerSlot) {
        int index = 0;
        for (String color : cpuSlot.getTheColors()) {
            int pIndex = 0;
            if (color.equals(playerSlot.getTheColors().get(index))) {
                System.out.println("The Same at " + index);
                System.out.println("You get a black pin");
                if (index == 0) {
                    playerSlot.pins.add(Pins.getBLACK());
                } else if (index == 1) {
                    playerSlot.pins.add(Pins.getBLACK1());
                } else if (index == 2) {
                    playerSlot.pins.add(Pins.getBLACK2());
                } else if (index == 3) {
                    playerSlot.pins.add(Pins.getBLACK3());
                }

            } else if (cpuSlot.getTheColors().contains(playerSlot.getTheColors().get(index)) && index == 0) {
                playerSlot.pins.add(Pins.getWHITE());
            } else if (cpuSlot.getTheColors().contains(playerSlot.getTheColors().get(index)) && index == 1) {
                playerSlot.pins.add(Pins.getWHITE2());
            } else if (cpuSlot.getTheColors().contains(playerSlot.getTheColors().get(index)) && index == 2) {
                playerSlot.pins.add(Pins.getWHITE3());
            } else if (cpuSlot.getTheColors().contains(playerSlot.getTheColors().get(index)) && index == 3) {
                playerSlot.pins.add(Pins.getWHITE4());
            }

            index++;
        }

        System.out.println();
        System.out.println();
        System.out.println();

        return playerSlot.pins;
    }

    public SlotHolder() {
        colors = new ArrayList<>();
        myPins = new MyPins();

    }

    public ArrayList<String> addColor(String color, SlotHolder playerSlot) {
        playerSlot.colors.add(color);

        return playerSlot.getTheColors();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
