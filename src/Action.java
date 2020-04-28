import java.util.Observer;

public abstract class Action implements Observer {

    private Invoice invoice;

    public Action (Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice () {
        return invoice;
    }
}