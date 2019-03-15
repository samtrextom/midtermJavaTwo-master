package midtermjavatwo;


import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author asnopek
 */
public class Garage {
    
    //arraylists to hold cars and money they earn
    //<Car> declares its going to have cars in it
    ArrayList<Car> carGarage = new ArrayList();
    
    //private double for total of money made
    private double totalRevenue;
    private int carCount;
    Boolean carFound = false;

    
    //method addCar
    //method leaveCar--> car out of array, check time for payment, equation and add to total bank
    //
    //
    
    public Garage()
    {
        carCount = 0;
    }
    
    
    
    public void addCar(Car c)
    
    {
        if(c.getID() == 0)
        {
            c.setID(carCount++);
        }
        carCount++;
        
        //adding a car to the Arraylist carGarage
        carGarage.add(c);
    }
    
    public void leaveCar(int ID)
    {
        double cost = 0;
        int carPosition = 0;
        for(int i = 0; i < carGarage.size(); i++)
        {
            if(carGarage.get(i).getID() == ID)
            {
                carPosition = i;
                carFound = true;
                Car c = carGarage.get(i);
                
                int randTime;
                randTime =(int)(Math.random() * 10) + 13;
                LocalTime leaveTime = LocalTime.of(randTime, 0);
                Duration d = Duration.between(leaveTime, c.getTime());
                
                if (d.toHours() <= 3)
                {
                    cost = 5;
                }
                else if (d.toHours() <= 12)
                {
                    cost = 5 + (d.toHours() - 3);
                }
                else
                {
                    cost = 15;
                }
                
                totalRevenue += cost;
                System.out.println("Thank you for using Best Value Parking Garage");
                System.out.println(d.toHours() + "hours parked");
                System.out.println("Total Cost: $" + cost + "\n");
                
            }
        }
        if (carFound)
        {
            carGarage.remove(carPosition);
        }
        else
        {
            System.out.println("Car not found!\n");
        }
        
        
    }
    
    public void lostTicket()
    {
        totalRevenue += 25;
        System.out.println("Thank you for using Best Value Parking Garage");
        System.out.println("You owe $25");
    }
    
    public void displayAll()
    {
        for(int i = 0; i < carGarage.size(); i++)
        {
            carGarage.get(i).Display();
            System.out.println();
        }
    }

    public Car getCar()
    {
        return carGarage.get(0);
    }

    public List getGarage()
    {
        return carGarage;
    }

    public double getTotalRevenue()
    {
        return totalRevenue;
    }

}
