package ma.fstt.busniss;

import java.util.List;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ma.fstt.entity.Etudiant;

/**
 * Session Bean implementation class EJBEtudiant
 */
@Stateless
@LocalBean
public class EJBEtudiant implements EJBEtudiantRemote, EJBEtudiantLocal {
	
	@PersistenceContext(unitName = "Etudiant")
	private EntityManager entityManager;

	public EJBEtudiant() {
	}

	@Override
	public void ajouterEtudiant(Etudiant etu) {
		entityManager.persist(etu);
	}

	@Override
	public List<Etudiant> getEtudiants() {
		String q = "SELECT p from  Etudiant p";
		Query query = entityManager.createQuery(q);
		@SuppressWarnings("unchecked")
		List<Etudiant> projects = query.getResultList();
		return projects;
	}

	@Override
	public void deleteEtudiant(Long id) {
		Etudiant u = entityManager.find(Etudiant.class, id);
		entityManager.remove(u);
	}

	@Override
	public void updateEtudiant(Etudiant etu) {
		Etudiant u = entityManager.find(Etudiant.class, etu.getId_etudiant());
		u.setNom(etu.getNom());
		u.setPrenom(etu.getPrenom());
		u.setCne(etu.getCne());
		u.setAdresse(etu.getAdresse());
		u.setNiveau(etu.getNiveau());
	}

	@Override
	public Etudiant trouverById(Long id) {

		Etudiant e = entityManager.find(Etudiant.class, id);
		if (e == null)
			throw new RuntimeException("Etudiant n'existe pas");
		return e;
	}

}
