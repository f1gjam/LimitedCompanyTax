package com.unixcraft.limitedcompanytax;

import com.unixcraft.limitedcompanytax.util.TaxStatics;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */
public class CorporationTax {

    private static final BigDecimal SMALL_PROFITS_RATE = TaxStatics.SMALL_PROFITS_RATE;
    private static final BigDecimal SMALL_PROFITS_THRESHOLD = TaxStatics.SMALL_PROFITS_THRESHOLD;

    private BigDecimal businessIncomeMonthly = BigDecimal.ZERO;
    private BigDecimal businessExpensesMonthly = BigDecimal.ZERO;

    public CorporationTax(BigDecimal businessIncomeMonthly, BigDecimal businessExpensesMonthly) {

        this.businessIncomeMonthly = businessIncomeMonthly;
        this.businessExpensesMonthly = businessExpensesMonthly;

    }

    public CorpTaxBreakdown calculateCorpTax(){

        BigDecimal yearlyIncome = businessIncomeMonthly.multiply(new BigDecimal("12"));
        BigDecimal monthlyProfitAfterCorpTax = BigDecimal.ZERO;
        BigDecimal corporationTaxMonthly = BigDecimal.ZERO;

        BigDecimal yearlyIncomeAfterExpenses = yearlyIncome.subtract(businessExpensesMonthly.multiply(new BigDecimal("12")));

        if (yearlyIncomeAfterExpenses.compareTo(SMALL_PROFITS_THRESHOLD) <= 0) {
            BigDecimal corporationTaxYearly = yearlyIncomeAfterExpenses.divide(new BigDecimal("100")).multiply(SMALL_PROFITS_RATE);
            monthlyProfitAfterCorpTax = yearlyIncomeAfterExpenses.subtract(corporationTaxYearly).divide(new BigDecimal("12"));
            corporationTaxMonthly = corporationTaxYearly.divide(new BigDecimal("12"));
        }

        return new CorpTaxBreakdown(monthlyProfitAfterCorpTax, corporationTaxMonthly);
    }


}
