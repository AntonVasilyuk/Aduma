package ru.job4j.address;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**.
 * Chapter_003
 * Task_110062
 * Main class for this app - collect address from profiles
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class Profiles {

    /**.
     * Method for collect address from list profiles
     * @param profiles is list profiles
     * @return list address
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(new Comparator<Address>() {
                    @Override
                    public int compare(Address o1, Address o2) {
                        return o1.getCity().compareTo(o2.getCity());
                    }
                })
                .distinct()
                .collect(Collectors.toList());
    }
}
