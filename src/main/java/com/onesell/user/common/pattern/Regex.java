package com.onesell.user.common.pattern;

public class Regex {

    public static final String ONLY_ENG_AND_NUMBER = "^[a-zA-Z0-9]+$";

    public static final String ONLY_ENG_AND_NUMBER_AND_SPECIAL = "^[a-zA-Z0-9!@#$%^&*]{8,}$";

    public static final String CELL_PHONE = "^(01[0-9])-(\\d{3,4})-([0-9]{4})$";

    public static final String EMAIL = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

}
