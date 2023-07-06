import java.util.Scanner;

public class GerenciadorTarefas {
    public static class Tarefa {
        private String nome;
        private String descricao;
        private boolean concluida;

        public Tarefa(String nome, String descricao) {
            this.nome = nome;
            this.descricao = descricao;
            this.concluida = false;
        }

        public String getNome() {
            return nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public boolean isConcluida() {
            return concluida;
        }

        public void setConcluida(boolean concluida) {
            this.concluida = concluida;
        }
    }

    public static void adicionarTarefa(List<Tarefa> tarefas) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da tarefa: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();

        Tarefa novaTarefa = new Tarefa(nome, descricao);
        tarefas.add(novaTarefa);

        System.out.println("Tarefa adicionada com sucesso!");
    }

    public static void exibirTarefas(List<Tarefa> tarefas) {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
            return;
        }

        System.out.println("Lista de Tarefas:");
        for (int i = 0; i < tarefas.size(); i++) {
            Tarefa tarefa = tarefas.get(i);
            System.out.println((i + 1) + ". " + tarefa.getNome() + " - " + tarefa.getDescricao());
            System.out.println("   Concluída: " + (tarefa.isConcluida() ? "Sim" : "Não"));
        }
    }

    public static void marcarConcluida(List<Tarefa> tarefas) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número da tarefa que deseja marcar como concluída: ");
        int numeroTarefa = scanner.nextInt();

        if (numeroTarefa < 1 || numeroTarefa > tarefas.size()) {
            System.out.println("Número de tarefa inválido!");
            return;
        }

        Tarefa tarefa = tarefas.get(numeroTarefa - 1);
        tarefa.setConcluida(true);

        System.out.println("Tarefa marcada como concluída!");
    }

    public static void main(String[] args) {
        List<Tarefa> tarefas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nEscolha uma opção:\n" +
                    "1 - Adicionar tarefa\n" +
                    "2 - Exibir tarefas\n" +
                    "3 - Marcar tarefa como concluída\n" +
                    "0 - Sair");

            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    adicionarTarefa(tarefas);
                    break;
                case 2:
                    exibirTarefas(tarefas);
                    break;
                case 3:
                    marcarConcluida(tarefas);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}