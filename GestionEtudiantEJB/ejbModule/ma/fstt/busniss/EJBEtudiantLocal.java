package ma.fstt.busniss;

import java.util.List;
import jakarta.ejb.Local;
import ma.fstt.entity.Etudiant;

@Local
public interface EJBEtudiantLocal {

	public void ajouterEtudiant(Etudiant etu);
	public List<Etudiant> getEtudiants();
	public void deleteEtudiant(Long id);
	public void updateEtudiant(Etudiant etu);
	public Etudiant trouverById(Long id);
}
