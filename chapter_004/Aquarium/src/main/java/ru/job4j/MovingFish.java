package ru.job4j;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**.
 * Task 7.6.3.
 * Create Aquarium
 *
 * @author Anton Vasilyuk on 02.10.2017
 * @version 1.0.
 */

public class MovingFish implements Runnable{

    private final Fish fish;
    private final Aquarium aquarium;
    private final Map<Location, Fish> list;

    /**.
     * @date for print the current date
     */
    private final Date date;

    /**.
     * Checkpoint for end the game
     */
    private boolean endGame = true;

    /**.
     * Constructor for this class
     * @param fish is link for this fish
     * @param aquarium is link for this world for fishs
     */
    public MovingFish(Fish fish, Aquarium aquarium, Map<Location, Fish> list) {
        this.fish = fish;
        this.aquarium = aquarium;
        this.list = list;
        date = new Date();
    }

    /**.
     * Action for thread
     */
    @Override
    public void run() {
        boolean flag;
        Location oldPlace;
        ReentrantLock[][] world = aquarium.getWorld();
        while (endGame) {
            flag = false;
            while (!flag) {
                boolean flagSecond = false;
                Location step = fish.step();
                try {
                    if(world[step.getX()][step.getY()].tryLock(50, MILLISECONDS)) {
                        flag = true;
                        flagSecond = true;
                    } else {
                        Fish metFish;
                        metFish = list.get(step);
                        if(fish.getMale().equals(metFish.getMale())) {
                            System.out.printf("Was found the fish %d and fish %d in %s!%n",
                                    this.fish.getNumFish(), metFish.getNumFish(), date.toString());
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if(flagSecond) {
                        oldPlace = fish.getLocation();
                        world[oldPlace.getX()][oldPlace.getY()].unlock();
                    }
                }
                if(flagSecond) {
                    fish.newPlace(step);
                    System.out.println(fish);
                }
            }
            if (System.currentTimeMillis() > fish.getLiveFish()) {
                System.out.printf("Fish №%d is die%n", fish.getNumFish());
                list.remove(fish.getLocation());
                setEndGame();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**.
     * Set flag endGame
     */
    public void setEndGame() {
        this.endGame = false;
    }
}

