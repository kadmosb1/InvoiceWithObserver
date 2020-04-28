public class InvoicePaidState extends InvoiceState {

    public InvoicePaidState(Invoice invoice, String name) {
        super (invoice, name);
    }

    @Override
    public void start() {
        log ("start");
    }

    @Override
    public void approve() {
        log ("approve");
    }

    @Override
    public void processPayment () {
        log ("processPayment");
    }
}
