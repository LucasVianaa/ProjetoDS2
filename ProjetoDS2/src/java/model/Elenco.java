
package model;



public class Elenco {
    private int id;
    private Filme filme;
    private String ator;

    public Elenco() {
    }

    public String getAtor() {
        return ator;
    }

    public void setAtor(String ator) {
        this.ator = ator;
    }

    public Elenco(int id, Filme filme, String ator) {
        this.id = id;
        this.filme = filme;
        this.ator = ator;
    }

    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    
    
    
    
}
