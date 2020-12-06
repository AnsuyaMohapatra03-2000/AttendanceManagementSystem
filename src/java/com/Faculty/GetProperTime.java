package com.Faculty;

public class GetProperTime {

     int hour,second,minute;
     String date,day,month;
   
    public GetProperTime(String timeStr) {
        
       String para[] = timeStr.split(" ");
        for(int i=0;i<6;i++){
        	System.out.println(para[i]);
        }
        String t[] = para[3].split(":");
        hour = Integer.parseInt(t[0]);
        minute = Integer.parseInt(t[1]);
        second = Integer.parseInt(t[2]);
        day = para[0];    
        month = para[1];
        date = para[2];
    }

    public int getHour() {
        return hour;
    }

    public int getSecond() {
        return second;
    }

    public int getMinute() {
        return minute;
    }

    public String getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    } 
}
