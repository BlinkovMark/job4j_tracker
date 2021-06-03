package ru.job4j.stream;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void whenAddress() {
        Profiles profiles = new Profiles();
        List<Profile> profile = new ArrayList<>();
        profile.add(new Profile(new Address("Tallinn", "Pikri", 6, 12)));
        profile.add(new Profile(new Address("Tallinn", "Katleri", 3, 44)));
        profile.add(new Profile(new Address("Tallinn", "Kihnu", 2, 1)));
        List<Address> expected = Arrays.asList(
                new Address("Tallinn", "Pikri", 6, 12),
                new Address("Tallinn", "Katleri", 3, 44),
                new Address("Tallinn", "Kihnu", 2, 1));
        assertThat(profiles.collect(profile), is(expected));
    }

    @Test
    public void whenSortAddress() {
        Profiles profiles = new Profiles();
        List<Profile> profile = new ArrayList<>();
        profile.add(new Profile(new Address("Tallinn", "Pikri", 6, 12)));
        profile.add(new Profile(new Address("Maardu", "Norte", 4, 1)));
        profile.add(new Profile(new Address("Tallinn", "Pikri", 6, 12)));
        List<Address> expected = Arrays.asList(
                new Address("Maardu", "Norte", 4, 1),
                new Address("Tallinn", "Pikri", 6, 12));
        assertThat(profiles.sort(profile), is(expected));
    }
}
