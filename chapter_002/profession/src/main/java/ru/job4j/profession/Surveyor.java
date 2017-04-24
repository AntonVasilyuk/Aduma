package ru.job4j.profession;

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
	public Surveyor(String n, boolean h, double e, int pay) {
		super(n, h, e, pay);
	}

	/**.
	* Method working Surveyors
	* @param client for name
	* @return description working
	*/
	public String topograficSurvey(Client client) {
		String val = String.format("Геодезист %s выполняет съемку для клиента %s за %d долларов.", getName(), client.getName(), getPayment());
		return val;
	}
}