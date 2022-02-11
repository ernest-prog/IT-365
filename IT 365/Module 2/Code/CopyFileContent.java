import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFileContent {

	public static void main(String[] args) {

		/*Selects source file to copy */
		File sourceFile = new File("file1.txt");

		/* Names copied file as file2 */
		File destFile = new File("file2.txt");
		
		/* If statement to perform if File exists */
		if (!destFile.exists()) {
			try {
				destFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		InputStream input = null;
		OutputStream output = null;

		try {

			/* Input statement to add file to source */
			input = new FileInputStream(sourceFile);

			/* Output statement to display file in destination */
			output = new FileOutputStream(destFile);

			byte[] buf = new byte[1024];
			int bytesRead;

			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {

				if (null != input) {
					input.close();
				}
				
				if (null != output) {
					output.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}