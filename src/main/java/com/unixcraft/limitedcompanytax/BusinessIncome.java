package com.unixcraft.limitedcompanytax;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */
public class BusinessIncome {
    private static BigDecimal dailyRate = BigDecimal.ZERO;
    private static BigDecimal monthlyIncome  = BigDecimal.ZERO;
    private static Integer daysWorkedInMonth;
    private static Integer numberOfShareholders;

    public BusinessIncome(Integer numberOfShareholders, Integer daysWorkedInMonth, BigDecimal dailyRate) {

        this.numberOfShareholders = numberOfShareholders;
        this.daysWorkedInMonth = daysWorkedInMonth;
        this.numberOfShareholders = numberOfShareholders;
    }

    public static BigDecimal CalculateMonthlyIncome(){
        monthlyIncome = dailyRate.multiply(new BigDecimal(daysWorkedInMonth));
        return monthlyIncome;
    }



}
