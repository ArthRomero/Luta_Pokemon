package org.example;

public abstract class Criatura implements AcaoCombate {

    // Encapsulamento: Atributos privados
    private String especie;
    private Double pontosVida;
    private Integer estamina;

    public Criatura(String especie, double pontosVida, int estamina) {
        this.especie = especie;
        this.pontosVida = pontosVida;
        this.estamina = estamina;
    }

    // Getters
    public String getEspecie() {
        return especie;
    }

    public double getPontosVida() {
        return pontosVida;
    }

    public int getEstamina() {
        return estamina;
    }

    // Setters com lógica para proteger os dados (Encapsulamento)
    public void sofrerDano(double dano) {
        this.pontosVida -= dano;
        if (this.pontosVida < 0) {
            this.pontosVida = 0.0;
        }
    }

    public void consumirEstamina(int custo) {
        this.estamina -= custo;
        if (this.estamina < 0) {
            this.estamina = 0;
        }
    }

    public abstract void exibirAura();
}