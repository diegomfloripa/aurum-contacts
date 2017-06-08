package br.com.aurum.astrea.controller;

import br.com.aurum.astrea.dao.ContactDao;
import br.com.aurum.astrea.domain.Contact;
import br.com.aurum.astrea.exception.ValidationException;

import java.util.List;

/**
 * Created by diegom on 07/06/2017.
 */
public class ContactController {
    private ContactDao dao;

    public ContactController(ContactDao dao) {
        this.dao = dao;
    }

    public void save(Contact contact) throws ValidationException {
        validateContact(contact);
        dao.save(contact);
    }

    private void validateContact(Contact contact) throws ValidationException {
        if(contact == null) {
            throw new ValidationException("contact is null");
        }
        if(contact.getName() == null || contact.getName().isEmpty()) {
            throw new ValidationException("Nome é necessário");
        }
    }

    public List<Contact> list() {
        return dao.list();
    }
}
