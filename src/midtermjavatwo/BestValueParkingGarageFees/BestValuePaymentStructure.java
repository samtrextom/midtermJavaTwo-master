package midtermjavatwo.BestValueParkingGarageFees;

import midtermjavatwo.PaymentStructure;
import midtermjavatwo.PaymentType;

public class BestValuePaymentStructure implements PaymentStructure {

    private String garageName = "Best Value Parking Garage";

    @Override
    public PaymentType getPaymentType(String paymentType) {
        return null;
    }

    @Override
    public String getName() {
        return garageName;
    }

}
