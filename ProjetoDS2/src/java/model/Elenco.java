
package model;

import java.util.List;

public class Elenco {
    private Filme filme;
    private List<String> atores;

    public Elenco() {
    }

    public Elenco(Filme filme, List<String> atores) {
        this.filme = filme;
        this.atores = atores;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public List<String> getAtores() {
        return atores;
    }

    public void setAtores(List<String> atores) {
        this.atores = atores;
    }
    
    
    
}
