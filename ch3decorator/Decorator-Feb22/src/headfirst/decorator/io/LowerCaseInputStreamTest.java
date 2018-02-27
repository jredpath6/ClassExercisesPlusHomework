package headfirst.decorator.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class LowerCaseInputStreamTest {

	@Test
	void testRead() {
		ByteArrayOutputStream array = new ByteArrayOutputStream();
		try {
			InputStream in = new LowerCaseInputStream(
					new BufferedInputStream(new FileInputStream("elon462.txt")));
			int a;
			while ((a = in.read()) > 0) {
				array.write((char) a);
			}
			String actual = array.toString();
			String expected = "february 22 is the eighth class on design patterns. we are \r\n"
					+ "25% done with the course.\r\n" + "\r\n"
					+ "we have covered three design patterns: strategy, observer\r\n"
					+ "and decorator. homework 2 will demonstrate our hands on \r\n"
					+ "understanding of strategy and observer.\r\n" + "\r\n"
					+ "optional homework 3 will demonstrate our hands of understanding of\r\n"
					+ "decorator and java i/o." + "\r\n";
			assertEquals(expected, actual);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testReadByteArrayIntInt() {
		ByteArrayOutputStream outArray = new ByteArrayOutputStream();
		String expected = "february 22 is the eighth class on design patterns. we are \r\n"
				+ "25% done with the course.\r\n" + "\r\n"
				+ "we have covered three design patterns: strategy, observer\r\n"
				+ "and decorator. homework 2 will demonstrate our hands on \r\n"
				+ "understanding of strategy and observer.\r\n" + "\r\n"
				+ "optional homework 3 will demonstrate our hands of understanding of\r\n"
				+ "decorator and java i/o." + "\r\n";
		String expected1 = "FEBRUARY 22 is the eighth class on design patterns. we are \r\n"
				+ "25% done with the course.\r\n" + "\r\n"
				+ "we have covered three design patterns: strategy, observer\r\n"
				+ "and decorator. homework 2 will demonstrate our hands on \r\n"
				+ "understanding of strategy and observer.\r\n" + "\r\n"
				+ "optional homework 3 will demonstrate our hands of understanding of\r\n"
				+ "decorator and java i/o." + "\r\n";
		byte[] byteArray = new byte[2];
		try {
			// FileInputStream file = new FileInputStream("elon462.txt");
			// InputStream in = new LowerCaseInputStream(new BufferedInputStream(file));
			InputStream in = new LowerCaseInputStream(
					new ByteArrayInputStream(expected1.getBytes()));
			int a;
			while ((a = in.read(byteArray, 0, 2)) != -1) {
				if (a == 2) {
					outArray.write(byteArray);
				} else {
					outArray.write(byteArray[0]);
				}
			}
			String actual = outArray.toString();

			assertEquals(expected, actual);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
