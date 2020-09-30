package helper;

import java.util.Random;
import java.util.stream.Collectors;

public class IbanGenerator {
    private static final String COUNTRY_CODE = "LT";

    public String generate() {
        String iban = new Random().ints(18, 0, 9)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());

        return COUNTRY_CODE + iban;
    }
}
