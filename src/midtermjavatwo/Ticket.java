package midtermjavatwo;


import java.time.LocalDateTime;
import java.time.LocalTime;

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
    
    private LocalTime time;
    private int ID;
    private boolean open;
    private double total;
    private PaymentType paymentType;

    //get methods
    //set methods
    //constructor time
    
    //constructing car to get the data of date and time
    //whenever we make a new car, it sets it to the whatever the current time it
    public Ticket()
    {
        int randTime = (int)((Math.random()*5)+7);
        System.out.println(randTime);
        this.time = LocalTime.of(randTime, 0);
        this.ID = 0;
    }

    public Ticket(int i, LocalTime t)
    {
        this.ID = i;
        this.time = t;
    }

    public Ticket(PaymentType paymentType)
    {
        this.paymentType = paymentType;
    }
    
    //returning the variable time
    public LocalTime getTime()
    {
       return time;
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


    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
