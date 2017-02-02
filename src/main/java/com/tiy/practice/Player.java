package com.tiy.practice;

import java.util.ArrayList;

/**
 * Created by crci1 on 1/19/2017.
 */
public class Player {
    private SlotHolder[] slotHolders;
    private String[] theColors;
    private SlotHolder myPlayerSlot = new SlotHolder();

    public Player() {
        theColors = new String[6];
        theColors[0] = TheColor.PINK;
        theColors[1] = TheColor.RED;
        theColors[2] = TheColor.BLUE;
        theColors[3] = TheColor.GREEN;
        theColors[4] = TheColor.PURPLE;
        theColors[5] = TheColor.YELLOW;
    }



    public String[] getTheColors() {

        return theColors;
    }

    public void setTheColors(String[] theColors) {
        this.theColors = theColors;
    }

    public SlotHolder createSlotForPlayer(ArrayList<String> colors) {
        myPlayerSlot.setColors(colors);

        return myPlayerSlot;
    }

    public SlotHolder getMyPlayerSlot() {
        return myPlayerSlot;
    }

    public void setMyPlayerSlot(SlotHolder myPlayerSlot) {
        this.myPlayerSlot = myPlayerSlot;
    }


}
