import java.util.Observable;
import java.util.Observer;

public class ActionApprove extends Action {

    public ActionApprove (Invoice invoice) {
        super (invoice);
    }

    @Override
    public void update (Observable o, Object arg) {
        getInvoice ().approve ();
    }
}
