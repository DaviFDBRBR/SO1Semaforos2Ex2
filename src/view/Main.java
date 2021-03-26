package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Main {
	
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		
		for (int id = 0; id < 4; id++) {
			ThreadCarro tc = new ThreadCarro(id, semaforo);
			tc.start();
		}
		
	}
	
}
