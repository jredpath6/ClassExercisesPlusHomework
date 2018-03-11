/**
 * LightTest.java 1.0 Mar 6, 2018
 *
 * Copyright (c) 2018 Jack Redpath. All Rights Reserved
 * Campuse Box 8499, Elon University, Elon, NC 27244
 */
package headfirst.command.simpleremote;

import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import headfirst.command.undo.Light;

/**
 * Start each class or interface with a summary description line
 *
 * @author jredpath
 * @version 1.0
 *
 */
class LightTest {

	Light light = new Light("kitchenLight");

	/**
	 * Test method for {@link headfirst.command.undo.Light#off()}.
	 */
	@Test
	void testOff() {
		ByteOutputStream stream = new ByteOutputStream();
		PrintStream a = new PrintStream(stream);
		System.setOut(a);
		light.off();
		String expected = "Light is off";
		String actual = stream.toString().trim();
		Assertions.assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link headfirst.command.undo.Light#on()}.
	 */
	@Test
	void testOn() {
		ByteOutputStream stream = new ByteOutputStream();
		PrintStream b = new PrintStream(stream);
		System.setOut(b);
		light.on();
		String expected = "Light is on";
		String actual = stream.toString().trim();
		Assertions.assertEquals(expected, actual);
	}
}
