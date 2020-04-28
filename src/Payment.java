public class Payment extends Subject {

    public Payment (String invoiceNumber, boolean paymentReceived) {

        if (paymentReceived) {

            Invoice invoice = getInvoice(invoiceNumber);

            if (invoice != null) {
                setObserver (new ActionProcessPayment (invoice));
            }
        }
    }
}