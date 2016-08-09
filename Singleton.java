package mypackage;

/*
 * Write thread safe optimal Singleton implementation in Java. 
 * Write simple program that will use Singleton in a way that make sense.
 */
// implementation of Double Checked Locking & volatile method

public class Singleton {
	/* value of the volatile variable 'instance' could be changed 
	* with different threads at the same time and kept as 'localInstance', 
	* but whenever some thread calls its value, the thread reads the current value 
	* of the main copy 'instance' in the main memory;
	*/
	private static volatile Singleton instance;
	
	    public static Singleton getInstance() {
		Singleton localInstance = instance;
		if (localInstance == null) {
			synchronized (Singleton.class) {
				localInstance = instance;
				if (localInstance == null) {
					instance = localInstance = new Singleton();
				}
			}
		}
		return localInstance;
	}	
}