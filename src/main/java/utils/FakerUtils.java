package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

import static org.apache.commons.lang3.StringUtils.SPACE;

public class FakerUtils {

    private static final String LANGUAGE = "nb";
    public static final String COUNTRY = "NO";

    public static Faker getEvFaker() {
        return new Faker(getEvLocale());
    }

    public static Faker getDefaultFaker() {
        return new Faker();
    }

    private static Locale getEvLocale() {
        return new Locale.Builder().setLanguage(LANGUAGE).setRegion(COUNTRY).build();
    }

    public static String getFakerFirstName() {
        return getEvFaker().name().firstName();
    }

    public static String getFakerLastName() {
        return getEvFaker().name().lastName();
    }

    public static String getFakerFullName() {
        return getEvFaker().name().fullName();
    }

    public static String getFakerCompany() {
        return getEvFaker().company().name();
    }

    public static String getFakerPhone() {
        return getEvFaker().phoneNumber().cellPhone();
    }

    public static String getFakerCity(boolean invoice) {
        return invoice ? getDefaultFaker().address().cityName() : getEvFaker().address().cityName();
    }

    public static String getFakerZipCode() {
        return getEvFaker().address().zipCode();
    }

    public static String getFakerStreetAddress() {
        return getEvFaker().address().streetAddress();
    }

    public static String getFakerDescription(int numberOfWords) {
        return String.join(SPACE, getDefaultFaker().lorem().words(numberOfWords));
    }

    public static String getFakerNumber(int min, int max) {
        return String.valueOf(getDefaultFaker().number().numberBetween(min, max));
    }

    public static String getFakerOrganization() {
        return getDefaultFaker().company().name();
    }

    public static String getFakerProject() {
        return getDefaultFaker().space().constellation();
    }
}
