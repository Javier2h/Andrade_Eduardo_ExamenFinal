package com.portfolio.model;

import java.util.List;

public class OptimizarRequest {
    private int capacidad;
    private List<Proyecto> objetos;

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    public List<Proyecto> getObjetos() { return objetos; }
    public void setObjetos(List<Proyecto> objetos) { this.objetos = objetos; }
}
