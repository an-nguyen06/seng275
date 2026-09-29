package lab06;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class InvoiceFilterTest {
    private InvoiceFilter invoiceFilter;
    private IssuedInvoices issuedInvoicesMock;

    @Test
    void allHighValueInvoices() {
        // every invoice in the list should be high-value44
        IssuedInvoices issuedInvoicesMock = mock(IssuedInvoices.class, withSettings().verboseLogging());
        invoiceFilter = new InvoiceFilter(issuedInvoicesMock);
        when(issuedInvoicesMock.all()).thenReturn(List.of(new Invoice(43), new Invoice(120)));
        assertThat(invoiceFilter.highValueInvoices()).containsExactly(new Invoice(120));
        verify(issuedInvoicesMock).all();
    }

    @Test
    void allLowValueInvoices() {
        IssuedInvoices issuedInvoicesMock = mock(IssuedInvoices.class, withSettings().verboseLogging());
        invoiceFilter = new InvoiceFilter(issuedInvoicesMock);
        when(issuedInvoicesMock.all()).thenReturn(List.of(new Invoice(43), new Invoice(250)));
        assertThat(invoiceFilter.lowValueInvoices()).containsExactly(new Invoice(43));
        verify(issuedInvoicesMock).all();
    }

    @Test
    void someLowValueInvoices() {
        // Some low value invoices, some high
        IssuedInvoices issuedInvoicesMock = mock(IssuedInvoices.class, withSettings().verboseLogging());
        invoiceFilter = new InvoiceFilter(issuedInvoicesMock);
        when(issuedInvoicesMock.all()).thenReturn(List.of(new Invoice(40), new Invoice(200), new Invoice(0)));
        assertThat(invoiceFilter.someLowValueInvoices()).containsExactly(new Invoice(40), new Invoice(200), new Invoice(95));
        verify(issuedInvoicesMock).all();

    }
}
