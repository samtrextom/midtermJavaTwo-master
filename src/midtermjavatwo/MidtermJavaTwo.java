
package midtermjavatwo;

import midtermjavatwo.BestValueParkingGarageFees.BestValuePaymentStructure;
import midtermjavatwo.BestValueParkingGarageFees.BestValuePrintMenu;

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
        BestValuePaymentStructure paymentStructure = new BestValuePaymentStructure();
        BestValuePrintMenu printMenu = new BestValuePrintMenu();
        Garage carPort = Garage.getInstance();
        carPort.setPaymentStructure(paymentStructure);

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
                        new Ticket(
                                Integer.parseInt(wordArray[0]),
                                LocalTime.of(Integer.parseInt(wordArray[1]),0)
                        )
                );
            }

            fileIn.fileClose();
        }

        do{
            printMenu.getMenuType("WELCOME").print();
            printMenu.getMenuType("MAIN").print();
            usersChoice = keyboard.nextLine();

            switch(usersChoice) {
                //two
                case "1": printMenu.getMenuType("CHECKIN").print();
                String choice2 = keyboard.nextLine();
                    switch(choice2) {

                        case "1":
                        {
                            Ticket c = new Ticket();
                            carPort.addCar(c);
                            c.Display();
                            //Give User Ticket ID Number
                        break;
                        }
                        //one
                        case "2": printMenu.getMenuType("MAIN").print();
                        break;
                    }
                break;
                    //three
                case "2": printMenu.getMenuType("CHECKOUT").print();
                String choice3 = keyboard.nextLine();
                    switch(choice3) {

                        //Check out car
                        //checkoutCar
                        case "1": printMenu.getMenuType("PAYOPTION").print();
                        String choice4 = keyboard.nextLine();

                        switch(choice4)
                        {
                            case"1":
                            {
                                
                            }
                        }


                        break;

                        case "2": printMenu.getMenuType("MAIN").print();
                        break;
                    }
                break;
                    //Close Garage Program

                case "3": carPort.displayAll();
                break;

                //close garage
                case "4":
                    endProgram = exitProgram(carPort);
                break;
                    //one
                default: printMenu.getMenuType("MAIN").print();
                break;
            }

        }while (endProgram);
    }

    
    public static boolean exitProgram(Garage carPort)
    {
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
        System.out.println("Are you sure you would like to exit the program? Y/N: ");
        String exitChoice = keyboard.nextLine();
        
        switch(exitChoice.toUpperCase()) {
            case "Y":
                System.out.println("Thank you for using " + carPort.getGarageName());

                GarageFileOut fileOut = new GarageFileOut("tickets.txt");

                while (!carPort.carGarage.isEmpty()) {
                    String line = "";
                    line = line + carPort.getCar().getID() + "," + carPort.getCar().getTime().getHour();
                    fileOut.fileWrite(line);
                    carPort.getGarage().remove(0);
                }

                fileOut.fileClose();

                System.out.println("Total Revenue for the day: " + carPort.getTotalRevenue());
                return false;

            //ONE
            default:
                return true;
        }
    }
}
//