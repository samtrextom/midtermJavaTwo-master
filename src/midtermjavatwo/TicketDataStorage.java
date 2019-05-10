package midtermjavatwo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TicketDataStorage {

    private static TicketDataStorage instance = null;

    ArrayList<TotalPayments> totalPayments = new ArrayList();

    private TicketDataStorage(){}

    public void addExistingTotal(String line)
    {
        String[] wordArray = line.split("%");
        totalPayments.add(new TotalPayments(
                wordArray[0],
                Double.parseDouble(wordArray[1]),
                Integer.parseInt(wordArray[2])
        ));
    }

    public void addTotals(ArrayList<Ticket> tickets)
    {
        for (Ticket ticket:tickets
             ) {

            boolean ticketTypeFound = false;

            for (TotalPayments total : totalPayments
            ) {
                if (ticket.getPaymentType().getPaymentName().equals(total.getName())) {
                    total.addPayment(ticket.getTotal());
                    ticketTypeFound = true;
                }
            }
            if (!ticketTypeFound) {
                totalPayments.add(new TotalPayments(ticket.getPaymentType().getPaymentName(), ticket.getTotal()));
            }
        }
    }

    public void displayAllTotals()
    {
        for (TotalPayments total:totalPayments
             ) {
            total.display();
        }
    }

    public boolean hasTotal()
    {
        if(totalPayments.isEmpty())
        {
            return false;
        }
        return true;
    }

    public String writeToFile(int index)
    {
        String line = totalPayments.get(index).toString();
        totalPayments.remove(index);
        return line;
    }

    public static TicketDataStorage getInstance()
    {
        if(instance == null)
        {
            instance = new TicketDataStorage();
        }
        return instance;
    }
}
