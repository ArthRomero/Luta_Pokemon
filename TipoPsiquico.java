package org.example;

public class TipoPsiquico extends Criatura {


    public TipoPsiquico(String especie) {
        super(especie, 90.0, 150);
    }

    @Override
    public void exibirAura() {
        System.out.println(getEspecie() + " está emanando uma aura roxa misteriosa...");
    }

    // Polimorfismo: Comportamento específico do ataque rápido
    @Override
    public void ataqueRapido(Criatura oponente) {
        System.out.println(getEspecie() + " usou Confusão!");
        oponente.sofrerDano(10);
    }

    // Polimorfismo: Comportamento específico do ataque especial
    @Override
    public void ataqueEspecial(Criatura oponente) {
        if (getEstamina() >= 50) {
            System.out.println(getEspecie() + " usou Raio Psíquico! Dano massivo!");
            oponente.sofrerDano(35);
            consumirEstamina(50);
        } else {
            System.out.println(getEspecie() + " está sem energia para o ataque especial!");
        }
    }
}