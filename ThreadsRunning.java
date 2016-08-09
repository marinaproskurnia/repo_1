import mypackage.Singleton;

/* This class contains the main method.
 * After initialization the side thread starts to run;
 * In parallel the main thread also starts 
 * to call Singleton instance 10 times with halts in 0.01 sec 
 * in order to give an opportunity to the first initialized thread (side thread) to do the same;
 */

public class ThreadsRunning {
	// creating a side thread
	static ThreadsCreation sideThread;
	
	public static void main(String[] args) {
		// initialization of the side thread
		sideThread = new ThreadsCreation();
		// the sideThread starts to run
		sideThread.start();
		for(int i = 0; i < 10; i++)
		{
			try{
				// suspend the main thread for 0.01 sec;
				Thread.sleep(10);		
			} catch (InterruptedException e){
				}			
			System.out.println("MainThread runs: " + Singleton.getInstance());
		}
		// here Singleton object is called 10 times by main thread;
	}
}
