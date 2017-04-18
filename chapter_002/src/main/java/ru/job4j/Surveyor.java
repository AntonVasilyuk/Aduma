package ru.job4j;

/**.
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class Surveyor extends Profession {

	/**.
	* Constructor for class Surveyor
	* @param n name
	* @param h it's be education
	* @param e experiens
	* @param pay paymant working
	*/
	Surveyor(String n, boolean h, double e, int pay) {
		super(n, h, e, pay);
	}

	/**.
	* Method working Surveyors
	* @param client for name
	* @return description working
	*/
	public String topograficSurvey(Client client) {
		String val = "Геодезист " + getName() + " выполняет съемку для клиента " + client.getName() + " за " + getPayment() + " долларов.";
		return val;
	}
}