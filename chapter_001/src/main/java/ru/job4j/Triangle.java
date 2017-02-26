package ru.job4j;

/**.
 * Вычисляем площадь треугольника
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class Triangle {

	/**.
	* @a первая точка
	*/
	private Point a;

	/**.
	* @b вторая точка
	*/
	private Point b;

	/**.
	* @c вторая точка
	*/
	private Point c;

	/**.
	* Получаем площадь треугольника
	* @param a object
	* @param b object
	* @param c object
	* @return result area
	*/
	public double area(Point a, Point b, Point c) {

		Point point = new Point(0, 0);

		double p = (point.distanceTo(a, b) + point.distanceTo(b, c) + point.distanceTo(c, a)) / 2;
		return Math.sqrt(p * point.distanceTo(a, b) * point.distanceTo(b, c) * (p - point.distanceTo(c, a)));

	}

}