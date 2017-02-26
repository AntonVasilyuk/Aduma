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
	* @return result
	*/
	public double distanceTo(Point t1) {

		double x1, y1, rast;
		x1 = t1.x;
		y1 = t1.y;
		rast = Math.sqrt(Math.pow((x - x1), 2) + Math.pow((y - y1), 2));

		return rast;

	}

}