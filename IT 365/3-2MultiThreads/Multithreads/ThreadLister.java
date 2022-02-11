/**
 * List all thread groups and threads in each group in the JVM.
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Eighth Edition
 * Copyright John Wiley & Sons - 2010.
 */

public class ThreadLister
{
	ThreadGroup rootThreadGroup = null;
 
	/* Getting root thread group */
	ThreadGroup getRootThreadGroup( ) {
    		if ( rootThreadGroup != null )
        		return rootThreadGroup;
    		ThreadGroup currentThreadGroup = Thread.currentThread( ).getThreadGroup( );
    		ThreadGroup parentThreadGroup;
    		while ( (parentThreadGroup = currentThreadGroup.getParent( )) != null )
        		currentThreadGroup = parentThreadGroup;

		rootThreadGroup = currentThreadGroup;

    		return rootThreadGroup;
	}

	/* Gets a list of all thread groups */
	ThreadGroup[] getAllThreadGroups( ) {
    		final ThreadGroup root = getRootThreadGroup( );

		/* returns a number of active group in this thread group */
   		int alloc = root.activeGroupCount( );

		/* Comment Here */
    		int n = 0;
    		ThreadGroup[] groups;
    		do {
			/* Creat a new group having double the active groups */
        		alloc *= 2;
        		groups = new ThreadGroup[alloc];

			/*Copies into the specified array root, references to every active subgroups groups threadgroup true*/
        		n = root.enumerate(groups, true);
    		} while (n == alloc);

		   /* reate new threadgroups array, created it to be one larger, to store root reference as well */ 
    		ThreadGroup[] allGroups = new ThreadGroup[n+1];

		   /* Store root at index 0 */
    		allGroups[0] = root;

		   /* Copy the other groups from group variabe to allGroups starting from index 1 for count of n groups */
    		System.arraycopy( groups, 0, allGroups, 1, n );

    		return allGroups;
	}

	public static void main(String[] args) {
		
		new CreateThreadGroups();
		
		ThreadLister groups = new ThreadLister();

		/* Getting a thread group by name*/
		ThreadGroup[] groupList = groups.getAllThreadGroups();

		/* Iterate over all the groups */
		for (int i = 0; i < groupList.length; i++) {
			/* Creates a thread array  */
			Thread list[] = new Thread[groupList[i].activeCount() * 2];
			groupList[i].enumerate(list, false);
		
			/* print group name */
			System.out.println(groupList[i].getName());
			for (int j = 0; j < list.length; j++) {
				if (list[j] != null)
					System.out.println("\t"+list[j].getName()+":"+list[j].getId()+":"+list[j].getState()+":"+list[j].isDaemon());
			}
		}
	}
}
