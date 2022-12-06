package ma.fstt.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstt.busniss.EJBEtudiantRemote;
import ma.fstt.entity.Etudiant;

@WebServlet("")
public class EtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EtudiantServlet() {
	}

	@EJB(mappedName = "java:global/GestionEtudiantEJB/EJBEtudiant!ma.fstt.busniss.EJBEtudiantRemote")
	EJBEtudiantRemote ejb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		try {
			if (action == null) {
				listEtudiants(request, response);
			} else {
				switch (action) {
				case "new":
					showNewForm(request, response);
					break;
				case "add":
					addEtudiant(request, response);
					break;
				case "edit":
					showEditForm(request, response);
					break;
				case "update":
					updateEtudiant(request, response);
					break;
				case "delete":
					deleteEtudiant(request, response);
					break;
				default:
					listEtudiants(request, response);
					break;
				}
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listEtudiants(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Etudiant> listEtudiant = ejb.getEtudiants();

		request.setAttribute("listEtudiant", listEtudiant);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ListEtudiants.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("EtudiantForm.jsp");
		dispatcher.forward(request, response);
	}

	private void addEtudiant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String cne = request.getParameter("cne");
		String adresse = request.getParameter("adresse");
		String niveau = request.getParameter("niveau");
		Etudiant etudiant = new Etudiant(nom, prenom, cne, adresse, niveau);
		ejb.ajouterEtudiant(etudiant);

		response.sendRedirect("/GestionEtudiantWeb");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Etudiant etudiant = ejb.trouverById(Long.parseLong(request.getParameter("id")));
		request.setAttribute("etudiant", etudiant);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EtudiantForm.jsp");
		dispatcher.forward(request, response);
	}

	private void updateEtudiant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Long id = Long.parseLong(request.getParameter("id_etudiant"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String cne = request.getParameter("cne");
		String adresse = request.getParameter("adresse");
		String niveau = request.getParameter("niveau");
		Etudiant etudiant = new Etudiant(id, nom, prenom, cne, adresse, niveau);
		ejb.updateEtudiant(etudiant);
		response.sendRedirect("/GestionEtudiantWeb");
	}
	
	private void deleteEtudiant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		ejb.deleteEtudiant(Long.parseLong(request.getParameter("id")));
		response.sendRedirect("/GestionEtudiantWeb");
	}

}
