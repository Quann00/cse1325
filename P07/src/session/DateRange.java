package session;

/**
* Models a DateRange.
*
* @author Quan Nguyen
* @version 1.0
* @since 1.0
* @license.agreement CC BY-SA International 4.0
*/

public class DateRange {
    private String date;
    private String startTime;
    private String endTime;

    /**
     * Creates a DateRange with the specified date, start time, and end time.
     * 
     * @param date          date The date string Cannot be null or empty
     * @param startTime     The starting time string in HH:MM format
     * @param endTime       The ending time string in HH:MM format
     * @throws IllegalArgumentException     If any of the arguments are null or empty
     * @since               1.0
     */

    public DateRange (String date, String startTime, String endTime){
        if (date == null || date.isEmpty() ){
            throw new IllegalArgumentException("DATE cannot be null or empty");
        }
        if (startTime == null || startTime.isEmpty() ){
            throw new IllegalArgumentException("STARTTIME cannot be null or empty");
        }
        if (endTime == null || endTime.isEmpty() ){
            throw new IllegalArgumentException("ENDTIME cannot be null or empty");
        } 
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Creates a DateRange with the specified date, start time, and end time.
     * 
     * @param date          date The date string Cannot be null or empty
     * @param startTime     The starting time string in HH:MM format
     * @param duration      The duration of the time range in minutes.
     * @since               1.0
     */

    public DateRange(String date, String startTime, long duration){
        // from lecture 9
        String[] timeSplit = startTime.split(":");
        long startHour = Integer.valueOf(timeSplit[0]);
        long startMinute = Integer.valueOf(timeSplit[1]);
        long totalStartMinutes = (startHour * 60) + startMinute;
        long totalEndMinutes =  totalStartMinutes + duration;
        long endHour = (totalEndMinutes / 60) % 24;
        long endMinute = totalEndMinutes % 60;

        this.date = date;
        this.startTime = startTime;
        this.endTime = String.format("%02d:%02d", endHour, endMinute);

    }

    /**
     * Calculates the duration in minutes between the startTime and endTime.
     *
     * @return The total duration in minutes as a long.
     * @since               1.0
     */

    public long duration(){

        String[] timeSplit = startTime.split(":");
        long startHour = Long.valueOf(timeSplit[0]);
        long startMinute = Long.valueOf(timeSplit[1]);

        String[] endTimeSplit = endTime.split(":");
        long endHour = Long.valueOf(endTimeSplit[0]);
        long endMinute = Long.valueOf(endTimeSplit[1]);

        long totalStartMinutes = (startHour * 60) + startMinute;
        long totalEndMinutes = (endHour * 60) + endMinute;

        long duration = totalEndMinutes - totalStartMinutes;
        //for negative
        if (duration < 0){
            duration += 60 * 24; 
        }
        return duration;
    }

    /**
     * The format is "YYYY-MM-DD HH:MM - HH:MM (duration minutes)".
     *
     * @return A string describing the DateRange and its calculated duration.
     * @since         1.0
     */
    @Override
    public String toString(){
        return String.format("%s %s - %s (%d minutes)", date, startTime, endTime, duration());
    }


}