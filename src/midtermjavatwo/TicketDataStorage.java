package midtermjavatwo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TicketDataStorage {

    ArrayList<TotalPayments> totalPayments;

    public TicketDataStorage(){}

    public void addTotals(ArrayList<Ticket> tickets)
    {
        for (Ticket ticket:tickets
             ) {
            boolean ticketTypeFound = false;
            for (TotalPayments total:totalPayments
                 ) {
                if(ticket.getPaymentType().getPaymentName().equals(total.getName()))
                {
                    total.addPayment(ticket.getTotal());
                    ticketTypeFound = true;
                }
            }
            if(!ticketTypeFound)
            {
                totalPayments.add(new TotalPayments(ticket.getPaymentType().getPaymentName(),ticket.getTotal()));
            }
        }
    }
}
