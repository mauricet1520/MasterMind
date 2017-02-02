package com.tiy.practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Created by crci1 on 1/20/2017.
 */
public class MasterMindRunnerTest {
    CpuPlayer cpuPlayer;
    Player player;
    @Before
    public void setUp() throws Exception {
         cpuPlayer = new CpuPlayer();
         player = new Player();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCreateColorForCpuSlot() {
        SlotHolder cpuSlot = cpuPlayer.createColorsForSlot();
//        ArrayList<String> theColors  = new ArrayList<>();
//        theColors.add(TheColor.BLUE);
//        theColors.add(TheColor.GREEN);
//        theColors.add(TheColor.PINK);
//        theColors.add(TheColor.PURPLE);

        System.out.println(cpuSlot.getTheColors());
        assertEquals(4, cpuSlot.getTheColors().size());

        boolean allUnique = true;
        HashSet<String> colorSet = new HashSet<>();
        for (String color : cpuSlot.getTheColors()) {
            if (colorSet.contains(color)) {
                allUnique = false;
                break;
            }
            colorSet.add(color);
        }
        assertTrue(allUnique);
    }

    @Test
    public void testGetColorForPlayer() {
        SlotHolder slotHolder = new SlotHolder();
        SlotHolder playerSlot = slotHolder.getPlayerSlot(TheColor.BLUE, TheColor.GREEN, TheColor.PINK, TheColor.RED);
        ArrayList<String> colors = new ArrayList<>();
        colors.add(TheColor.BLUE);
        colors.add(TheColor.GREEN);
        colors.add(TheColor.PINK);
        colors.add(TheColor.RED);

        assertEquals(colors, playerSlot.getTheColors());

    }

    @Test
    public void testReturningAllWhite() {
        SlotHolder slotHolder = new SlotHolder();
//        SlotHolder cpuSlot = cpuPlayer.createColorsForSlot();
        SlotHolder playerSlot = slotHolder.getPlayerSlot(TheColor.GREEN, TheColor.PINK, TheColor.PURPLE, TheColor.RED);
        SlotHolder cpuSlot = slotHolder.getPlayerSlot(TheColor.PINK, TheColor.GREEN, TheColor.RED, TheColor.PURPLE);

        System.out.println((cpuSlot.getTheColors()));
        System.out.println(playerSlot.getTheColors());
        slotHolder.guessCpuSlot(cpuSlot, playerSlot);
        ArrayList<String> thePins = new ArrayList<>();
        thePins.add(Pins.getWHITE());
        thePins.add(Pins.getWHITE2());
        thePins.add(Pins.getWHITE3());
        thePins.add(Pins.getWHITE4());

        playerSlot.getPins();
        assertEquals(thePins, playerSlot.getPins());

    }

    @Test
    public void testReturningAllBlack() {
        SlotHolder slotHolder = new SlotHolder();
//        SlotHolder cpuSlot = cpuPlayer.createColorsForSlot();
        SlotHolder playerSlot = slotHolder.getPlayerSlot(TheColor.PINK, TheColor.GREEN, TheColor.RED, TheColor.PURPLE);
        SlotHolder cpuSlot = slotHolder.getPlayerSlot(TheColor.PINK, TheColor.GREEN, TheColor.RED, TheColor.PURPLE);

        System.out.println((cpuSlot.getTheColors()));
        System.out.println(playerSlot.getTheColors());
        slotHolder.guessCpuSlot(cpuSlot, playerSlot);
        ArrayList<String> thePins = new ArrayList<>();
        thePins.add(Pins.getBLACK());
        thePins.add(Pins.getBLACK1());
        thePins.add(Pins.getBLACK2());
        thePins.add(Pins.getBLACK3());

        playerSlot.getPins();
        assertEquals(thePins, playerSlot.getPins());

    }

    @Test
    public void testComboOfBlackAndWhite() {
        SlotHolder slotHolder = new SlotHolder();
//        SlotHolder cpuSlot = cpuPlayer.createColorsForSlot();
        SlotHolder playerSlot = slotHolder.getPlayerSlot(TheColor.RED, TheColor.GREEN, TheColor.PINK, TheColor.PURPLE);
        SlotHolder cpuSlot = slotHolder.getPlayerSlot(TheColor.PINK, TheColor.GREEN, TheColor.RED, TheColor.PURPLE);

        System.out.println((cpuSlot.getTheColors()));
        System.out.println(playerSlot.getTheColors());
        slotHolder.guessCpuSlot(cpuSlot, playerSlot);
        ArrayList<String> thePins = new ArrayList<>();
        thePins.add(Pins.getWHITE());
        thePins.add(Pins.getBLACK1());
        thePins.add(Pins.getWHITE3());
        thePins.add(Pins.getBLACK3());

        playerSlot.getPins();
        assertEquals(thePins, playerSlot.getPins());

    }
}