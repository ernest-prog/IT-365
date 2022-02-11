/**
 * A program that tests your implementation that
 * lists all thread groups 
 * - and threads within each group -
 * in the JVM.
 */


public class CreateThreadGroups
{
	public CreateThreadGroups() {
		/* Creating three ThreadGroups “alpha”,”beta”,”theta” to group threads.*/
                ThreadGroup beta = new ThreadGroup("beta");
		ThreadGroup theta = new ThreadGroup(alpha, "theta");

		/* Creating threads in each threadgroup. First argument of thread class constructor is the threadgroup name. */
                /* Second argument is the Runnable implemented class. Hence, creating anonymous threads and starting it */	
		(new Thread(alpha, new GroupWorker())).start();
		(new Thread(alpha, new GroupWorker())).start();
		(new Thread(alpha, new GroupWorker())).start();
		(new Thread(beta, new GroupWorker())).start();
		(new Thread(theta, new GroupWorker())).start();
		(new Thread(theta, new GroupWorker())).start();
	}

	class GroupWorker implements Runnable
	{
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
					for (int i = 0; i < 1000000; i++)
						;
				}
				catch (InterruptedException ie) { }
			}
		}
	}
}
