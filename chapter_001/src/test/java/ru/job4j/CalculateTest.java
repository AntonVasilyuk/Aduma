package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 *
 * @author Anton Vasilyuk
 * @version $Id$
 * @since 0.1
 */
public class CalculateTest{
	/**
	 * Test add.
	 */
	@Test
	public void whenExecuteMainThenPrintToConsole() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Calculate.main(null);
		assertThat(
				out.toString(),
				is(
						String.format(
								"Hello World\r\n",
								System.getProperty("line.separator")
						)
				)
		);
	}
}