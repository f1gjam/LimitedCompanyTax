package com.unixcraft.limitedcompanytax;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */
public class CorporationTax {

    private static final BigDecimal SMALL_PROFITS_RATE = new BigDecimal("20");
    private static final BigDecimal SMALL_PROFITS_THRESHOLD = new BigDecimal("300000");

    public CorpTaxBreakdown calculateCorpTax(BigDecimal businessIncomeMonthly, BigDecimal businessExpenses){

        BigDecimal yearlyIncome = businessIncomeMonthly.multiply(new BigDecimal("12"));
        BigDecimal monthlyProfitAfterCorpTax = BigDecimal.ZERO;
        BigDecimal corporationTaxMonthly = BigDecimal.ZERO;

        BigDecimal yearlyIncomeAfterExpenses = yearlyIncome.subtract(businessExpenses.multiply(new BigDecimal("12")));

        if (yearlyIncomeAfterExpenses.compareTo(SMALL_PROFITS_THRESHOLD) <= 0) {
            BigDecimal corporationTaxYearly = yearlyIncomeAfterExpenses.divide(new BigDecimal("100")).multiply(SMALL_PROFITS_RATE);
            monthlyProfitAfterCorpTax = yearlyIncomeAfterExpenses.subtract(corporationTaxYearly).divide(new BigDecimal("12"));
            corporationTaxMonthly = corporationTaxYearly.divide(new BigDecimal("12"));
        }

        return new CorpTaxBreakdown(monthlyProfitAfterCorpTax, corporationTaxMonthly);
    }


}
