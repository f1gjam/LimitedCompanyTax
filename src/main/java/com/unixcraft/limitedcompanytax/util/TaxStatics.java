package com.unixcraft.limitedcompanytax.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yasin on 27/08/2016.
 */
public final class TaxStatics {

    private TaxStatics() {
    }

    //Expenses
    public static final BigDecimal CAR = BigDecimal.ZERO;
    public static final BigDecimal INTERNET = new BigDecimal("75");
    public static final BigDecimal OFFICE_365 = new BigDecimal("18");
    public static final BigDecimal SKYPE = new BigDecimal("8");
    public static final BigDecimal MOBILE_1 = new BigDecimal("40");
    public static final BigDecimal MOBILE_2 = new BigDecimal("25");
    public static final BigDecimal FUEL = new BigDecimal("60");
    public static final BigDecimal SUBSCRIPTIONS = new BigDecimal("20");
    public static final BigDecimal ADOBE = new BigDecimal("6");
    public static final BigDecimal LIABILITY_INSURANCE = new BigDecimal("20");
    public static final BigDecimal IR_35_INSURANCE = new BigDecimal("25");
    public static final BigDecimal ACCOUNTANTS_FEE = new BigDecimal("100");
    public static final BigDecimal TRAVEL_COST = new BigDecimal("180");

    public static final BigDecimal BASE_RATE = new BigDecimal("7.5");
    public static final BigDecimal HIGHER_RATE = new BigDecimal("32.5");
    public static final BigDecimal ADDITIONAL_RATE = new BigDecimal("38.1");

    private static final BigDecimal YEARLY_DIVIDEND_ALLOWANCE = new BigDecimal("5000");

    public static final BigDecimal START_BASE_RATE_BAND = YEARLY_DIVIDEND_ALLOWANCE;
    public static final BigDecimal END_OF_BASE_RATE_BAND = new BigDecimal("31865");

    public static final BigDecimal START_HIGHER_RATE_BAND = new BigDecimal("31866");
    public static final BigDecimal END_OF_HIGHER_RATE_BAND = new BigDecimal("150000");

    public static final BigDecimal START_ADDITIONAL_RATE_BAND = new BigDecimal("150001");
    public static final BigDecimal END_OF_ADDITIONAL_RATE_BAND = new BigDecimal("99999999");

    public static final Map<String, Integer> WORKED_DAYS = new HashMap();
    public static final Map<String, Integer> WORKING_DAYS = new HashMap();


    static {
        WORKED_DAYS.put("jan", 18);
        WORKED_DAYS.put("feb", 18);
        WORKED_DAYS.put("mar", 18);
        WORKED_DAYS.put("apr", 10);
        WORKED_DAYS.put("may", 18);
        WORKED_DAYS.put("jun", 15);
        WORKED_DAYS.put("jul", 10);
        WORKED_DAYS.put("aug", 13);
        WORKED_DAYS.put("sept", 18);
        WORKED_DAYS.put("oct", 18);
        WORKED_DAYS.put("nov", 18);
        WORKED_DAYS.put("dec", 18);

        WORKING_DAYS.put("jan", 21);
        WORKING_DAYS.put("feb", 20);
        WORKING_DAYS.put("mar", 23);
        WORKING_DAYS.put("apr", 18);
        WORKING_DAYS.put("may", 21);
        WORKING_DAYS.put("jun", 22);
        WORKING_DAYS.put("jul", 21);
        WORKING_DAYS.put("aug", 22);
        WORKING_DAYS.put("sept", 21);
        WORKING_DAYS.put("oct", 22);
        WORKING_DAYS.put("nov", 22);
        WORKING_DAYS.put("dec", 19);
    }



}
