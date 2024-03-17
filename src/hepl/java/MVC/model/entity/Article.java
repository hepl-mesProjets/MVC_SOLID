package hepl.java.MVC.model.entity;

public class Article {
    private int id;
    private String intitule;
    private float prix;
    private int quantite;
    private boolean enCommande;

    public Article() {
        id = -1;
    }

    public Article(String intitule, float prix, int quantite, boolean enCommande) throws ArticleException {
        if (intitule.length() < 3)
            throw new ArticleException("Intitulé de l'article invalide !");
        if (prix <= 0.0)
            throw new ArticleException("Prix de l'article invalide !");
        if (quantite < 0)
            throw new ArticleException("Quantité de l'article invalide !");

        this.id = -1;
        this.intitule = intitule;
        this.prix = prix;
        this.quantite = quantite;
        this.enCommande = enCommande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) throws ArticleException {
        if (intitule.length() < 3)
            throw new ArticleException("Intitulé de l'article invalide !");
        this.intitule = intitule;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) throws ArticleException {
        if (prix <= 0.0)
            throw new ArticleException("Prix de l'article invalide !");
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) throws ArticleException {
        if (quantite < 0)
            throw new ArticleException("Quantité de l'article invalide !");
        this.quantite = quantite;
    }

    public boolean isEnCommande() {
        return enCommande;
    }

    public void setEnCommande(boolean enCommande) {
        this.enCommande = enCommande;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", intitule='" + intitule + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                ", enCommande=" + enCommande +
                '}';
    }

    @Override
    public Article clone() {
        Article copy = new Article();
        copy.id = this.id;
        copy.intitule = this.intitule;
        copy.prix = this.prix;
        copy.quantite = this.quantite;
        copy.enCommande = this.enCommande;
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id == article.id;
    }
}
