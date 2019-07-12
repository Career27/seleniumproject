package com.dlg.utilities;

import java.util.Date;

public class Common {

    public static String timeDifference(Date startTime, Date endTime){
//        Date startTime = new Date(System.currentTimeMillis());
//        Thread.sleep(5464);
//        Date endTime = new Date(System.currentTimeMillis());
        long diff = endTime.getTime() - startTime.getTime();
        long diffSeconds = diff / 1000;
//        long diffMinutes = diff / (60 * 1000);
//        long diffHours = diff / (60 * 60 * 1000);
//        System.out.println("Time in seconds: " + diffSeconds + " seconds.");
//        System.out.println("Time in minutes: " + diffMinutes + " minutes.");
//        System.out.println("Time in hours: " + diffHours + " hours.");
        return "Report downloaded in "+Math.floorDiv(diffSeconds, 60)+" mins and "+Math.floorMod(diffSeconds, 60)+" sec";
    }
}
