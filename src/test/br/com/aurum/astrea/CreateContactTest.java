package br.com.aurum.astrea;

import br.com.aurum.astrea.controller.ContactController;
import br.com.aurum.astrea.dao.ContactDao;
import br.com.aurum.astrea.domain.Contact;
import br.com.aurum.astrea.exception.ValidationException;
import org.junit.Before;
import org.junit.Test;


import java.util.*;
import static org.mockito.Mockito.*;

/**
 * Created by diegom on 07/06/2017.
 */
public class CreateContactTest {
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
    public void createAContact() throws ValidationException {
        doNothing().when(mockDAO).save(contactDiego);
        controller.save(contactDiego);
        verify(mockDAO, times(1)).save(contactDiego);
    }

    @Test(expected = ValidationException.class)
    public void validateNameWhenCreateContact() throws ValidationException {
        contactDiego.setName("");
        doNothing().when(mockDAO).save(contactDiego);
        controller.save(contactDiego);
    }
}
