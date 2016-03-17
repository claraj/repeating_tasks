package com.clara;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        //TODO How would you display all of the tasks, in calendar order? Would you need to set the program up differently?

        //Set up a repeating task - clean the bathroom weekly, starting from today.
        RepeatingTask cleanBathroom = new RepeatingTask("Clean Bathroom", RepeatingTask.WEEKLY);

        System.out.println(cleanBathroom.getName() + " task should be done on these dates...");
        cleanBathroom.displayTaskDates();

        //Change fire alarm batteries every 180 days (about 6 months), starting today
        RepeatingTask fireAlarmBattery = new RepeatingTask("Change fire alarm batteries", 180);

        System.out.println(fireAlarmBattery.getName() + " task should be done on these dates...");

        fireAlarmBattery.displayTaskDates();

        //Set up another repeating task. Perhaps we just did this, so start from next week
        //Hard coded date here - change to something suitable. For real program, would get user input
        Calendar nextWeek = new Calendar.Builder().setDate(2016, 2, 25).build(); //25th of March, 2016. Day and Year are what you expect, but Month numbering is ZERO BASED so Jan=0, Feb=1, March=2
        RepeatingTask cleanBasement = new RepeatingTask("Clean the basement", RepeatingTask.MONTHLY, nextWeek);
        System.out.println(cleanBasement.getName() + " task should be done on these dates...");

        cleanBasement.displayTaskDates();

        //And another example - car oil change every 3 months, starting in two weeks. Again, hard coded dates, fix for real program :(

        Calendar twoWeeks = new Calendar.Builder().setDate(2016, 3, 1).build();           // April 1, 2016
        RepeatingTask oilChange = new RepeatingTask("Oil Change for car", 95, twoWeeks);
        System.out.println(oilChange.getName() + " should be done on these dates...");
        oilChange.displayTaskDates();


    }
}
