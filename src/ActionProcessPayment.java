public class ActionProcessPayment extends Action {

    public ActionProcessPayment(Invoice invoice) {
        super (invoice);
    }

    @Override
    public void update () {
        getInvoice().processPayment();
    }
}
