package midtermjavatwo.BestValueParkingGarageFees;

import midtermjavatwo.MenuType;
import midtermjavatwo.PrintMenu;

public class BestValuePrintMenu implements PrintMenu {

    @Override
    public MenuType getMenuType(String menuType) {
        switch(menuType.toUpperCase())
        {
            case"WELCOME":
            {
                return new WelcomeMenu();
            }
            case"MAIN":
            {
                return new MainMenu();
            }
            case"CHECKIN":
            {
                return new CheckInMenu();
            }
            case"CHECKOUT":
            {
                return new CheckOutMenu();
            }
            case"TICKETNUMBER":
            {
                return new TicketNumberPrompt();
            }
            case"PAYOPTION":
            {
                return new PaymentOptionsMenu();
            }
            default:
            {
                return null;
            }
        }
    }
}
