package ru.job4j.address;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;

public class ProfilesTest {

    @Test
    public void whenGetThreeProfilesThenReturnListWithThreeAddress() {
        Profiles profiles = new Profiles();
        List<Profile> profileList = new ArrayList<>();
        profileList.add(new Profile(new Address("London", "Haski", 3, 15)));
        profileList.add(new Profile(new Address("London", "Turor", 4, 15)));
        profileList.add(new Profile(new Address("London", "Wiskas", 5, 15)));
        List<Address> list = profiles.collect(profileList);
        Assert.assertThat(list.get(1).getStreet(), is("Turor"));
    }
}