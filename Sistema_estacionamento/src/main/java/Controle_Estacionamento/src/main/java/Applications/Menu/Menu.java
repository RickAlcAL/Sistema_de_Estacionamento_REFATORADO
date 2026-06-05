package Applications.Menu;

import Entities.Enum.TipoVeiculo;
import Entities.Estacionamento.Estacionamento;
import Entities.Veiculo.Veiculo;

import java.util.Scanner;

public class Menu {

    public void menuPrincipal() {
        //Menu principal
        Estacionamento estacionamento = new Estacionamento();
        Scanner sc = new Scanner(System.in);
        char opcao;

        do {
            System.out.println(
                    "============================\n" +
                            "Selecione a opção que deseja:\n" +
                            "1- Estacionar veículo\n" +
                            "2- Retirar veículo\n" +
                            "3- Sair\n"+
                            "============================"
            );
            opcao = sc.next().charAt(0);
            sc.nextLine();

            if(opcao == '1'){
                menuEstacionar();
            }
            else if (opcao == '2') {
                menuRetirar();
            }
            else if (opcao == '3') {
                System.out.println("Fechando o sistema...");
            }
            else {
                System.out.println("Digite uma opção válida!");
            }

        } while (opcao != '3');
    }

    private void menuEstacionar() {
        Estacionamento estacionamento = new Estacionamento();
        Scanner sc = new Scanner(System.in);
        System.out.println("Placa: ");
        String placa = sc.nextLine();

        TipoVeiculo tipo = escolherTipoVeiculo();

        if (estacionamento.verificarVeiculo(placa, tipo)) {
            System.out.println("O veículo já está estacionado!");
            return;
        }

        System.out.println(estacionamento.exibirVagas());

        boolean exito = false;
        do {
            System.out.println("Digite o número da vaga que quer ocupar: ");
            int vaga = sc.nextInt();
            sc.nextLine(); // Limpar buffer
            //Verificando se o usuario digitou algo abaixo ou pelo o tamanho - 1
            if (vaga < 0 || vaga > estacionamento.getVagas().length - 1) {
                System.out.println("Digite uma vaga válida");
            }
            else {
                if (!estacionamento.verificarVaga(vaga)) {
                    System.out.println("Vaga indisponível ou ocupada, escolha outra vaga.");
                }
                else {
                    Veiculo novoVeiculo = new Veiculo(placa, tipo);
                    estacionamento.ocuparVaga(vaga, novoVeiculo);

                    System.out.println("O veículo está estacionado na vaga: " + vaga);
                    exito = true;
                }
            }
        } while (!exito);
    }

    private void menuRetirar() {
        Estacionamento estacionamento = new Estacionamento();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite os dados do veículo a ser retirado: ");
        System.out.println("Placa: ");
        String placa = sc.nextLine();

        TipoVeiculo tipo = escolherTipoVeiculo();

        if(!estacionamento.verificarVeiculo(placa, tipo)) {
            System.out.println("Veículo não encontrado!");
        }
        else {
            estacionamento.retirarVeiculo(placa, tipo);
            System.out.println("Veículo retirado com sucesso!");
        }
    }

    // Método auxiliar para tratar a entrada do Enum com as 3 opções
    private TipoVeiculo escolherTipoVeiculo() {
        Scanner sc = new Scanner(System.in);
        String entrada;
        do {
            System.out.println("Tipo (carro / moto / caminhao): ");
            entrada = sc.nextLine().trim().toUpperCase();
        } while (!entrada.equals("CARRO") && !entrada.equals("MOTO") && !entrada.equals("CAMINHAO"));

        return TipoVeiculo.valueOf(entrada);
    }
}