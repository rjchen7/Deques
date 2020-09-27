import org.junit.Test;
import static org.junit.Assert.*;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/*
	 * Prints a nice message based on whether a test passed. The \n means newline.
	 */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/**
	 * Adds a few things to the list, checking isEmpty() and size() are correct,
	 * finally printing the results.
	 *
	 * && is the "and" operation.
	 */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		// System.out.println("Make sure to uncomment the lines below (and delete this
		// print statement).");

		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false
		// otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);
	}

	/**
	 * Adds an item, then removes an item, and ensures that dll is empty afterwards.
	 */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		// System.out.println("Make sure to uncomment the lines below (and delete this
		// print statement).");
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		lld1.addFirst(20);
		lld1.addLast(4);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		// System.out.println(lld1.get(0));
		// System.out.println(lld1.get(1));

		passed = lld1.get(0) == 20 && lld1.get(1) == 10 && passed;

		// System.out.println(lld1.get(0));
		// System.out.println(lld1.get(1));

		passed = lld1.getRecursive(0) == 20 && lld1.getRecursive(1) == 10 && passed;

		passed = passed && lld1.removeFirst() == 20;
		passed = passed && lld1.removeLast() == 4;
		passed = passed && lld1.removeFirst() == 10;
		// should be empty
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);
	}

	@Test
	public void testDesize() {
		ArrayDeque<Integer> ad1 = new ArrayDeque<>();
		ad1.addFirst(1);
		ad1.addLast(10);
		ad1.addLast(10);
		ad1.addLast(10);
		ad1.addLast(10);
		ad1.addLast(10);
		ad1.addFirst(1);
		ad1.addLast(10);
		ad1.addLast(10);
		ad1.removeLast();
		ad1.removeLast();
		ad1.removeLast();
		ad1.removeLast();
		ad1.removeLast();
		ad1.removeLast();
		ad1.removeLast();
	}

	@Test
	public void testGetAgain() {
		ArrayDeque<Integer> ad1 = new ArrayDeque<>();
		ad1.addFirst(0);
		ad1.addFirst(1);
		int a = ad1.get(1);
		assertEquals(0, a);
		ad1.addFirst(3);
		ad1.addLast(4);
		ad1.addLast(5);
		ad1.addLast(6);
		ad1.addFirst(7);
		ad1.removeLast();
		ad1.addFirst(9);
		ad1.addFirst(10);
		ad1.get(0);
		ad1.addFirst(12);
		ad1.removeFirst();
		int x = ad1.get(7);
		assertEquals(5, x);
	}

	@Test
	public void testGet() {
		ArrayDeque<Integer> ad1 = new ArrayDeque<>();
		ad1.addLast(0);
		ad1.removeLast();
		ad1.addLast(2);
		ad1.addFirst(3);
		ad1.removeFirst();
		ad1.addLast(6);
		ad1.addFirst(7);
		ad1.get(0);
		int a = ad1.get(0);
		assertEquals(7, a);
		ad1.addLast(10);
		int b = ad1.removeFirst();
		assertEquals(7, b);
		int c = ad1.removeFirst();
		assertEquals(2, c);
		int d = ad1.get(0);
		assertEquals(d, 6);
		int e = ad1.get(1);
		assertEquals(10, e);
	}

	@Test
	public void testFillEmptyFill() {
		ArrayDeque<Integer> ad1 = new ArrayDeque<>();
		ad1.addFirst(7);
		ad1.addFirst(6);
		ad1.addFirst(7);
		ad1.addFirst(6);
		ad1.addFirst(7);
		ad1.addFirst(6);
		ad1.addFirst(7);
		ad1.addFirst(7);
		int a = ad1.removeFirst();
		int b = ad1.removeFirst();
		ad1.removeFirst();
		ad1.removeFirst();
		ad1.removeFirst();
		ad1.removeFirst();
		ad1.removeFirst();
		ad1.removeFirst();

	}

	public static void ADAddRemoveTest() {

		System.out.println("Running add/remove test for ArrayDeque.");

		// System.out.println("Make sure to uncomment the lines below (and delete this
		// print statement).");
		ArrayDeque<Integer> ad1 = new ArrayDeque<>();
		// should be empty
		// boolean passed = checkEmpty(true, lld1.isEmpty());

		ad1.addFirst(10);
		ad1.addLast(20);
		ad1.removeFirst();
		ad1.removeLast();
		ad1.removeLast();
		// ad1.addLast(4);
		// ad1.addLast(5);
		// ad1.addLast(6);
		// ad1.addLast(4);
		// ad1.addLast(5);
		// boolean passed = ad1.removeLast() == 5;
		// passed = passed && ad1.removeFirst() == 4;
		// ad1.addFirst(1);
		// ad1.addLast(10);
		// ad1.addLast(10);
		// ad1.addLast(10);
		// ad1.addLast(10);
		// ad1.addLast(10);
		// ad1.printDeque();
		// ad1.addFirst(2);
		// ad1.addFirst(3);
		// ad1.addFirst(4);
		// ad1.addLast(5);
		// ad1.addLast(7);
		// ad1.addFirst(10);

		// passed = passed && ad1.getRecursive(0) == 5 && ad1.getRecursive(1) == 6 &&
		// ad1.getRecursive(2) == 4;
		// ad1.printDeque();

		// should not be empty

		// System.out.println(lld1.get(0));
		// System.out.println(lld1.get(1));

		// System.out.println(lld1.get(0));
		// System.out.println(lld1.get(1));

		// passed = lld1.getRecursive(0) == 20 && lld1.getRecursive(1) == 10 && passed;
		//
		// passed = passed && lld1.removeFirst() == 20;
		// passed = passed && lld1.removeLast() == 4;
		// passed = passed && lld1.removeFirst() == 10;
		// // should be empty
		// passed = checkEmpty(true, lld1.isEmpty()) && passed;
		//
		// printTestStatus(passed);
	}

	public static void main(String[] args) {
		// System.out.println("Running tests.\n");
		// addIsEmptySizeTest();
		// addRemoveTest();
		ADAddRemoveTest();
	}
}