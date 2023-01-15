import java.util.ArrayList;
import java.util.List;

public enum RomanArabic {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50);
    private final int value;

    RomanArabic(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ArrayList<RomanArabic> getReverseSortedValues() {
        ArrayList<RomanArabic> result = new ArrayList<>();
        for (int i = RomanArabic.values().length - 1; i >= 0; --i) {
            RomanArabic e = RomanArabic.values()[i];
            result.add(e);
        }
        return result;
    }

    public static int romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;
        List<RomanArabic> romanNumerals = RomanArabic.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanArabic symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " хм, возможно вы хотели написать что то другое?");
        }

        return result;
    }

    public static String arabicToRoman(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(number + " можно конечно посчитать если очень постараться... " +
                    "но Лучше попробуем ещё раз");
        }

        List<RomanArabic> romanNumerals = RomanArabic.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanArabic currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
