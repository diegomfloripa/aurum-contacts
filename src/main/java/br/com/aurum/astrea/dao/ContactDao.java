package br.com.aurum.astrea.dao;

import br.com.aurum.astrea.domain.Contact;
import com.googlecode.objectify.ObjectifyService;

import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class ContactDao {
	
	static {
		ObjectifyService.register(Contact.class);
	}
	
	public void save(Contact contact) {
		ofy().save().entity(contact).now();
	}

	public Contact getById(Long contactId) {
		return ofy()
				.load()
				.type(Contact.class)
				.id(contactId)
				.now();
	}
	
	public List<Contact> list() {
		return ofy().load().type(Contact.class).list();
	}
	
	public void delete(Contact contact) {
		ofy().delete().entity(contact).now();
	}
}
