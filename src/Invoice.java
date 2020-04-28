public class Invoice {

    private InvoiceState initialState = new InvoiceInitialState (this, "Initial");
    private InvoiceState conceptState = new InvoiceConceptState (this, "Concept");
    private InvoiceState sentState = new InvoiceSentState(this, "Sent");
    private InvoiceState paidState = new InvoicePaidState(this, "Paid");

    private InvoiceState state;

    private static int invoiceNumberCounter = 1;
    private String invoiceNumber;

    public Invoice () {
        this.invoiceNumber = "Invoice-" + invoiceNumberCounter++;
        this.state = initialState;
    }

    public String getInvoiceNumber () {
        return invoiceNumber;
    }

    public boolean isInitialized () {
        return state == initialState;
    }

    public void start() {
        state.start ();
    }

    public boolean isConcept () {
        return state == conceptState;
    }

    public void approve() {
        state.approve ();
    }

    public boolean isSent () {
        return state == sentState;
    }

    public void processPayment() {
        state.processPayment();
    }

    public boolean isPaid () {
        return state == paidState;
    }

    protected void newInvoice () {
        state = conceptState;
        System.out.println ("A new invoice has been drawn up.");
    }

    protected void sendInvoice () {
        state = sentState;
        System.out.println ("The invoice has been approved and sent to the customer.");
    }

    protected void payInvoice () {
        state = paidState;
        System.out.println ("The customer has paid the invoice.");
    }

    protected void log (String state, String action) {
        System.out.format ("LOG: It isn't allowed to change states from %s using action %s%n", state, action);
    }
}
