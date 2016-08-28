package com.unixcraft.limitedcompanytax;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */
public class DividendTaxBreakdown {

    private final BigDecimal dividendTaxAmountYearly;
    private final BigDecimal taxableDividendYearly;
    private final BigDecimal dividendAfterTaxYearly;

    public DividendTaxBreakdown(BigDecimal baseRateTaxAmount, BigDecimal taxableDividendYearly) {

        this.dividendTaxAmountYearly = baseRateTaxAmount;
        this.taxableDividendYearly = taxableDividendYearly;
        this.dividendAfterTaxYearly = taxableDividendYearly.subtract(dividendTaxAmountYearly);

    }

    public DividendTaxBreakdown(BigDecimal baseRateTaxAmount, BigDecimal highRateTaxAmount, BigDecimal taxableDividendYearly) {

        this.dividendTaxAmountYearly = baseRateTaxAmount.add(highRateTaxAmount);
        this.taxableDividendYearly = taxableDividendYearly;
        this.dividendAfterTaxYearly = taxableDividendYearly.subtract(dividendTaxAmountYearly);

    }

    public DividendTaxBreakdown(BigDecimal baseRateTaxAmount, BigDecimal highRateTaxAmount, BigDecimal addtionalRateTaxAmount, BigDecimal taxableDividendYearly) {

        this.dividendTaxAmountYearly = baseRateTaxAmount.add(highRateTaxAmount).add(addtionalRateTaxAmount);
        this.taxableDividendYearly = taxableDividendYearly;
        this.dividendAfterTaxYearly = taxableDividendYearly.subtract(dividendTaxAmountYearly);

    }


    public BigDecimal getdividendTaxAmountYearly() {
        return dividendTaxAmountYearly.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal gettaxableDividendYearly() {
        return taxableDividendYearly.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getdividendAfterTaxYearly() {
        return dividendAfterTaxYearly.setScale(2, BigDecimal.ROUND_HALF_UP);
    }


}
