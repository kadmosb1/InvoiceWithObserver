public class ActionApprove extends Action {

    public ActionApprove (Invoice invoice) {
        super (invoice);
    }

    @Override
    public void update () {
        getInvoice().approve();
    }
}
