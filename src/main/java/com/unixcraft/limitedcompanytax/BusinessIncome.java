package com.unixcraft.limitedcompanytax;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */
public class BusinessIncome {
    private BigDecimal dailyRate = new BigDecimal("350");
    private BigDecimal monthlyIncome;
    private Integer daysInMonth;

    public Integer getDaysInMonth() {
        return daysInMonth;
    }

    public void setDaysInMonth(Integer daysInMonth) {
        this.daysInMonth = daysInMonth;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(BigDecimal monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }


}
