package com.portfolio.model;

import javax.persistence.*;

@Entity
@Table(name = "proyectos")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int peso;
    private int ganancia;

    public Proyecto() {}
    public Proyecto(Long id, String nombre, int peso, int ganancia) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.ganancia = ganancia;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getPeso() { return peso; }
    public void setPeso(int peso) { this.peso = peso; }
    public int getGanancia() { return ganancia; }
    public void setGanancia(int ganancia) { this.ganancia = ganancia; }
}
