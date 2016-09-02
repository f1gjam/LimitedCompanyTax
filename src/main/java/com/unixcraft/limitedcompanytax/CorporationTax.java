package com.unixcraft.limitedcompanytax;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */
public class CorporationTax {

    private static final BigDecimal SMALL_PROFITS_RATE = new BigDecimal("20");
    private static final BigDecimal SMALL_PROFITS_THRESHOLD = new BigDecimal("300000");

    private BigDecimal businessIncomeMonthly = BigDecimal.ZERO;
    private BigDecimal businessExpensesMonthly = BigDecimal.ZERO;

    private BigDecimal monthlyProfitAfterCorpTax = BigDecimal.ZERO;
    private BigDecimal corporationTaxMonthly = BigDecimal.ZERO;

    public CorporationTax(BigDecimal businessIncomeMonthly, BigDecimal businessExpensesMonthly) {
        this.businessIncomeMonthly = businessIncomeMonthly;
        this.businessExpensesMonthly = businessExpensesMonthly;
        calculateCorpTax();
    }

    public void calculateCorpTax(){

        BigDecimal yearlyIncome = businessIncomeMonthly.multiply(new BigDecimal("12"));
        BigDecimal yearlyIncomeAfterExpenses = yearlyIncome.subtract(businessExpensesMonthly.multiply(new BigDecimal("12")));

        if (yearlyIncomeAfterExpenses.compareTo(SMALL_PROFITS_THRESHOLD) <= 0) {
            BigDecimal corporationTaxYearly = yearlyIncomeAfterExpenses.divide(new BigDecimal("100")).multiply(SMALL_PROFITS_RATE);
            monthlyProfitAfterCorpTax = yearlyIncomeAfterExpenses.subtract(corporationTaxYearly).divide(new BigDecimal("12"));
            corporationTaxMonthly = corporationTaxYearly.divide(new BigDecimal("12"));
        }
    }

    public BigDecimal getProfitAfterCorpTax() {
        return monthlyProfitAfterCorpTax.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getCorporationTaxMonthly() {
        return corporationTaxMonthly.setScale(2, BigDecimal.ROUND_HALF_UP);
    }



}
