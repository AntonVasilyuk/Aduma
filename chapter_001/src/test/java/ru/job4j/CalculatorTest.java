package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 * CalculatorTest.
 *
 * @author Anton Vasilyuk (wrajina99@gmail.com)
 * @version $Id$
 * @since 0.1
 */

 public class CalculatorTest {

	/**.
	* Тест сложения
	*/
	@Test
	public void testWhenAddOneToOneThenTwo() {
		Calculator calc = new Calculator();
		calc.add(1, 1);
		final double result = calc.getResult();
		assertThat(result, is(2d));

	}

	/**.
	* Тест Вычитание
	*/
	@Test
	public void testWhenSubstructOneToOneThenZero() {
		Calculator calc = new Calculator();
		calc.substruct(2, 1);
		final double result = calc.getResult();
		assertThat(result, is(1d));

	}

	/**.
	* Тест Деление
	*/
	@Test
	public void testWhenDifOneToOneThenOne() {
		Calculator calc = new Calculator();
		calc.dif(1, 1);
		final double result = calc.getResult();
		assertThat(result, is(1d));

	}

	/**.
	* Тест Умножение
	*/
	@Test
	public void testWhenMultipleOneToOneThenOne() {
		Calculator calc = new Calculator();
		calc.multiple(1, 1);
		final double result = calc.getResult();
		assertThat(result, is(1d));

	}

}