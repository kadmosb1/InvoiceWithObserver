public class Order extends Subject {

    private String invoiceNumber;

    public Order () {
        Invoice invoice = new Invoice ();
        setCurrentInvoice (invoice);
        addInvoice(invoice);
        setObserver (new ActionStart (invoice));
    }
}