package headfirst.decorator.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.*;

class LowerCaseInputStreamTest {

	@Test
	void testRead() {
		ByteArrayOutputStream array = new ByteArrayOutputStream();
		try {
			InputStream in =
			          new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("elon462.txt")));
			int a = in.read();
			while ((a = in.read()) > 0) {
				array.write((char) a);				
			}
			String actual = array.toString();
			String expected = "ebruary 22 is the eighth class on design patterns. we are \r\n" + 
					"25% done with the course.\r\n" + 
					"\r\n" + 
					"we have covered three design patterns: strategy, observer\r\n" + 
					"and decorator. homework 2 will demonstrate our hands on \r\n" + 
					"understanding of strategy and observer.\r\n" + 
					"\r\n" + 
					"optional homework 3 will demonstrate our hands of understanding of\r\n" + 
					"decorator and java i/o."+"\r\n";
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
			ByteArrayOutputStream array = new ByteArrayOutputStream();
			try {
				LowerCaseInputStream in =
				          new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("elon462.txt")));
				int a = in.read(array.toByteArray(), 3, array.size());
				while (a > 0) {
					array.write((char) a);				
				}
				String actual = array.toString();
				String expected = "ebruary 22 is the eighth class on design patterns. we are \r\n" + 
						"25% done with the course.\r\n" + 
						"\r\n" + 
						"we have covered three design patterns: strategy, observer\r\n" + 
						"and decorator. homework 2 will demonstrate our hands on \r\n" + 
						"understanding of strategy and observer.\r\n" + 
						"\r\n" + 
						"optional homework 3 will demonstrate our hands of understanding of\r\n" + 
						"decorator and java i/o."+"\r\n";
				assertEquals(expected, actual);
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
