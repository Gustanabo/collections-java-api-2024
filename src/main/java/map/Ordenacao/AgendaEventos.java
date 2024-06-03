package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> agendaEventosMap;

    public AgendaEventos() {
        this.agendaEventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        Evento evento = new Evento(nome, atracao);
        agendaEventosMap.put(data, evento);
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agendaEventosMap);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;

        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agendaEventosMap);
        for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("O proximo evento: " + proximoEvento + " acontecera na data " + proximaData);
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Conferência de Tecnologia",
                "Palestrante renomado");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Workshop de Programação",
                "Aula prática de desenvolvimento");
        agendaEventos.adicionarEvento(LocalDate.of(2000, 1, 10), "Lançamento de Software",
                "Demonstração da nova versão");
        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.AUGUST, 28), "Hackathon de Inovação",
                "Competição de soluções criativas");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 9, 20), "Seminário de Inteligência Artificial",
                "Discussão sobre IA avançada");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();
    }
}
