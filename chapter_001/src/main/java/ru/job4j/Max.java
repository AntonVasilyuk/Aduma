package ru.job4j;

/**.
 * Max выбор максимального по значению числа.
 *
 * @author Anton Vasilyuk
 * @version $Id$
 * @since 0.1
 */
public class Max {

	/**.
	* @result для приема результата
	*/
	private int result;

	/**.
	* сравнение
	* @param first первый аргумент
	* @param second второй аргумент
	* @return возвращает наибольшее значение
	*/
	public int max(int first, int second) {

		result = first > second ? first : second;

		return result;

	}

	/**.
	* беру значение для теста
	* @return результат
	*/
	public int getResult() {

		return result;

	}

}