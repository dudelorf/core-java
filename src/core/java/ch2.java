package core.java;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author eric
 */
public class ch2 {
    
    public void ex1(){
        
        LocalDate date = LocalDate.of(2017, Month.DECEMBER, 1);
        Month thisMonth = date.getMonth();
        
        DayOfWeek[] days = new DayOfWeek[7];
        days[0] = DayOfWeek.SUNDAY;
        System.arraycopy(DayOfWeek.values(), 0, days, 1, 6);
        
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
    
    public void ex6(){
        Point p = new Point(3, 4).translate(1, 3).scale(0.5);
        System.out.println(p);
    }
    
    public void ex11(){
        Cal calendar = new Cal();
        calendar.printCal();
    }
    
    public void ex15(){
        Invoice invoice = new Invoice();
        invoice.addItem("bananas", 3, .5);
        invoice.addItem("apples", 12, .75);
        invoice.printInvoice();
    }
}