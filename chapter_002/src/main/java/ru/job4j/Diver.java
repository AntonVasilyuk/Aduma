package ru.job4j;

/**.
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class Diver extends Profession {

	/**.
	* @hour variable
	*/
	private int hour;

	/**.
	* Constructor for class Diver
	* @param n name
	* @param h be education
	* @param e experiens
	* @param hour number hour under water
	*/
	Diver(String n, boolean h, double e, int hour) {
		super(n, h, e, hour);
		this.hour = hour;
	}

	/**.
	* Method working diver
	* @return description
	*/
	public String doDriving() {
		String val = "У водолаза " + getName() + " уже " + hour + " часов погружений.";
		return val;
	}
}