package mainClasses;
import java.util.ArrayList;

public class Famille {
	
	private int idFamille;
	public ArrayList<Habitant> membresFamille = new ArrayList<Habitant>();
	public ArrayList<Paquet> paquets = new ArrayList<Paquet>();
	Village village;
	
	public Famille(int idFamille, Village village) {
		this.idFamille = idFamille;
		this.village = village;
	}

	public int getIdFamille() {
		return idFamille;
	}

	public void setIdFamille(int idFamille) {
		this.idFamille = idFamille;
	}

	// fonction qui vérifie si une famille contient des enfants
	public boolean contientEnfants() {
		for (int i = 0; i < this.membresFamille.size(); i++) {
			//if (this.membresFamille.get(i).getAge()<=12)
				return true;
		}
		return false;
	}

	
}
