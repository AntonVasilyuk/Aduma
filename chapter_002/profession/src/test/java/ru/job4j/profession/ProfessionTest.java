package ru.job4j.profession;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/
public class ProfessionTest {
//	/**.
//	* Test method qualification
//	*/
//	@Test
//	public void whenIsSpecThenWhatIsHe() {
//		Surveyor surv = new Surveyor("Андрей", true, 5.5, 50);
//		String expect = "Описание специалиста: Андрей, есть высшее образование, стоимость вызова составляет 50 долларов, его стаж составляет 5,5 лет.";
//		String fact = surv.qualificationSpec();
//		assertThat(fact, is(expect));
//	}

	/**.
	* Test method Topografy Survey
	*/
	@Test
	public void whenIsSpecThenHowHeWillBeWork() {
		Surveyor surv = new Surveyor("Андрей", true, 5.5, 50);
		Client client = new Client("Степан");
		String expect = "Геодезист Андрей выполняет съемку для клиента Степан за 50 долларов.";
		String fact = surv.topograficSurvey(client);
		assertThat(fact, is(expect));
	}
	/**.
	* Test method do diving
	*/
	@Test
	public void whenIsDiverThenHowHeWillBeWork() {
		Diver diver = new Diver("Сергей", false, 6.0, 500);
		String expect = "У водолаза Сергей уже 500 часов погружений.";
		String fact = diver.doDriving();
		assertThat(fact, is(expect));
	}
	/**.
	* Test method work plumber
	*/
	@Test
	public void whenIsPlumberThenHowHeWillBeWork() {
		Plumber plumber = new Plumber("Афоня", false, 7.0, 400);
		Client client = new Client("Мефодий");
		String expect = "Сантехник Афоня ремонтирует клиенту Мефодий сантехнику дома за 400 долларов.";
		String fact = plumber.repairPlump(client);
		assertThat(fact, is(expect));
	}
}