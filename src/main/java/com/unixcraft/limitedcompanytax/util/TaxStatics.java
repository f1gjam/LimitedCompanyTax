package com.unixcraft.limitedcompanytax.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yasin on 27/08/2016.
 */
public final class TaxStatics {

    //Expenses
    public static final BigDecimal CAR = BigDecimal.ZERO;
    public static final BigDecimal INTERNET = new BigDecimal("75");
    public static final BigDecimal OFFICE_365 = new BigDecimal("20");
    public static final BigDecimal SKYPE = new BigDecimal("10");
    public static final BigDecimal MOBILE_1 = new BigDecimal("40");
    public static final BigDecimal MOBILE_2 = new BigDecimal("20");
    public static final BigDecimal FUEL = new BigDecimal("60");
    public static final BigDecimal SUBSCRIPTIONS = new BigDecimal("20");
    public static final BigDecimal ADOBE = new BigDecimal("6");
    public static final BigDecimal LIABILITY_INSURANCE = new BigDecimal("20");
    public static final BigDecimal IR35_INSURANCE = new BigDecimal("25");
    public static final BigDecimal ACCOUNTANTS_FEE = new BigDecimal("100");
    public static final BigDecimal TRAVEL_COST = new BigDecimal("180");
   //TEMP until PAYEdetails is finished
    public static final BigDecimal PAYE_COST = new BigDecimal("2265.41");
    //Dividend Stuff
    public static final BigDecimal BASE_RATE = new BigDecimal("7.5");
    public static final BigDecimal HIGHER_RATE = new BigDecimal("32.5");
    public static final BigDecimal ADDITIONAL_RATE = new BigDecimal("38.1");
    public static final BigDecimal END_OF_BASE_RATE_BAND = new BigDecimal("31865");
    public static final BigDecimal START_HIGHER_RATE_BAND = new BigDecimal("31866");
    public static final BigDecimal END_OF_HIGHER_RATE_BAND = new BigDecimal("150000");
    public static final BigDecimal START_ADDITIONAL_RATE_BAND = new BigDecimal("150001");
    public static final BigDecimal END_OF_ADDITIONAL_RATE_BAND = new BigDecimal("99999999");
    public static final Map<String, Integer> WORKED_DAYS = new HashMap();
    public static final Map<String, Integer> WORKING_DAYS = new HashMap();
    public static final BigDecimal SMALL_PROFITS_RATE = new BigDecimal("20");
    public static final BigDecimal SMALL_PROFITS_THRESHOLD = new BigDecimal("300000");
    private static final BigDecimal YEARLY_DIVIDEND_ALLOWANCE = new BigDecimal("5000");
    public static final BigDecimal START_BASE_RATE_BAND = YEARLY_DIVIDEND_ALLOWANCE;


    //Corp Tax stuff
    public static BigDecimal TOTAL_EXPENSES_MONTHLY = TaxStatics.CAR.add(TaxStatics.INTERNET).add(TaxStatics.OFFICE_365).add(
            TaxStatics.SKYPE).add(TaxStatics.MOBILE_1).add(TaxStatics.MOBILE_2).add(TaxStatics.FUEL).add(
            TaxStatics.SUBSCRIPTIONS).add(TaxStatics.ADOBE).add(TaxStatics.LIABILITY_INSURANCE).add(
            TaxStatics.IR35_INSURANCE).add(TaxStatics.ACCOUNTANTS_FEE).add(TaxStatics.TRAVEL_COST).add(
            TaxStatics.PAYE_COST);

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

    private TaxStatics() {
    }



}
