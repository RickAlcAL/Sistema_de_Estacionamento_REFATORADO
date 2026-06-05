package Entities.Estacionamento;

import Entities.Enum.StatusVaga;
import Entities.Enum.TipoVeiculo;
import Entities.Veiculo.Veiculo;
import java.util.ArrayList;

public class Estacionamento {
    private StatusVaga[] vagas = {
            StatusVaga.DISPONIVEL,
            StatusVaga.DISPONIVEL,
            StatusVaga.DISPONIVEL,
            StatusVaga.DISPONIVEL,
            StatusVaga.MANUTENCAO // Exemplo de vaga que inicia em manutenção (3º estado)
    };
    private ArrayList<Veiculo> veiculosEstacionados = new ArrayList<>();
    private ArrayList<Integer> vagaOcupada = new ArrayList<>();

    // Getters e Setters
    public StatusVaga[] getVagas() {
        return vagas;
    }

    public void setVagas(StatusVaga[] vagas) {
        this.vagas = vagas;
    }

    public ArrayList<Veiculo> getVeiculosEstacionados() {
        return veiculosEstacionados;
    }

    public void setVeiculosEstacionados(ArrayList<Veiculo> veiculosEstacionados) {
        this.veiculosEstacionados = veiculosEstacionados;
    }

    public ArrayList<Integer> getVagaOcupada() {
        return vagaOcupada;
    }

    public void setVagaOcupada(ArrayList<Integer> vagaOcupada) {
        this.vagaOcupada = vagaOcupada;
    }

    // Método que exibe as vagas livres
    public String exibirVagas() {
        StringBuilder vagasDisponiveis = new StringBuilder("Vagas disponíveis:");
        for (int i = 0; i < vagas.length; i++) {
            if (vagas[i] == StatusVaga.DISPONIVEL) {
                vagasDisponiveis.append("\nVaga ").append(i);
            }
        }
        return vagasDisponiveis.toString();
    }

    // Verifica se a vaga está livre para uso
    public boolean verificarVaga(int vaga) {
        return vagas[vaga] == StatusVaga.DISPONIVEL;
    }

    // Registra a ocupação da vaga
    public void ocuparVaga(int vaga, Veiculo veiculo) {
        vagas[vaga] = StatusVaga.OCUPADA;
        veiculosEstacionados.add(veiculo);
        vagaOcupada.add(vaga);
    }

    // Libera a vaga voltando para DISPONIVEL
    public void desocuparVaga(int vaga) {
        vagas[vaga] = StatusVaga.DISPONIVEL;
    }

    // Verifica se o veículo já existe no sistema
    public boolean verificarVeiculo(String placaInput, TipoVeiculo tipoInput) {
        for (Veiculo v : veiculosEstacionados) {
            if (v.getPlaca().equalsIgnoreCase(placaInput) && v.getTipo() == tipoInput) {
                return true;
            }
        }
        return false;
    }

    // Retira o veículo
    public void retirarVeiculo(String placaInput, TipoVeiculo tipoInput) {
        for (int i = 0; i < veiculosEstacionados.size(); i++) {
            Veiculo v = veiculosEstacionados.get(i);

            if (v.getPlaca().equalsIgnoreCase(placaInput) && v.getTipo() == tipoInput) {
                int vagaLiberada = vagaOcupada.get(i);
                desocuparVaga(vagaLiberada);
                veiculosEstacionados.remove(i);
                vagaOcupada.remove(i);
                break;
            }
        }
    }
}