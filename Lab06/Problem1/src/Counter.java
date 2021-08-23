import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;

public class Counter {
	private static int lines;
	private static int blankLines;
	private static int comments;

	public static void main(String[] args) {

		// Count number of lines
		try (FileReader input = new FileReader("C:\\Users\\Brandon Chu\\Desktop\\lab6_input.txt");
				LineNumberReader count = new LineNumberReader(input)) {

			// Skip line
			while (count.skip(Long.MAX_VALUE) > 0) {
			}

			// Count add one because it starts at 0
			int result = count.getLineNumber() + 1;

			lines = result;

		} catch (Exception ex) {
			System.out.println(ex);
		}

		// Count comments and blank lines
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Brandon Chu\\Desktop\\lab6_input.txt"));

			String s;
			for (int i = 0; i < lines; i++) {

				s = br.readLine().trim();

				if (s.isEmpty()) {
					blankLines += 1;
				} else {

					char value = s.charAt(0);
					if (value == '/') {
						comments += 1;
					}
				}

			}

			br.close();

		} catch (Exception ex) {
			System.out.println(ex);
		}

		// Write into output file
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Brandon Chu\\Desktop\\lab6_output.txt"));

			bw.write("Lines " + lines);
			bw.write("\nBlank Lines " + blankLines);
			bw.write("\nComments " + comments);

			bw.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
