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
	* сравнение
	* @param first первый аргумент
	* @param second второй аргумент
	* @param third третий аргумент
	* @return возвращает наибольшее значение
	*/
	public int max(int first, int second, int third) {

		int result = first > second ? first : second;
		return result > third ? result : third;

	}

}