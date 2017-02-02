package com.tiy.practice;

import java.util.*;

/**
 * Created by crci1 on 1/19/2017.
 */
public class CpuPlayer {
    private SlotHolder cpuSlot;
    private ArrayList<String> colors;

    public SlotHolder createColorsForSlot() {
        String[] theColors = new String[6];
        theColors[0] = TheColor.PINK;
        theColors[1] = TheColor.RED;
        theColors[2] = TheColor.BLUE;
        theColors[3] = TheColor.GREEN;
        theColors[4] = TheColor.PURPLE;
        theColors[5] = TheColor.YELLOW;

        Set<String> mySetColors = new HashSet<>();
        Random random = new Random();
        boolean isThree = false;

        while (!isThree) {

            mySetColors.add(theColors[random.nextInt(6)]);
            mySetColors.add(theColors[random.nextInt(6)]);
            mySetColors.add(theColors[random.nextInt(6)]);
            mySetColors.add(theColors[random.nextInt(6)]);

            if (mySetColors.size()== 4){
                break;
            }else {
                mySetColors.removeAll(mySetColors);
                continue;
            }
        }
        colors = new ArrayList<>();

        colors.addAll(mySetColors);

        cpuSlot = new SlotHolder();
        cpuSlot.setColors(colors);
        return cpuSlot;
    }

    public SlotHolder getSlotHolder() {
        return cpuSlot;
    }


    public void setSlotHolder(SlotHolder slotHolder) {
        this.cpuSlot = slotHolder;
    }
}
