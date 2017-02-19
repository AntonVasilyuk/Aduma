package ru.job4j;

/**.
 * Calculator решение задачи часть 001 подпункт 2.3.
 *
 * @author Anton Vasilyuk (wrajina99@gmail.com)
 * @version $Id$
 * @since 0.1
 */

 public class Calculator {

	/**.
	* @result для приема результата
	*/
	private double result;

	/**.
	* Сложение
	* @param first первый аргумент
	* @param second второй аргумент
	*/
	public void add(double first, double second) {

		this.result = first + second;

	}

	/**.
	* Вычитание
	* @param first первый аргумент
	* @param second второй аргумент
	*/
	public void substruct(double first, double second) {

		this.result = first - second;

	}

	/**.
	* Деление
	* @param first первый аргумент
	* @param second второй аргумент
	*/
	public void dif(double first, double second) {

		this.result = first / second;

	}

	/**.
	* Умножение
	* @param first первый аргумент
	* @param second второй аргумент
	*/
	public void multiple(double first, double second) {

		this.result = first * second;

	}

	/**.
	* @getResult Возврат начального значения переменной result
	* @return result результат к начальному значению
	*/
	public double getResult() {

		return result;

	}

 }