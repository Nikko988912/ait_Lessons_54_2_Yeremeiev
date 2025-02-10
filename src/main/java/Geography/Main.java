package Geography;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> countries = Arrays.asList("Germany", "France", "Brazil", "Argentina", "Canada", "China", "Australia", "India");

        List<String> filteredCountries = countries.stream()
                .filter(country->country.startsWith("C"))
                .collect(Collectors.toList());
        System.out.println(filteredCountries);

    }
}
