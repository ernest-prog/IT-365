/**
 * Frame.java
 *
 * A class which represents a physical page frame.
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Eighth Edition
 * Copyright John Wiley & Sons - 2010. 
 */

public class Frame 
{
	public static final int FRAME_SIZE = 256;
	private byte[] frameValue;

	public Frame() {
		frameValue = new byte[FRAME_SIZE];
	}

	public void setFrame(byte[] bytes) {
		/* bytes array copied into framValue and size of array is set to equal. */
		System.arraycopy(bytes, 0, frameValue, 0, FRAME_SIZE);
	}

	public byte readWord(int offset) {
		return frameValue[offset];
	}
}

