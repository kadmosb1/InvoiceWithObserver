import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;

public class Subject {

    /*
     * Invoices can be found based on the invoice-number.
     */
    private static ArrayList<Invoice> invoices = new ArrayList<> ();

    public static void addInvoice (Invoice invoice) {
        invoices.add (invoice);
    }

    /*
     * Invoice can be found based on invoice number.
     */
    public static Invoice getInvoice (String invoiceNumber) {

        for (Invoice invoice : invoices) {

            if (invoice.getInvoiceNumber().equals (invoiceNumber)) {
                return invoice;
            }
        }

        System.out.println ("LOG: The invoice with number " + invoiceNumber + " can't be found in our systems.");
        return null;
    }

    public static void reset () {
        invoices = new ArrayList<> ();
    }

    private ArrayList<IObserver> observers;
    private Invoice currentInvoice;

    public Subject () {
        observers = new ArrayList<> ();
    }

    public void addObserver (IObserver observer) {
        observers.add (observer);
    }

    public void setObserver (IObserver observer) {
        observers = new ArrayList<> ();
        addObserver(observer);
    }

    public Invoice getCurrentInvoice () {
        return currentInvoice;
    }

    public void setCurrentInvoice (Invoice invoice) {
        currentInvoice = invoice;
    }

    public void performAction () {

        for (IObserver observer : observers) {
            observer.update();
        }
    }
}
