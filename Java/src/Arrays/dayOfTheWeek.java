package Arrays;

import java.util.HashMap;

public class dayOfTheWeek {


	public String solution() {
		int k =23;
		String S = "Sat";
		HashMap<String, Integer> dayWeek = new HashMap<>();
        dayWeek.put("Mon",1);
        dayWeek.put("Tue",2);
        dayWeek.put("Wed",3);
        dayWeek.put("Thu",4);
        dayWeek.put("Fri",5);
        dayWeek.put("Sat",6);
        dayWeek.put("Sun",7);

        HashMap<Integer, String> dayWeekValue = new HashMap<>();
        dayWeekValue.put(1,"Mon");
        dayWeekValue.put(2,"Tue");
        dayWeekValue.put(3,"Wed");
        dayWeekValue.put(4,"Thu");
        dayWeekValue.put(5,"Fri");
        dayWeekValue.put(6,"Sat");
        dayWeekValue.put(7,"Sun");
        
        String currDay = S;
        int currDayValue = dayWeek.get(currDay);
        System.out.println(currDayValue);
        while(k>7){
            k-=7;
        }

        currDayValue = currDayValue+k;
        System.out.println("second " + currDayValue);
        if(currDayValue>=7) {
        	currDayValue-=7;
        }
        currDay = dayWeekValue.get(currDayValue);
        System.out.println(currDay);
        return currDay;
	}
}
