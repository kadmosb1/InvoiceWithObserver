public class ActionStart extends Action {

    public ActionStart (Invoice invoice) {
        super (invoice);
    }

    @Override
    public void update () { getInvoice().start(); }
}