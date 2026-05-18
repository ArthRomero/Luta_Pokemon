package org.example;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static void main() {
            Scanner teclado = new Scanner(System.in);
            Random cpuNpc = new Random();

            System.out.println("===================================");
            System.out.println("   BEM-VINDO AO TORNEIO POKÉMON!   ");
            System.out.println("===================================");

            System.out.println("Escolha o seu lutador:");
            System.out.println("1 - Alakazam (Tipo Psíquico: Muita Estamina, Menos Vida)");
            System.out.println("2 - Machamp  (Tipo Lutador: Muita Vida, Menos Estamina)");
            System.out.print("Digite o número da sua escolha: ");

            Integer escolhaPersonagem = teclado.nextInt();

            Criatura jogador;
            Criatura oponente;

            if (escolhaPersonagem.equals(1)) {
                    jogador = new TipoPsiquico("Alakazam");
                    oponente = new TipoLutador("Machamp (CPU)");
            } else {
                    jogador = new TipoLutador("Machamp");
                    oponente = new TipoPsiquico("Alakazam (CPU)");
            }

            System.out.println("\n--- ENTRADA NA ARENA ---");
            jogador.exibirAura();
            oponente.exibirAura();

            int turno = 1;

            while (jogador.getPontosVida() > 0 && oponente.getPontosVida() > 0) {
                    System.out.println("\n===================================");
                    System.out.println("            TURNO " + turno);
                    System.out.println("===================================");

                    System.out.println("SUA CRIATURA: " + jogador.getEspecie() + " | HP: " + jogador.getPontosVida() + " | Estamina: " + jogador.getEstamina());
                    System.out.println("OPONENTE:     " + oponente.getEspecie() + " | HP: " + oponente.getPontosVida() + " | Estamina: " + oponente.getEstamina());

                    System.out.println("\nEscolha seu ataque:");
                    System.out.println("1 - Ataque Rápido   (Causa menos dano, não gasta estamina)");
                    System.out.println("2 - Ataque Especial (Causa muito dano, gasta estamina)");
                    System.out.print("Sua ação: ");

                    Integer escolhaAtaque = teclado.nextInt();
                    System.out.println("\n--- SEU TURNO ---");


                    if (escolhaAtaque.equals(1)) {
                            jogador.ataqueRapido(oponente);
                    } else if (escolhaAtaque.equals(2)) {
                            jogador.ataqueEspecial(oponente);
                    } else {
                            System.out.println("Escolha inválida! Você perdeu a vez de atacar por confusão.");
                    }

                    if (oponente.getPontosVida() == 0) {
                            break;
                    }

                    System.out.println("\n--- TURNO DO OPONENTE (CPU) ---");

                    Integer acaoCpu = cpuNpc.nextInt(2) + 1;

                    if (acaoCpu.equals(2)) {
                            oponente.ataqueEspecial(jogador);
                    } else {
                            oponente.ataqueRapido(jogador);
                    }

                    turno++;
            }

            System.out.println("\n===================================");
            System.out.println("           FIM DE JOGO!            ");
            System.out.println("===================================");

            if (jogador.getPontosVida() > 0) {
                    System.out.println("VITÓRIA! O " + jogador.getEspecie() + " venceu a batalha!");
            } else {
                    System.out.println("DERROTA! O " + oponente.getEspecie() + " destruiu você!");
            }

            teclado.close();

    }
}

