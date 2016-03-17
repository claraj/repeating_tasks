package com.clara;

import java.util.ArrayList;
import java.util.Calendar;

/* Represents a task that should be repeated at a set interval e.g. clean the bathroom every 7 days */

public class RepeatingTask {

    private String name;
    private int frequency;
    private Calendar startDate;

    private ArrayList<Calendar> taskDates = new ArrayList<Calendar>();

    //How many days between tasks? Some constants to help with common repetition frequencies
    public static final int WEEKLY = 7;
    public static final int TWO_WEEKS = 14;
    public static final int MONTHLY = 30;
    public static final int BIMONTHLY = 60;
    public static final int YEARLY = 365;

    /* For setting a particular start date */
    public RepeatingTask(String n, int fq, Calendar date) {
        name = n;
        frequency = fq;
        startDate = date;
        createDatesForTask();
    }

    /* Default start date is today */
    public RepeatingTask(String t, int fq) {

        //Call the other constructor, and provide default value for start date
        this(t, fq, Calendar.getInstance());
    }

    private void createDatesForTask() {
        createDatesForTask(1);   //default = 1 year
    }

    //Generate however many year's worth of dates, from the start date, that this task should be done on
    // The way this loop is set up, it creates one extra date too

    private void createDatesForTask(int years) {

        taskDates.add(startDate);

        Calendar taskDay = (Calendar)startDate.clone();  //Make a copy of the start date, so don't affect it

        for (int d = 0 ; d < 365 ; d+=frequency) {

            taskDay.add(Calendar.DAY_OF_YEAR, frequency);  //Add frequency days to the taskDay

            Calendar newTaskDay = (Calendar)taskDay.clone();  //Make a copy of new taskDay and add to ArrayList
            taskDates.add(newTaskDay);

        }

    }

    public void displayTaskDates() {

        for (Calendar date : taskDates) {
            System.out.println((date.get(Calendar.MONTH) + 1)   //Month is 0-based - January = 0, Feb = 1...
                    + "/" + date.get(Calendar.DAY_OF_MONTH)
                    + "/" + date.get(Calendar.YEAR));
        }
    }


    public String getName() {
        return name;
    }
}
