import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Subject extends Observable {

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

    public static void resetInvoices () {
        invoices = new ArrayList<> ();
    }

    private Invoice currentInvoice;

    public Subject (Invoice invoice) {
        addInvoice(invoice);
        currentInvoice = invoice;
    }

    public Subject () {
        this (new Invoice ());
    }

    public Invoice getCurrentInvoice () {
        return currentInvoice;
    }

    public void setObserver (Observer observer) {
        deleteObservers();
        addObserver(observer);
    }

    public void performAction () {
        setChanged ();
        notifyObservers ();
    }
}
