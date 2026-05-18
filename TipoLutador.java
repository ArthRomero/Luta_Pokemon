package org.example;

public class TipoLutador extends Criatura {

    public TipoLutador(String especie) {
        super(especie, 120.0, 80);
    }


    @Override
    public void exibirAura() {
        System.out.println(getEspecie() + " está flexionando os músculos com uma aura vermelha!");
    }

    @Override
    public void ataqueRapido(Criatura oponente) {
        System.out.println(getEspecie() + " usou Soco Rápido!");
        oponente.sofrerDano(15);
    }

    @Override
    public void ataqueEspecial(Criatura oponente) {
        if (getEstamina() >= 40) {
            System.out.println(getEspecie() + " usou Soco Dinâmico! Um golpe devastador!");
            oponente.sofrerDano(35);
            consumirEstamina(40);
        } else {
            System.out.println(getEspecie() + " está muito cansado para um soco forte!");
        }
    }
}
