package ru.job4j.Tracker.start;

import java.util.List;

/**
 * Task 8.4.2.
 * Update Tracker from part 2
 *
 * @author Anton Vasilyuk
 * @version 1.0.
 * @since 0.1.
 */


public interface Input {
	
	String ask(String question);
	int ask(String question, List<Integer> ranges);
}