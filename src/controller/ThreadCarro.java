package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {
	private int id;
	private String sentido;
	private Semaphore semaforo;

	public ThreadCarro(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		definirSentido();

		try {
			semaforo.acquire();
			atravessar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void definirSentido() {
		switch (id) {
		case 0:
			this.sentido = "norte para o sul";
			break;
		case 1:
			this.sentido = "sul para o norte";
			break;
		case 2:
			this.sentido = "oeste para o leste";
			break;
		case 3:
			this.sentido = "leste para o oeste";
			break;
		}

	}

	private void atravessar() {
		
		System.out.println("Carro #" + id + " fez a travessia do " + sentido);
	}

}
