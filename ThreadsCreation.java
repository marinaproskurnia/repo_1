import mypackage.Singleton;

/* This class initiates a new thread;
 * The method 'run' (overrided from Thread class) invokes the thread 
 * to get Singleton instance 10 times with halts in 0.01 sec;
 * Time suspending is needed to give an opportunity to other thread to do the same; 
 */

public class ThreadsCreation extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			try {
				// suspend the side thread for 0.01 sec;
				sleep(10);
			} catch (InterruptedException e) {
				}
			System.out.println("SideThread runs: " + Singleton.getInstance());
		}
	}
}
