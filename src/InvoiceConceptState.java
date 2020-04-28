public class InvoiceConceptState extends InvoiceState {

    public InvoiceConceptState(Invoice invoice, String name) {
        super(invoice, name);
    }

    @Override
    public void start() {
        log ("start");
    }

    @Override
    public void approve() {
        getInvoice().sendInvoice();
    }

    @Override
    public void processPayment() {
        log ("processPayment");
    }
}
