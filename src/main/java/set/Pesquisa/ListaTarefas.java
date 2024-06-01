package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> listaTarefas;

    public ListaTarefas() {
        this.listaTarefas = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        listaTarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = null;
        if (!listaTarefas.isEmpty()) {
            for (Tarefa t : listaTarefas) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaRemover = t;
                    break;
                }
            }
            listaTarefas.remove(tarefaParaRemover);
        } else {
            System.out.println("O conjunto está vazio");
        }

        if (tarefaParaRemover == null) {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public void exibirTarefas() {
        System.out.println(listaTarefas);
    }

    public void contarTarefas() {
        System.out.println("Ha " + listaTarefas.size() + " tarefas.");
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for (Tarefa t : listaTarefas) {
            if (t.isConcluida()) {
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for (Tarefa t : listaTarefas) {
            if (!t.isConcluida()) {
                tarefasPendentes.add(t);
            }
        }
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao) {
        for (Tarefa t : listaTarefas) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setConcluida(true);
            }
        }
    }

    public void marcarTarefaPendente(String descricao) {
        for (Tarefa t : listaTarefas) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setConcluida(false);
            }
        }
    }

    public void limparListaTarefas() {
        listaTarefas.clear();
    }

    public static void main(String[] args) {
        ListaTarefas tarefas = new ListaTarefas();

        tarefas.exibirTarefas();
        tarefas.adicionarTarefa("Tarefa 1");
        tarefas.adicionarTarefa("Tarefa 2");
        tarefas.adicionarTarefa("Tarefa 3");
        tarefas.adicionarTarefa("Tarefa 4");

        tarefas.exibirTarefas();

        tarefas.removerTarefa("Tarefa 2");

        System.out.println(tarefas.obterTarefasConcluidas());
        System.out.println(tarefas.obterTarefasPendentes());

        tarefas.marcarTarefaConcluida("Tarefa 1");

        System.out.println(tarefas.obterTarefasConcluidas());

        tarefas.exibirTarefas();
        tarefas.contarTarefas();
        tarefas.marcarTarefaPendente("Tarefa 1");
        System.out.println(tarefas.obterTarefasConcluidas());
        tarefas.limparListaTarefas();
        tarefas.contarTarefas();
    }
}
