package ru.job4j;

import java.util.*;

public class ConsolInput implements Input {
	privite Scanner scanner = new Scanner();

	public String ask(String question) {

		System.out.print(question);
		return scanner.nextLine()
	}
}