package br.com.aurum.astrea.service;

import br.com.aurum.astrea.controller.ContactController;
import br.com.aurum.astrea.dao.ContactDao;
import br.com.aurum.astrea.domain.Contact;
import br.com.aurum.astrea.exception.ValidationException;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
public class ContactServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(ContactServlet.class);
	private ContactDao dao = new ContactDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Contact contact = new Gson().fromJson(req.getReader(), Contact.class);
		try {
			new ContactController(dao).save(contact);
		} catch (ValidationException e) {
			logger.debug("Falha ao adicioanar um contato.", e);
			resp.setStatus(400);
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(e.getMessage());
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String paramId = req.getParameter("id");
		if(hasId(paramId)) {
			Contact contact = new ContactController(dao).getById(Long.parseLong(paramId));
			resp.getWriter().write(new Gson().toJson(contact));
		} else {
			List<Contact> contacts = new ContactController(dao).list();
			resp.getWriter().write(new Gson().toJson(contacts));
		}
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
	}

	private boolean hasId(String paramId) {
		return paramId != null && !paramId.isEmpty();
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		new ContactController(dao).delete(id);
	}
}
