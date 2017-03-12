package ru.job4j;

/**.
*
* @author Anton Vasilyuk
* @version 1.0
* @since 0.1
*/

public class Paint {
	/**.
	* Method for construction piramid
	* @param h height piramid
	* @return result
	*/
	public String piramid(int h) {

		StringBuilder pir = new StringBuilder();

		String floor = "^ ";

		String res = "\n";

		for (int i = 0; i < h; i++) {
            String spica = "";
            for (int x = 0; x < h - 1 - i; x++) {
                spica = spica + " ";
            }

            pir.append(spica).append(floor).append(res);
            floor = floor + "^ ";

        }
		return pir.toString();

	}

}