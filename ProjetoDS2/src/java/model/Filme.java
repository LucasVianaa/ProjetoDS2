
package model;
public class Filme {
    private int duracao, faixaEtaria, id;
    private String trailer, genero, diretor, sinopse;

    public Filme(int duracao, int faixaEtaria, int id, String trailer, String genero, String diretor, String sinopse) {
        this.duracao = duracao;
        this.faixaEtaria = faixaEtaria;
        this.id = id;
        this.trailer = trailer;
        this.genero = genero;
        this.diretor = diretor;
        this.sinopse = sinopse;
    }

    public Filme() {
    }
    
    
    
    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
}
