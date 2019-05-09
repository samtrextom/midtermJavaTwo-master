package midtermjavatwo;


import midtermjavatwo.BestValueParkingGarageFees.LostFee;
import midtermjavatwo.BestValueParkingGarageFees.MinMaxFee;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author asnopek and samtrextom
 */
public class Garage {

    private static Garage instance = null;

    //arraylists to hold cars and money they earn
    //<Ticket> declares its going to have cars in it
    ArrayList<Ticket> openTickets = new ArrayList();
    ArrayList<Ticket> closedTickets = new ArrayList();

    private PaymentStructure paymentStructure;


    //method addCar
    //method leaveCar--> car out of array, check time for payment, equation and add to total bank
    //
    //

    public Garage(){}

    public void setPaymentStructure(PaymentStructure paymentStructure)
    {
        this.paymentStructure = paymentStructure;
    }

    public String getGarageName(){return paymentStructure.getName(); }


    public void addCar(Ticket c)
    {
        //adding a car to the Arraylist carGarage
        openTickets.add(c);
    }

    public Ticket findTicket(int ID)
    {
        for(int i = 0; i < openTickets.size(); i++) {
            if (openTickets.get(i).getID() == ID) {
                Ticket ticket = openTickets.get(i);
                openTickets.remove(i);
                ticket.setPaymentType(new MinMaxFee());
                return ticket;
            }
        }
        System.out.println("Ticket not found!\n");
        return new Ticket(new LostFee());
    }

    public void displayAll()
    {
        for(int i = 0; i < openTickets.size(); i++)
        {
            openTickets.get(i).Display();
            System.out.println();
        }
    }

    public Ticket getTicket() { return openTickets.get(0); }

    public List getOpenTickets() { return openTickets; }

    public List getClosedTickets() { return closedTickets; }

    public static Garage getInstance()
    {
        if(instance == null)
        {
            instance = new Garage();
        }
        return instance;
    }

}
