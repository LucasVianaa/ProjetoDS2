

package model;
public class Sessao {
    private int id, sala;
    private double precoAdulto, precoEstudante, precoIdoso;
    private boolean its3d;
    private String filme, tipo;

    public Sessao(int id, int sala, double precoAdulto, double precoEstudante, double precoIdoso, boolean its3d, String filme, String tipo) {
        this.id = id;
        this.sala = sala;
        this.precoAdulto = precoAdulto;
        this.precoEstudante = precoEstudante;
        this.precoIdoso = precoIdoso;
        this.its3d = its3d;
        this.filme = filme;
        this.tipo = tipo;
    }

    public Sessao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public double getPrecoAdulto() {
        return precoAdulto;
    }

    public void setPrecoAdulto(double precoAdulto) {
        this.precoAdulto = precoAdulto;
    }

    public double getPrecoEstudante() {
        return precoEstudante;
    }

    public void setPrecoEstudante(double precoEstudante) {
        this.precoEstudante = precoEstudante;
    }

    public double getPrecoIdoso() {
        return precoIdoso;
    }

    public void setPrecoIdoso(double precoIdoso) {
        this.precoIdoso = precoIdoso;
    }

    public boolean isIts3d() {
        return its3d;
    }

    public void setIts3d(boolean its3d) {
        this.its3d = its3d;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
