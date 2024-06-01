package main.java.set.Pesquisa;

public class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    @Override
    public String toString() {
        return "[" + descricao + ", " + concluida + "]";
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

}
