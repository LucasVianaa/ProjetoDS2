

package model;

import java.util.Calendar;

public class Sessao {
    private int id, sala;
    private double precoAdulto, precoEstudante, precoIdoso;
    private boolean its3d, itsLegendado;
    private Filme filme;
    private Calendar horaInicio, horaFim;

    public Sessao() {
    }

    public Sessao(int id, int sala, double precoAdulto, double precoEstudante, double precoIdoso, boolean its3d, boolean itsLegendado, Filme filme, Calendar horaInicio, Calendar horaFim) {
        this.id = id;
        this.sala = sala;
        this.precoAdulto = precoAdulto;
        this.precoEstudante = precoEstudante;
        this.precoIdoso = precoIdoso;
        this.its3d = its3d;
        this.itsLegendado = itsLegendado;
        this.filme = filme;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public Calendar getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Calendar horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Calendar getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Calendar horaFim) {
        this.horaFim = horaFim;
    }

    public boolean isItsLegendado() {
        return itsLegendado;
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

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }


    public void setItsLegendado(boolean itsLegendado) {
        this.itsLegendado = itsLegendado;
    }
    
    
}
