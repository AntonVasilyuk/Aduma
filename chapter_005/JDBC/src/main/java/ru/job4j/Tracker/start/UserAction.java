package ru.job4j.Tracker.start;

import java.sql.SQLException;

/**
 * Task 8.4.2.
 * Update Tracker from part 2
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 * @since 0.1.
 */

public interface UserAction {
	public int key();
	public void execute(Input input, Tracker tracker) throws SQLException;
	public String info(String nameAction);
}