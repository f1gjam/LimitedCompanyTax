package com.unixcraft.limitedcompanytax;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */
public class CorporationTax {


    private static final BigDecimal smallProfitsRate = new BigDecimal("20");
    private static final BigDecimal smallprofitsThreshold = new BigDecimal("300000");
    private BigDecimal businessIncomeMonthly = BigDecimal.ZERO;
    private BigDecimal businessExpenses = BigDecimal.ZERO;


    public CorporationTax(BigDecimal businessIncomeMonthly, BigDecimal businessExpenses) {

        this.businessIncomeMonthly = businessIncomeMonthly;
        this.businessExpenses = businessExpenses;

    }

    public CorpTaxBreakdown calculateCorpTax(){

        BigDecimal yearlyIncome = businessIncomeMonthly.multiply(new BigDecimal("12"));
        BigDecimal yearlyExpenses = businessExpenses.multiply(new BigDecimal("12"));


        BigDecimal yearlyProfitAfterCorpTax;
        BigDecimal monthlyProfitAfterCorpTax = BigDecimal.ZERO;

        BigDecimal yearlyIncomeAfterExpenses;

        BigDecimal corporationTaxYearly;
        BigDecimal corporationTaxMonthly = BigDecimal.ZERO;



        yearlyIncomeAfterExpenses = yearlyIncome.subtract(yearlyExpenses);

        if (yearlyIncomeAfterExpenses.compareTo(smallprofitsThreshold) <= 0) {

            corporationTaxYearly = yearlyIncomeAfterExpenses.divide(new BigDecimal("100")).multiply(smallProfitsRate);
            yearlyProfitAfterCorpTax = yearlyIncomeAfterExpenses.subtract(corporationTaxYearly);

            monthlyProfitAfterCorpTax = yearlyProfitAfterCorpTax.divide(new BigDecimal("12"));
            corporationTaxMonthly = corporationTaxYearly.divide(new BigDecimal("12"));

        }

        return new CorpTaxBreakdown(monthlyProfitAfterCorpTax, corporationTaxMonthly);
    }


}
