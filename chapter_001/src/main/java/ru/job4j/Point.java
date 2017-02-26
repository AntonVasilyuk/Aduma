package ru.job4j;

/**.
 * Вычисляем площадь треугольника
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class Point {

	/**.
	* @x variable
	*/
	private double x;

	/**.
	* @y variable
	*/
	private double y;

	/**.
	* @param x координата
	* @param y координата
	*/
	public Point(double x, double y) {

		this.x = x;
		this.y = y;

	}

	/**.
	* Высчитываем расстояние между двух точек
	* @param t1 object
	* @param t2 object
	* @return result
	*/
	public double distanceTo(Point t1, Point t2) {

		double x1, y1, x2, y2, rast;
		x1 = t1.x;
		x2 = t2.x;
		y1 = t1.y;
		y2 = t2.y;
		rast = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

		return rast;

	}

}