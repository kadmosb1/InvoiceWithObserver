public abstract class InvoiceState {

    private Invoice invoice;
    private String name;

    public InvoiceState (Invoice invoice, String name) {
        this.invoice = invoice;
        this.name = name;
    }

    public Invoice getInvoice () {
        return invoice;
    }

    public String getName () {
        return name;
    }

    public void log (String action) {
        invoice.log (name, action);
    }

    public abstract void start ();
    public abstract void approve ();
    public abstract void processPayment ();
}
