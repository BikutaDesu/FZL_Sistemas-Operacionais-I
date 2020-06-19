package controller;

public class ThreadController extends Thread{
	
	private int id;
	
	public ThreadController(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.printf("Thread %d ==> %d\n", getId(), id);
	}
}
