package com.portfolio.model;

import java.util.List;

public class OptimizarResponse {
    private List<String> seleccionados;
    private int ganancia_total;
    private int peso_total;

    public OptimizarResponse(List<String> seleccionados, int ganancia_total, int peso_total) {
        this.seleccionados = seleccionados;
        this.ganancia_total = ganancia_total;
        this.peso_total = peso_total;
    }
    public List<String> getSeleccionados() { return seleccionados; }
    public void setSeleccionados(List<String> seleccionados) { this.seleccionados = seleccionados; }
    public int getGanancia_total() { return ganancia_total; }
    public void setGanancia_total(int ganancia_total) { this.ganancia_total = ganancia_total; }
    public int getPeso_total() { return peso_total; }
    public void setPeso_total(int peso_total) { this.peso_total = peso_total; }
}
