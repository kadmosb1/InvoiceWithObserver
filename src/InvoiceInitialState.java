public class InvoiceInitialState extends InvoiceState {

    public InvoiceInitialState(Invoice invoice, String name) {
        super(invoice, name);
    }

    @Override
    public void start() {
        getInvoice ().newInvoice();
    }

    @Override
    public void approve() {
        log ("approve");
    }

    @Override
    public void processPayment() {
        log ("processPayment");
    }
}
