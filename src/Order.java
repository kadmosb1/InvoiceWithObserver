public class Order extends Subject {

    public Order () {
        super ();
        setObserver(new ActionStart (getCurrentInvoice()));
    }
}