package core.java;

import java.time.LocalDate;
import static java.time.LocalDate.*;
import java.time.Month;
import static java.time.Month.*;
import java.time.DayOfWeek;
import static java.time.DayOfWeek.*;
import static java.lang.System.arraycopy;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author eric
 */
public class Cal {
    
    public void printCal(){
        LocalDate date = of(2017, DECEMBER, 1);
        Month thisMonth = date.getMonth();
        
        DayOfWeek[] days = new DayOfWeek[7];
        days[0] = SUNDAY;
        arraycopy(DayOfWeek.values(), 0, days, 1, 6);
        
        for(DayOfWeek day : days){
            System.out.print(" " + day.getDisplayName(TextStyle.SHORT, Locale.US));
        }
        System.out.println();
        
        while(date.getMonth() == thisMonth){
            if(date.getDayOfMonth() == 1){
                DayOfWeek firstDay = date.getDayOfWeek();
                for(DayOfWeek day: days){
                    if(day != firstDay) System.out.print("    ");
                    else break;
                }
            }
            
            System.out.printf("%4d", date.getDayOfMonth());
            
            if(date.getDayOfWeek() == days[6]) System.out.println();
            
            date = date.plusDays(1);
        }
        System.out.println();
    }
}
