package session;



public class DateRange {
    private String date;
    private String startTime;
    private String endTime;

    

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

    
    @Override
    public String toString(){
        return String.format("%s %s - %s (%d minutes)", date, startTime, endTime, duration());
    }


}