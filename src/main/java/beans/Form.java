package beans;

public class Form {
    private int id;
    private String initiale;
    private String nom;
    private String email;
    private String langues;
    private String domaine;
    
   
    public Form() {}
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getInitiale() { return initiale; }
    public void setInitiale(String initiale) { this.initiale = initiale; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getLangues() { return langues; }
    public void setLangues(String langues) { this.langues = langues; }
    
    public String getDomaine() { return domaine; }
    public void setDomaine(String domaine) { this.domaine = domaine; }
}
