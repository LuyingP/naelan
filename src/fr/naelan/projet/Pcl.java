package fr.naelan.projet;

public class Pcl implements Comparable<Pcl> {
	
	private long taille;
	private String nom;
	private String type;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getTaille() {
		return taille;
	}
	public void setTaille(long taille) {
		this.taille = taille;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Pcl(long taille, String nom) {
		super();
		this.taille = taille;
		this.nom = nom;
	}
	public Pcl() {
	}
	
	
	public Pcl(long taille, String nom, String type) {
		super();
		this.taille = taille;
		this.nom = nom;
		this.type = type;
	}
	@Override
	public int compareTo(Pcl o) {
		
		return Long.compare(this.getTaille(), o.getTaille());
			
	}
	
	
	
	

}
