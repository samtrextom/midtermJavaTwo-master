package midtermjavatwo;

public class TotalPayments {

    private double total;
    private String name;

    public TotalPayments(String name, double total)
    {
        this.name = name;
        this.total = total;
    }

    public void addPayment(double payment)
    {
        total += payment;
    }

    public String getName(){return name;}
}
