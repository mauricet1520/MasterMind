package com.tiy.practice;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Holder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by crci1 on 1/21/2017.
 */

@RestController
public class MasterRestJSONController {

    ArrayList<String> colors = new ArrayList<>();
    SlotHolder playerSlot = new SlotHolder();
    SlotHolder cpuSlot = new SlotHolder();
    CpuPlayer cpuPlayer = new CpuPlayer();
    Player player = new Player();
    ResultContainer result = new ResultContainer();
    SlotHolder lastMove = new SlotHolder();
    ArrayList<ResultContainer> resultContainer = new ArrayList<>();


    public void setLastMove(SlotHolder lastMove) {
        this.lastMove = lastMove;
    }

    @RequestMapping(path = "/mastermind.json", method = RequestMethod.GET)
    public ArrayList<String> get_cpu_slot(HttpSession session) {


        SlotHolder cpuSlot = (SlotHolder) session.getAttribute("cpu");
//        cpuPlayer = new CpuPlayer();
//         cpuSlot = cpuPlayer.createColorsForSlot();


//        Map<String, String> cpuMap = new HashMap<>();
//        for (String s : cpuSlot.getTheColors()) {
//            if (s.equals("RED")) {
//                cpuMap.put(s, "RED");
//            } else if (s.equals("PURPLE")) {
//                cpuMap.put(s, "PURPLE");
//            } else if (s.equals("BLUE")) {
//                cpuMap.put(s, "BLUE");
//            } else if (s.equals("GREEN")) {
//                cpuMap.put(s, "GREEN");
//            } else if (s.equals("YELLOW")) {
//                cpuMap.put(s, "YELLOW");
//            } else if (s.equals("PINK")) {
//                cpuMap.put(s, "PINK");
//            }
//        }

        return cpuSlot.getTheColors();
    }

    @RequestMapping(path = "/player-play.json", method = RequestMethod.GET)
    public ArrayList<String> playPlayer() {

        SlotHolder slotHolder = new SlotHolder();

        return playerSlot.getTheColors();
    }

    @RequestMapping(path = "make_color.json", method = RequestMethod.POST)
    public ArrayList<String> make_color(@RequestBody SlotHolder slotHolder) {

//        playerSlot.setColors(slotHolder.getTheColors());
//        SlotHolder slotHolder = new SlotHolder();
//        String myColor = null;
//
//        if (color.equals("1")){
//            myColor = (TheColor.RED);
//        }else if (color.equals("2")){
//            myColor = TheColor.PURPLE;
//
//        }else if (color.equals("3")){
//            myColor = TheColor.BLUE;
//,
//        }else if (color.equals("4")){
//            myColor = TheColor.GREEN;
//
//        }else if (color.equals("5")){
//            myColor = TheColor.PINK;
//        }else if (color.equals("6")){
//            myColor = TheColor.YELLOW;
//        }
//         playerSlot = slotHolder.getPlayerSlot(player, slotHolder.getColor());
        playerSlot.getTheColors().add(slotHolder.getColor());

//        playerSlot = slotHolder.getPlayerSlot(player, myColor);
        return playerSlot.getTheColors();
    }

    @RequestMapping(path = "/make_slot.json", method = RequestMethod.POST)
    public ArrayList<ResultContainer> make_slot(HttpSession session, @RequestBody TheHolder holder) {
        SlotHolder cpuSlot = (SlotHolder) session.getAttribute("cpu");
        SlotHolder playerSlot = new SlotHolder();
        ResultContainer result = new ResultContainer();

        if (cpuSlot == null) {
            cpuSlot = cpuPlayer.createColorsForSlot();

            session.setAttribute("cpu", cpuSlot);
        }

        playerSlot.getColors().add(holder.getColors1());
        playerSlot.getColors().add(holder.getColors2());
        playerSlot.getColors().add(holder.getColors3());
        playerSlot.getColors().add(holder.getColors4());
        lastMove.getColors().addAll(playerSlot.getColors());

        SlotHolder.sharedColors.addAll(playerSlot.getColors());
        SlotHolder slotHolder = new SlotHolder();
        slotHolder.guessCpuSlot((SlotHolder) session.getAttribute("cpu"), playerSlot);
        result.setColors(playerSlot.getColors());
        result.setPins(playerSlot.getPins());
        resultContainer.add(result);


        setLastMove(playerSlot);

//         playerSlot = holder.getPlayerSlot(holder.getColors().get(0), holder.getColors().get(1),
//                 holder.getColors().get(2),holder.getColors().get(3));
//        holder.guessCpuSlot(cpuSlot, playerSlot);
        return resultContainer;
    }

    @RequestMapping(path = "/white_black.json", method = RequestMethod.GET)
    public ArrayList<String> white_black() {

        return playerSlot.getPins();
    }


}
