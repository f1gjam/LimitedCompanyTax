package com.unixcraft.limitedcompanytax;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */
public class BusinessExpenses {
    private static BigDecimal car = BigDecimal.ZERO;
    private static BigDecimal internet = new BigDecimal("75");
    private static BigDecimal office365 = new BigDecimal("18");
    private static BigDecimal skype = new BigDecimal("8");
    private static BigDecimal mobile1 = new BigDecimal("40");
    private static BigDecimal mobile2 = new BigDecimal("25");
    private static BigDecimal fuel = new BigDecimal("60");
    private static BigDecimal subscriptions = new BigDecimal("20");
    private static BigDecimal adobe = new BigDecimal("6");
    private static BigDecimal liabilityInsurance = new BigDecimal("20");
    private static BigDecimal ir35Insurance = new BigDecimal("25");
    private static BigDecimal accountantsFee = new BigDecimal("100");
    private static BigDecimal travelCost = new BigDecimal("180");


    public static BigDecimal totalExpenses = car.add(internet).add(office365).add(skype).add(
            mobile1).add(mobile2).add(fuel).add(subscriptions).add(adobe).add(liabilityInsurance).add(
            ir35Insurance).add(accountantsFee).add(travelCost);

}
