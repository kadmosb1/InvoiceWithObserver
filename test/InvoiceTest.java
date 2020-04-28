import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InvoiceTest {

    private Order order;
    private Invoice invoice;
    private String invoiceNumber;

    @Before
    public void setup () {
        Subject.reset ();
        order = new Order ();
        invoice = order.getCurrentInvoice ();
        invoiceNumber = invoice.getInvoiceNumber ();
    }

    @Test
    public void testInitialState () {
        System.out.println ("============ Test constructor (in initialized state)");
        System.out.println ("============ Test whether in initialized state");
        invoice.isInitialized ();
        System.out.println ("============");
    }

    @Test
    public void testActionsFromInitialState () {

        System.out.println ("============ Test actions from Initial State (only start allowed)");

        // Invoice is in Initial State and can't be approved and payment can't be processed.
        new Approval (invoiceNumber).performAction ();
        assertFalse (invoice.isSent ());
        new Payment (invoiceNumber, true).performAction();
        assertFalse (invoice.isPaid ());

        // Invoice is in Initial State and can be started into Concept State.
        System.out.println ("============ Only start allowed");
        order.performAction ();
        assertTrue (invoice.isConcept ());

        System.out.println ("============");
    }

    @Test
    public void testActionsFromConceptState () {

        System.out.println ("============ Test actions from Concept State (only approve allowed)");

        // First upgrade Invoice to Concept State.
        order.performAction ();

        // Invoice is in Concept State and payment can't be processed.
        new Payment (invoiceNumber, true).performAction();
        assertTrue (invoice.isConcept ());

        // Invoice is in Concept State and can be approved to Sent State.
        System.out.println ("============ Only approve allowed");
        new Approval (invoiceNumber).performAction();
        assertTrue (invoice.isSent ());

        System.out.println ("============");
    }

    @Test
    public void testActionsFromSentState () {

        System.out.println ("============ Test actions from Sent State (only process payment allowed)");

        // First upgrade Invoice to Sent State.
        order.performAction ();
        new Approval (invoiceNumber).performAction ();
        assertTrue (invoice.isSent ());

        // Invoice is in Sent State and can't be approved.
        new Approval (invoiceNumber).performAction ();
        assertTrue (invoice.isSent());

        // Invoice is in Sent State and payment can be processed to Paid State.
        System.out.println ("============ Only process payment allowed");
        new Payment (invoiceNumber, true).performAction ();
        assertTrue (invoice.isPaid ());

        System.out.println ("============");

    }

    @Test
    public void testActionsFromPaidState () {

        System.out.println ("============ Test actions from Paid State (no action allowed)");

        // First upgrade Invoice to Paid State.
        order.performAction ();
        new Approval (invoiceNumber).performAction ();
        new Payment (invoiceNumber, true).performAction ();
        assertTrue (invoice.isPaid ());

        // Invoice is in Paid State and can't be upgraded to any other State.
        new Approval (invoiceNumber).performAction ();
        assertFalse (invoice.isSent ());
        new Payment (invoiceNumber, true).performAction ();
        assertTrue (invoice.isPaid ());

        System.out.println ("============");
    }
}