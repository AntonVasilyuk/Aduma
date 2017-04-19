package ru.job4j;

/**.
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class Plumber extends Profession {

	/**.
	* Constructor for class Plumber
	* @param n name
	* @param h it's be education
	* @param e experiens
	* @param pay paymant working
	*/
	public Plumber(String n, boolean h, double e, int pay) {
		super(n, h, e, pay);
	}

	/**.
	* Method work Plumber
	* @param client for name
	* @return description
	*/
	public String repairPlump(Client client) {
		String val = String.format("Сантехник " + getName() + " ремонтирует клиенту " + client.getName() + " сантехнику дома за " + getPayment() + " долларов.");
		return val;
	}
}