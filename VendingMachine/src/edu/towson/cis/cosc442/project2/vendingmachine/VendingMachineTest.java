package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

	VendingMachine vm;
	VendingMachineItem vmi;
	
	@Before
	public void setUp() throws Exception {
		vm = new VendingMachine();
		vmi = new VendingMachineItem("Test Item", 1.99);
	}

	@After
	public void tearDown() throws Exception {
		vm = null;
		vmi = null;
	}

	@Test
	public void testAddItem() {
		vm.addItem(vmi, "A");
		assertTrue(vm.getItem("A").getName().equals("Test Item"));
		assertEquals(1.99,vm.getItem("A").getPrice(),0.001);
		assertTrue(vm.getItem("A") instanceof VendingMachineItem);
	}

	@Test
	public void testRemoveItem() {
		vm.addItem(vmi, "A");
		VendingMachineItem removed = vm.removeItem("A");
		assertTrue(removed.getName().equals("Test Item"));
		assertEquals(1.99,removed.getPrice(),0.001);
		assertTrue(removed instanceof VendingMachineItem);
	}

	@Test
	public void testInsertMoney() {
		vm.insertMoney(1.00);
		assertEquals(1.00,vm.balance,0.001);
		vm.balance = 0.0;
		assertEquals(0.00,vm.balance,0.001);
	}

	@Test
	public void testGetBalance() {
		vm.insertMoney(1.00);
		assertEquals(1.00,vm.getBalance(),0.001);
		vm.balance = 0.0;
		assertEquals(0.00,vm.balance,0.001);
	}

	@Test
	public void testMakePurchase() {
		vm.balance = 2.00;
		vm.addItem(vmi, "A");
		assertTrue(vm.makePurchase("A"));
		vm.balance = 0.0;
		assertEquals(0.00,vm.balance,0.001);
	}

	@Test
	public void testReturnChange() {
		vm.balance = 0.01;
		assertEquals(0.01,vm.returnChange(),0.001);
		vm.balance = 0.00;
	}

}
