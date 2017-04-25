package ru.job4j.start;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

import java.util.Date;
import ru.job4j.models.Item;
import ru.job4j.start.*;

/**.
* chapter_002
* It's class for testing behavior users
* 
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class StubInputTest {

	/**.
	* @date date for getTime
	*/
	private Date date = new Date();

	/**.
	* Test for method ADD
	*/
	@Test
	public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
		Tracker tracker = new Tracker();
		Input input = new StubInput(new String[] {"0", "Testing name", "desc", "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findAll()[0].getName(), is("test name"));
	}

	/**.
	* Test for method FINDALL
	*/
	@Test
	public void whenUserFindAllItemThenTrackerHasShowAllItemWithSameName() {
		Tracker tracker = new Tracker();
		Item item = new Item("Ivan","desc", date.getTime());
		tracker.add(item);
		Input input = new StubInput(new String[] {"1", "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findAll()[0].getName(), is("Ivan"));
	}

	/**.
	* Test for method EDIT
	*/
	@Test
	public void whenUserEditItemThenTrackerHasEditItemById() {
		Tracker tracker = new Tracker();
		Item item = new Item("Ivan","desc", date.getTime());
		tracker.add(item);
		item.setId("1");
		Input input = new StubInput(new String[] {"2", "1", "Egor", "desc", "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findAll()[0].getName(), is("Egor"));
	}

	/**.
	* Test for method DELETE
	*/
	@Test
	public void whenUserDeleteItemThenTrackerHasDeleteItemById() {
		Tracker tracker = new Tracker();
		Item item = new Item("Ivan","desc", date.getTime());
		tracker.add(item);
		item.setId("1");
		Input input = new StubInput(new String[] {"3", "1", "6"});
		new StartUI(input, tracker).init();
		assertNull(tracker.findAll()[0]);
	}

	/**.
	* Test for method FIND BY ID
	*/
	@Test
	public void whenUserFindByIdItemThenTrackerHasFindItemById() {
		Tracker tracker = new Tracker();
		Item item = new Item("Ivan","desc", date.getTime());
		tracker.add(item);
		item.setId("1");
		Input input = new StubInput(new String[] {"4", "1", "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findAll()[0].getName(), is("Ivan"));
	}

	/**.
	* Test for method FIND BY NAME
	*/
	@Test
	public void whenUserFindByNameItemThenTrackerHasFindItemByName() {
		Tracker tracker = new Tracker();
		Item item = new Item("Zoiberg","Bingo", date.getTime());
		tracker.add(item);
		Input input = new StubInput(new String[] {"5", "Zoiberg", "6"});
		new StartUI(input, tracker).init();
		assertThat(tracker.findAll()[0].getDesc(), is("Bingo"));
	}
}