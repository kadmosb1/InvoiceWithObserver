public class Approval extends Subject {

    public Approval (String invoiceNumber) {
        super ();

        Invoice invoice = getInvoice(invoiceNumber);

        if (invoice != null) {
            setObserver (new ActionApprove (invoice));
        }
    }
}