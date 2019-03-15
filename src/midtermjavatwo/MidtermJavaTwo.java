
package midtermjavatwo;

import java.io.File;
import java.time.LocalTime;
import java.util.Scanner;

/**
 *
 * @author Abby Snopek and Sam Tom
 */
public class MidtermJavaTwo {

    public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    Boolean endProgram = true;
    String usersChoice;
    
    //setting up new garage to park cars in
    Garage carPort = new Garage();

    File file = new File("tickets.txt");
    if(file.exists())
    {
        GarageFileIn fileIn = new GarageFileIn("tickets.txt");
        String line;
        String[] wordArray;

        while ((line = fileIn.fileReadLine()) != null) {

            if (line.isEmpty()) {
                continue;
            }

            wordArray = line.split(",");

            carPort.addCar(
                    new Car(
                            Integer.parseInt(wordArray[0]),
                            LocalTime.of(Integer.parseInt(wordArray[1]),0)
                    )
            );
        }

        fileIn.fileClose();
    }

    do{
        getMenuOne();
        usersChoice = keyboard.nextLine();
        
        switch(usersChoice) {
            case "1": getMenuTwo();
            String choice2 = keyboard.nextLine();
                switch(choice2) {
                    
                    case "1": 
                    {
                        Car c = new Car();
                        carPort.addCar(c);
                        c.Display();
                        //Give User Car ID Number
                    break;
                    }
                    case "2": getMenuOne();
                    break;
                }
            break;
                
            case "2": getMenuThree();
            String choice3 = keyboard.nextLine();
                switch(choice3) {
                    
                    //Check out car
                    case "1": checkOutCar();
                    String cTicketNumber = keyboard.nextLine();
                    carPort.leaveCar(Integer.parseInt(cTicketNumber));
                    
                    break;
                        
                    case "2": carPort.lostTicket();
                    break;
                        
                        
                    case "3": getMenuOne();
                    break;
                }
            break;
                //Close Garage Program
            
            case "3": carPort.displayAll();
            break;
            
            //close garage
            case "4": exitProgram(carPort);
                endProgram =false;
            break;
                
            default: getMenuOne();
            break;
        }
        
    }while (endProgram);
        
    
    
    }

    public static void menu()
    {
        System.out.println();
        System.out.println("Best Value Parking Garage");
        System.out.println("========================");
        System.out.println();
        System.out.println("Choose your option below: ");
    }
    
    public static void getMenuOne()
    {
        menu();
        System.out.println("1 - Checking into the garage");
        System.out.println("2 - Checking out of the garage");
        System.out.println("3 - Check cars in the garage");
        System.out.println("4 - Close Garage");
    }
    
    public static void exitProgram(Garage carPort)
    {
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
        System.out.println("Are you sure you would like to exit the program? Y/N: ");
        String exitChoice = keyboard.nextLine();
        
        switch(exitChoice.toUpperCase())
        {
            case "Y": System.out.println("Thank you for using Best Value Parking Garage");

                GarageFileOut fileOut = new GarageFileOut("tickets.txt");

                while(!carPort.carGarage.isEmpty())
                {
                    String line = "";
                    line = line+carPort.getCar().getID()+","+carPort.getCar().getTime().getHour();
                    fileOut.fileWrite(line);
                    carPort.getGarage().remove(0);
                }

                fileOut.fileClose();

                System.out.println("Total Revenue for the day: "+carPort.getTotalRevenue());

                break;
                
            case "N": getMenuOne();
        }
    }
    
    public static void getMenuTwo()
    {
        menu();
        System.out.println("1 - Check in Car");
        System.out.println("2 - Return to Main Menu");
    }
    
    public static void getMenuThree()
    {
        menu();
        System.out.println("1 - Check out Car");
        System.out.println("2 - Lost Ticket");
        System.out.println("3 - Return to Main Menu");
    }
    
    public static void checkOutCar()
    {
        System.out.println();
        System.out.println("What was your Car's ticket number? ");
        
    }
}
//