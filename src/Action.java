public abstract class Action implements IObserver {

    private Invoice invoice;

    public Action (Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice () {
        return invoice;
    }

    public abstract void update ();
}