package ru.job4j.address;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;

/**.
 * Chapter_003
 * Task_110062
 * Main class for this app - collect address from profiles
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class ProfilesTest {

    /**.
     * @listProfile is list for models profile
     */
    private List<Profile> listProfile;

    /**.
     * Loading list listProfile before testing
     */
    @Before
    public void loadList() {
        listProfile = new ArrayList<>();
        listProfile.add(new Profile(new Address("London", "Haski", 3, 15)));
        listProfile.add(new Profile(new Address("Ambrasador", "Turor", 4, 15)));
        listProfile.add(new Profile(new Address("Kiev", "Wiskas", 5, 15)));
        listProfile.add(new Profile(new Address("London", "Haski", 3, 15)));
        listProfile.add(new Profile(new Address("Rostov", "Haski", 3, 15)));
    }

    /**.
     * Test working apps sorting list by cities
     */
    @Test
    public void whenGetManyProfilesThenReturnListWithThreeAddressSorted() {
        Profiles profiles = new Profiles();
        List<Address> list = profiles.collect(listProfile);
        Assert.assertThat(list.get(0).getCity(), is("Ambrasador"));
    }

    /**.
     * Test for uniqueness of the addresses
     */
    @Test
    public void whenGetManyProfilesThenReturnListWithThreeAddressDistinct() {
        Profiles profiles = new Profiles();
        List<Address> list = profiles.collect(listProfile);
        Assert.assertThat(list.size(), is(4));
    }
}