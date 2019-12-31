package refrigeratorOperation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RefrigeratorTest {
	/**
	 * In the test case given below small shelve has one item of size 50 and large
	 * slave has one item of size 80 and the medium slave has 3 item of size 20 ,20
	 * and 15 when we add the 6Th element we shift one element of size 20 from
	 * medium to large and add item in medium slave
	 */
	@Test
	void test() {
		Refrigerator refrigerator = new Refrigerator();
		refrigerator.addItemInRefrigerator(new Item(1, 50, "apple1"));// s
		refrigerator.addItemInRefrigerator(new Item(1, 20, "apple2"));// m
		refrigerator.addItemInRefrigerator(new Item(1, 20, "apple3"));// m
		refrigerator.addItemInRefrigerator(new Item(1, 15, "apple4"));// m
		refrigerator.addItemInRefrigerator(new Item(1, 80, "apple5"));// l
		// System.out.println(refrigerator.AddObjectInRefrigerator(new Item(1, 25,
		// "apple6")));//check space in medium and transfer it from medium to large and

		String result = refrigerator.addItemInRefrigerator((new Item(1, 25, "apple6")));
		assertEquals("apple6  is added in medium Shelve", result);

	}

	/**
	 * In the test case given below the large shelve has full and the medium shelve
	 * consume 60 size spase out of 70 and the small shelve has 3 object of size
	 * 10,15 and 15 when we add 7th item then one object of size 10 is shifted to
	 * medium Shelve and item is added into small
	 */
	@Test
	void test1() {
		Refrigerator refrigerator = new Refrigerator();
		refrigerator.addItemInRefrigerator(new Item(1, 10, "apple1"));// s
		refrigerator.addItemInRefrigerator(new Item(1, 15, "apple2"));// s
		refrigerator.addItemInRefrigerator(new Item(1, 15, "apple3"));// s
		refrigerator.addItemInRefrigerator(new Item(1, 60, "apple4"));// m
		refrigerator.addItemInRefrigerator(new Item(1, 50, "apple5"));// l
		refrigerator.addItemInRefrigerator(new Item(1, 50, "apple6"));// l
		String result = refrigerator.addItemInRefrigerator(new Item(1, 15, "apple7"));// check s
		assertEquals("apple7  is added in small Shelve", result);

	}

	/**
	 * In this test case we small shelve has one item of size 30 and medium and
	 * large slaves has one item of size 40 and 50 when we try to insert 4th item of
	 * size 70 then we shift item of size 40 from medium to large and insert new
	 * item in large
	 */
	@Test
	void test2() {
		Refrigerator refrigerator = new Refrigerator();
		refrigerator.addItemInRefrigerator(new Item(1, 30, "apple1"));// s
		refrigerator.addItemInRefrigerator(new Item(1, 40, "apple2"));// m
		refrigerator.addItemInRefrigerator(new Item(1, 50, "apple3"));// l
		String result = refrigerator.addItemInRefrigerator(new Item(1, 70, "apple4"));// 40 are transfered from medium
																						// to large and 70 added in
																						// medium
		assertEquals("apple4  is added in medium Shelve", result);

	}

	/**
	 * In the given test case we check if space is not available then it shows No
	 * space available
	 */
	@Test
	void test3() {
		Refrigerator refrigerator = new Refrigerator();
		refrigerator.addItemInRefrigerator(new Item(1, 30, "apple1"));// s
		refrigerator.addItemInRefrigerator(new Item(1, 40, "apple2"));// m
		refrigerator.addItemInRefrigerator(new Item(1, 50, "apple3"));// l
		refrigerator.addItemInRefrigerator(new Item(1, 70, "apple4"));// 40 are transfered from medium to large and 70
																		// added in medium
		refrigerator.addItemInRefrigerator(new Item(1, 5, "apple5"));// s
		refrigerator.addItemInRefrigerator(new Item(1, 5, "apple6"));// s
		String result = refrigerator.addItemInRefrigerator(new Item(1, 15, "apple7"));// no space
		assertEquals("No space avaibale", result);

	}

	/**
	 * In the given tase case we have 1 item of size 30 in small shelve and one item
	 * of size 40 in medium and 2 item of size when we add next item of size 50 the
	 * we shift all element of small shelve to medium and insert element into small
	 * shelve
	 */
	@Test
	void test4() {
		Refrigerator refrigerator = new Refrigerator();
		refrigerator.addItemInRefrigerator(new Item(1, 30, "apple1"));// s
		refrigerator.addItemInRefrigerator(new Item(1, 40, "apple2"));// m
		refrigerator.addItemInRefrigerator(new Item(1, 50, "apple3"));// l
		refrigerator.addItemInRefrigerator(new Item(1, 50, "apple4"));// l
		String result = refrigerator.addItemInRefrigerator(new Item(1, 50, "apple5"));// small tranfer to medium and 50
																						// is added into small slave
		assertEquals("apple5   is added in small Shelve", result);

	}

	@Test
	void test5() {
		Refrigerator refrigerator = new Refrigerator();
		refrigerator.addItemInRefrigerator(new Item(1, 30, "apple1"));// s
		refrigerator.addItemInRefrigerator(new Item(1, 40, "apple2"));// m
		refrigerator.addItemInRefrigerator(new Item(1, 50, "apple3"));// l
		refrigerator.addItemInRefrigerator(new Item(1, 50, "apple4"));// l
		String result = refrigerator.getSelectedItemformRefrigerator(new Item(1, 50, "apple3"));
		assertEquals("Item is present in large shelve", result);

	}

	@Test
	void test6() {
		Refrigerator refrigerator = new Refrigerator();
		refrigerator.addItemInRefrigerator(new Item(1, 30, "apple1"));// s
		refrigerator.addItemInRefrigerator(new Item(1, 40, "apple2"));// m
		refrigerator.addItemInRefrigerator(new Item(1, 50, "apple3"));// l
		refrigerator.addItemInRefrigerator(new Item(1, 50, "apple4"));// l
		String result = refrigerator.getSelectedItemformRefrigerator(new Item(1, 50, "apple33"));
		assertEquals("Item is not present ", result);

	}

	@Test
	void test7() {
		Refrigerator refrigerator = new Refrigerator();
		refrigerator.addItemInRefrigerator(new Item(1, 30, "apple1"));// s
		refrigerator.addItemInRefrigerator(new Item(1, 40, "apple2"));// m
		refrigerator.addItemInRefrigerator(new Item(1, 50, "apple3"));// l
		refrigerator.addItemInRefrigerator(new Item(1, 50, "apple4"));// l
		String result = refrigerator.getSelectedItemformRefrigerator(null);
		assertEquals("Item should not  be null ", result);

	}
}
