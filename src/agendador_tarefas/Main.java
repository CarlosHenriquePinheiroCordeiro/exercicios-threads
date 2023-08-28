package agendador_tarefas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int comando            = 0;
		TimeUnit tipoTempo[]   = {TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES};
		List<Tarefa> lsTarefas = new ArrayList<Tarefa>();
		do {
			System.out.println("Informe a ação desejada: 1 - Agendar tarefas | 2 - Consultar tarefas | 0 - Encerrar programa");
			comando = sc.nextInt();
			if (comando == 2) {
				System.out.println("\n----------------------------------------------------------------------------");
				for (Tarefa tarefa : lsTarefas) {
					System.out.println(tarefa);
				}
				System.out.println("----------------------------------------------------------------------------");
			}
			if (comando == 1) {
				System.out.println("Informe quantas tarefas deseja agendar");
				int tarefas = sc.nextInt();
				for (int i = 0; i < tarefas; i++) {
					Tarefa t = new Tarefa(i+1);
					System.out.println("\n----------------------------------------------------------------------------");
					System.out.println("Tarefa "+(i+1));
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("Informe a unidade de tempo: 1 - Milisegundos | 2 - Segundos | 3 - Minutos");
					t.setTipoTempo(tipoTempo[sc.nextInt()-1]);
					System.out.println("Informe a quantidade:");
					t.setTempo(sc.nextInt());
					lsTarefas.add(t);
				}
				ScheduledExecutorService ses = Executors.newScheduledThreadPool(tarefas);
				for (Tarefa tarefa : lsTarefas) {
					if (!tarefa.isAgendada()) {
						tarefa.setAgendada(true);
						ses.schedule(tarefa, tarefa.getTempo(), tarefa.getTipoTempo());
					}
				}
				System.out.println("Tarefas agendadas com sucesso!");
			}
		} while (comando != 0);
	}

}
