package ma.fstt.busniss;

import java.util.List;
import jakarta.ejb.Remote;
import ma.fstt.entity.Etudiant;

@Remote
public interface EJBEtudiantRemote {
	public void ajouterEtudiant(Etudiant etu);
	public List<Etudiant> getEtudiants();
	public void deleteEtudiant(Long id);
	public void updateEtudiant(Etudiant etu);
	public Etudiant trouverById(Long id);
}
