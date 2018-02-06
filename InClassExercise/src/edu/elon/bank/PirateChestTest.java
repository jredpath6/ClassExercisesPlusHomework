package edu.elon.bank;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// This is a new comment to test Git.
class PirateChestTest {
	private PirateChest chest;
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Setting up chest");
		chest = new PirateChest(10);
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Cleaning up chest");
		chest = null;
	}

	@Test
	void testAddGold() {
		//PirateChest chest = new PirateChest(10);
		chest.addGold(20);
		int actual = chest.checkGold();
		int expected = 30;
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testCheckGold() {
		//PirateChest chest = new PirateChest(10);
		int actual = chest.checkGold();
		int expected = 10;
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testEqualsObject() {
		//PirateChest chest = new PirateChest(10);
		PirateChest chest1 = new PirateChest(11);
		PirateChest chest2 = new PirateChest(10);
		
		Assertions.assertTrue(chest.equals(chest2));
		Assertions.assertFalse(chest.equals(chest1));
	}

	@Test
	void testRemoveGold() {
		//PirateChest chest = new PirateChest(10);
		chest.removeGold(3);
		int actual = chest.checkGold();
		int expected = 7;
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testToString() {
		//PirateChest chest = new PirateChest(10);
		String actual = chest.toString();
		String expected = "Chest has 10 pieces of gold";
		Assertions.assertEquals(expected, actual);
	}

}
