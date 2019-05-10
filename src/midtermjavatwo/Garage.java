package midtermjavatwo;


import midtermjavatwo.BestValueParkingGarageFees.LostFee;
import midtermjavatwo.BestValueParkingGarageFees.MinMaxFee;

import java.io.File;
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
    private ArrayList<Ticket> openTickets = new ArrayList();
    private ArrayList<Ticket> closedTickets = new ArrayList();


    private TicketDataStorage ticketDataStorage = TicketDataStorage.getInstance();

    private int totalLostTickets = 0;

    private PaymentStructure paymentStructure;


    //method addTicket
    //method leaveCar--> car out of array, check time for payment, equation and add to total bank
    //
    //

    private Garage(){}

    public void setPaymentStructure(PaymentStructure paymentStructure)
    {
        this.paymentStructure = paymentStructure;
    }

    public String getGarageName(){return paymentStructure.getName(); }


    public void addTicket(Ticket c)
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
                return ticket;
            }
        }
        System.out.println("Ticket not found!\n");
        totalLostTickets ++;
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

    public void addLostTicket()
    {
        totalLostTickets++;
    }

    public void addClosedTicket(Ticket ticket)
    {
        closedTickets.add(ticket);
    }

    public void openGarage()
    {
        File file = new File("tickets.txt");
        if(file.exists())
        {
            GarageFileIn fileIn = new GarageFileIn("tickets.txt");
            String line;

            while ((line = fileIn.fileReadLine()) != null) {

                if (line.isEmpty()) {
                    continue;
                }
                ticketDataStorage.addExistingTotal(line);
            }

            fileIn.fileClose();
        }
    }

    public void closeGarage()
    {


        if(!openTickets.isEmpty()) {
            int remainingTickets = openTickets.size() - totalLostTickets;

            for(int i = 0; i < remainingTickets; i++)
            {
                Ticket ticket = new Ticket(new LostFee());
                ticket.calculateTotal();
                closedTickets.add(ticket);
            }
        }
        if(!closedTickets.isEmpty()) {
            ticketDataStorage.addTotals(closedTickets);
        }
            GarageFileOut fileOut = new GarageFileOut("tickets.txt");
            ticketDataStorage.displayAllTotals();

            while (ticketDataStorage.hasTotal()) {
                String line = ticketDataStorage.writeToFile(0);
                fileOut.fileWrite(line);
            }
            fileOut.fileClose();

    }

    public static Garage getInstance()
    {
        if(instance == null)
        {
            instance = new Garage();
        }
        return instance;
    }

}
