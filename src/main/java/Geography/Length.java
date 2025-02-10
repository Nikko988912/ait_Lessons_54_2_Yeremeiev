package Geography;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Length {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Berlin", "Buenos Aires", "Paris", "Los Angeles", "New York", "London", "Beijing");

        List<String> filteredCities = cities.stream()
                .filter(city->city.length()>6)
                .collect(Collectors.toList());
        System.out.println( filteredCities);
    }

}
