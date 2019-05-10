package midtermjavatwo;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asnopek
 */
public class Ticket {
    
    private LocalTime enterTime = LocalTime.of(0,0);
    private LocalTime outTime;
    private int ID;
    private double total;
    private PaymentType paymentType;

    //get methods
    //set methods
    //constructor time
    
    //constructing car to get the data of date and time
    //whenever we make a new car, it sets it to the whatever the current time it
    public Ticket()
    {
        Random rand = new Random();
        int randHour = rand.nextInt(6)+7;
        //System.out.println(randTime);
        this.enterTime = LocalTime.of(randHour, 0);
        this.ID = 0;
    }

    public Ticket(int i, LocalTime t)
    {
        this.ID = i;
        this.enterTime = t;
    }

    public Ticket(PaymentType paymentType)
    {
        this.paymentType = paymentType;
    }
    
    //returning the variable time
    public LocalTime getTime()
    {
       return enterTime;
    }
    
    //returns whatever is in the int ID
    //in getters you have to declare type which you are returning
    //any time I create a getting, you have to declare the type
    public int getID()
    {
        return ID;
    }
    
    //changes the ID to the int we're taking in
    public void setID(int i)
    {
        ID = i;
    }
    
    public void Display()
    {
        System.out.println("You checked in at " + getTime().getHour() + ":00");
        System.out.println("Your car ticket number is: " + getID());
    }

    public void calculateTotal() {

        Random rand = new Random();
        int randHour = rand.nextInt(11)+13;
        outTime = LocalTime.of(randHour,0);

        int hour = (int)Duration.between(enterTime,outTime).toHours();

        total = paymentType.getPaymentTotal(hour);
    }

    public String displayOutTime()
    {
        return outTime.toString();
    }

    public double getTotal(){return total;}

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
