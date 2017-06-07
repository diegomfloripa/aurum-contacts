package br.com.aurum.astrea.service;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aurum.astrea.dao.ContactDao;
import br.com.aurum.astrea.domain.Contact;
import com.google.gson.Gson;

@SuppressWarnings("serial")
public class ContactServlet extends HttpServlet {

	private static final ContactDao DAO = new ContactDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Contact contact = new Gson().fromJson(req.getReader(), Contact.class);
		DAO.save(contact);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO: Implementar um método que irá listar todas as entidades do tipo 'Contato' e devolver para o client essa listagem.
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO: Implementar um método que irá deletar uma entidade do tipo 'Contato', dado parâmetro de identificação.
	}
}
