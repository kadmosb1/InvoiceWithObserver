import java.util.Observable;
import java.util.Observer;

public class ActionProcessPayment extends Action {

    public ActionProcessPayment(Invoice invoice) {
        super (invoice);
    }

    @Override
    public void update(Observable o, Object arg) {
        getInvoice ().processPayment ();
    }
}
