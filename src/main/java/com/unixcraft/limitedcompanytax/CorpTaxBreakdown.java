package com.unixcraft.limitedcompanytax;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */
public class CorpTaxBreakdown {

    private BigDecimal monthlyProfitAfterCorpTax = BigDecimal.ZERO;
    private BigDecimal corporationTaxMonthly = BigDecimal.ZERO;

    public CorpTaxBreakdown(BigDecimal monthlyProfitAfterCorpTax, BigDecimal corporationTaxMonthly) {
        this.monthlyProfitAfterCorpTax = monthlyProfitAfterCorpTax;
        this.corporationTaxMonthly = corporationTaxMonthly;
    }

    public BigDecimal getProfitAfterCorpTax() {
        return monthlyProfitAfterCorpTax.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getCorporationTaxMonthly() {
        return corporationTaxMonthly.setScale(2, BigDecimal.ROUND_HALF_UP);
    }


}
