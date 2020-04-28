import java.util.Observable;
import java.util.Observer;

public class ActionStart extends Action {

    public ActionStart (Invoice invoice) {
        super (invoice);
    }

    @Override
    public void update(Observable o, Object arg) {
        getInvoice ().start ();
    }
}