package ru.job4j.start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;
import ru.job4j.models.*;

/**.
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class TrackerTest {

	/**.
	* method for test add
	*/
	@Test
	public void whenNeedAddItemThenGetResult() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("Ivan", "Cheerful man", 1988);
		Item itemFact;
		itemFact = tracker.add(item1);
		boolean expect = true;
		boolean fact = false;
		if (itemFact.getId() != null) {
			fact = true;
			}
		assertThat(fact, is(expect));
	}

	/**.
	* method for test update
	*/
	@Test
	public void whenNeedUpdateItemThenUpdateItem() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("Ivan", "Cheerful man", 1988);
		Item itemId = tracker.add(item1);
		Item itemNew = new Item("Nikolay", "Cheerful man", 1980);
		itemNew.setId(itemId.getId());
		tracker.update(itemNew);
		String expect = "Nikolay";
		String fact = tracker.findById(itemNew.getId()).getName();
		assertThat(fact, is(expect));
	}

	/**.
	* method for test delete item
	*/
	@Test
	public void whenNeedDelItemThenWeDellNeedItem() {
		Tracker tracker = new Tracker();
		Item itemTemp = new Item("Valera", "Small man", 1975);
		tracker.add(itemTemp);
		tracker.delete(itemTemp);
		Item fact = tracker.findById(itemTemp.getId());
		assertNull(fact);
	}

	/**.
	* method for test find all item
	*/
	@Test
	public void whenNeedShowAllItemThenWeShowAllItem() {
		Tracker tracker = new Tracker();
		Item itemTemp = new Item("Valera", "Small man", 1975);
		tracker.add(itemTemp);
		Item[] showAll = tracker.findAll();
		String expect = itemTemp.getName();
		String fact = showAll[0].getName();
		assertThat(fact, is(expect));
	}

	/**.
	* method for test find find by name item
	*/
	@Test
	public void whenNeedFindByNameThenWeShowByNameItem() {
		Tracker tracker = new Tracker();
		Item itemTempOne = new Item("Nic", "Big man", 1975);
		Item itemTempTwo = new Item("Valera", "Bingo", 1971);
		tracker.add(itemTempOne);
		tracker.add(itemTempTwo);
		String expect = itemTempTwo.getDesc();
		Item[] itemArrayName = tracker.findByName("Valera");
		String fact = itemArrayName[0].getDesc();
		assertThat(fact, is(expect));
	}

	/**.
	* method for test find find by id item
	*/
	@Test
	public void whenNeedFindByIdThenWeShowByIdItem() {
		Tracker tracker = new Tracker();
		Item itemTempOne = new Item("Nic", "Big man", 1975);
		Item itemTempTwo = new Item("Valera", "Bingo", 1971);
		Item itemOne = tracker.add(itemTempOne);
		Item itemTwo = tracker.add(itemTempTwo);
		String expect = itemTempTwo.getDesc();
		Item itemThird = tracker.findById(itemTwo.getId());
		String fact = itemThird.getDesc();
		assertThat(fact, is(expect));
	}
}