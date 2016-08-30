package com.unixcraft.limitedcompanytax;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */
public class BusinessIncome {
    private static BigDecimal dailyRate = BigDecimal.ZERO;
    public static BigDecimal monthlyIncome  = BigDecimal.ZERO;
    private static Integer daysWorkedInMonth;
    public static Integer numberOfShareholders;

    public BusinessIncome(Integer numberOfShareholders, Integer daysWorkedInMonth, BigDecimal dailyRate) {

        this.numberOfShareholders = numberOfShareholders;
        this.daysWorkedInMonth = daysWorkedInMonth;
        this.dailyRate = dailyRate;
    }

    public static BigDecimal CalculateMonthlyIncome(){
        monthlyIncome = dailyRate.multiply(new BigDecimal(daysWorkedInMonth));
        return monthlyIncome;
    }



}
