package ru.job4j;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**.
 * Task 7.6.3.
 * Create Aquarium
 *
 * @author Anton Vasilyuk on 04.10.2017
 * @version 1.0.
 */

public class AquariumMain {

    /**.
     * @rd is object for randomly select the number of fish
     */
    private final Random rdNumFish = new Random(1000);

    /**.
     * @rdLiveFish is object for randomly select long live the fish
     */
    private final Random rdLiveFish = new Random(259200000);

    /**.
     * @mainLocation is object for choise of position for fish
     */
    private final Location mainLocation = new Location(0, 0);

    /**.
     * @numFish the number of fish in the aquarium
     */
    private final int numFish;

    /**.
     * @list is list all fish
     */
    private Map<Location, Fish> list;

    /**.
     * @aquarium is link for aquarium
     */
    private Aquarium aquarium;

    /**.
     * @inf is print current information
     */
    private Information inf;

    /**
     * @listFish is array for all thread the fish
     */
    private MovingFish[] listFish;

    /**.
     * Constructor
     */
    public AquariumMain() {
        numFish = rdNumFish.nextInt();
        aquarium = new Aquarium();
        list = new ConcurrentHashMap<>();
        for (int i = 0; i < numFish; i++) {
            String male = i % 2 == 0 ? "male" : "female";
            Location location = mainLocation.newLocation(10000, list);
            Fish fish = new Fish(i, rdLiveFish.nextLong(), male, location);
            list.put(fish.getLocation(), fish);
            listFish[i] = new MovingFish(fish, aquarium, list);
        }
        inf = new Information(list);
    }

    /**.
     * Run the current programm
     */
    public void startLiveAquarium() {
        for (int i = 0; i < listFish.length; i++) {
            Thread thread = new Thread(listFish[i]);
            thread.start();
        }
        Thread thread = new Thread(inf);
        thread.start();
    }

    /**.
     * End the current programm
     */
    public void setEndGame() {
        for (int i = 0; i < listFish.length; i++) {
            listFish[i].setEndGame();
        }
        inf.setEndGame();
        System.out.printf("View over!");
    }
}
