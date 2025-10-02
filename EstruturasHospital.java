class Paciente {
    String nome;
    int idade;
    PilhaHistorico historico = new PilhaHistorico(10);

    Paciente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    void addHist(String info) { historico.push(info); }
    void verHist() { historico.print(); }
}

class PilhaHistorico {
    String[] dados = new String[10];
    int topo = -1;

    void push(String info) {
        if (topo < dados.length - 1) dados[++topo] = info;
    }
    void print() {
        System.out.println("Histórico:");
        for (int i = topo; i >= 0; i--) System.out.println("- " + dados[i]);
    }
}

class FilaAtendimento {
    Paciente[] fila = new Paciente[5];
    int ini = 0, fim = 0, tam = 0;

    boolean enfileirar(Paciente p) {
        if (tam < fila.length) {
            fila[fim] = p;
            fim = (fim + 1) % fila.length;
            tam++;
            return true;
        }
        return false;
    }
    void mostrar() {
        System.out.println("Fila:");
        for (int i = 0, idx = ini; i < tam; i++, idx = (idx + 1) % fila.length)
            System.out.println("- " + fila[idx].nome);
    }
}

class ListaPacientes {
    Paciente[] lista = new Paciente[5];
    int qtd = 0;

    boolean add(Paciente p) {
        if (qtd < lista.length) {
            lista[qtd++] = p;
            return true;
        }
        return false;
    }
    void mostrar() {
        System.out.println("Pacientes:");
        for (int i = 0; i < qtd; i++) System.out.println("- " + lista[i].nome);
    }
}

public class Main {
    public static void main(String[] args) {
        ListaPacientes pacientes = new ListaPacientes();
        FilaAtendimento fila = new FilaAtendimento();

        Paciente p1 = new Paciente("Carlos", 30);
        Paciente p2 = new Paciente("Ana", 10);

        pacientes.add(p1); pacientes.add(p2);
        fila.enfileirar(p1); fila.enfileirar(p2);

        p1.addHist("Consulta em 02/10/2025");
        p1.addHist("Exame em 03/10/2025");

        pacientes.mostrar();
        fila.mostrar();
        p1.verHist();
    }
}