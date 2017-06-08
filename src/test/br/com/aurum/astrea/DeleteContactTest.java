package br.com.aurum.astrea;

import br.com.aurum.astrea.controller.ContactController;
import br.com.aurum.astrea.dao.ContactDao;
import br.com.aurum.astrea.domain.Contact;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

/**
 * Created by diegom on 08/06/2017.
 */
public class DeleteContactTest {
    private ContactDao mockDAO;
    private Contact contactDiego;
    private ContactController controller;

    @Before
    public void setup() {
        mockDAO = mock(ContactDao.class);
        contactDiego = createContact("Diego Melo", "diegomeloadm@gmail.com");
        controller = new ContactController(mockDAO);
    }

    private Contact createContact(String name, String email) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setEmails(Arrays.asList(new String[]{email}));
        return contact;
    }

    @Test
    public void deleteAContact() {
        Long contactId = 1L;
        when(mockDAO.getById(contactId)).thenReturn(contactDiego);
        doNothing().when(mockDAO).delete(contactDiego);
        controller.delete(contactId);
        verify(mockDAO, times(1)).delete(contactDiego);
    }

    @Test
    public void notDeleteWithInvalidId() {
        long contactId = 2L;
        when(mockDAO.getById(contactId)).thenReturn(null);
        doNothing().when(mockDAO).delete(contactDiego);
        controller.delete(contactId);
        verify(mockDAO, times(0)).delete(contactDiego);
    }
}
