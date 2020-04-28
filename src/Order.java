public class Order extends Subject {

    private String invoiceNumber;

    public Order () {
        super ();
        setObserver(new ActionStart (getCurrentInvoice()));
    }
}