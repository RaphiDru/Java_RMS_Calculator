import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class RMS_Calculator {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
			String line;
			float square = 0;
			float mean = 0;
			float root = 0;
			float counter = 0;
			List<Integer> list_Of_Int = new ArrayList<>();
			StringBuilder sb = new StringBuilder();

			while ((line = br.readLine()) != null) {
				boolean found = false;

				// Check each char to see if it is an integer.
				for (char c : line.toCharArray()) {

					if (Character.isDigit(c)) {
						sb.append(c);
						found = true;
					}

					// Only go onto next line when finished reading in integer.
					if (found & Character.isDigit(c) == false) {
						sb.append(",");
						break;

					}
				}
			}

			// Check extracted values are correct.
			// System.out.println("Full array is : " + sb);

			// Split the strings based on where the comma is placed.
			String[] numbers = sb.toString().split(",");

			// Convert strings to integers.
			for (String number : numbers) {
				list_Of_Int.add(Integer.valueOf(number));
			}

			// System.out.println("List is: " + list_Of_Int);

			for (int i = 0; i < list_Of_Int.size(); i++) {

				// Only use integers, do not use commas.
				if ((list_Of_Int.get(i)) != ',') {
					counter++;

					// System.out.println("Number is : " + list_Of_Int.get(i));

					// Get the integer value of the number.
					float a = (list_Of_Int.get(i));

					// Calculate Square.
					square += (a * a);

					// Check what the squared value is
					// System.out.println("Square is: " + square);

				}
			}

			// Calculate Mean.
			mean = (square / (float) (counter));

			// Calculate Root.
			root = (float) Math.sqrt(mean);

			// Check the RMS value
			// System.out.println(root);

			// Write to an Output file.
			try (Writer writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("output.txt"), "utf-8"))) {
				writer.write(String.valueOf(root));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
