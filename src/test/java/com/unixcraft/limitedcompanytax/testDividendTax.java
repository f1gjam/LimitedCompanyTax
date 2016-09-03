package com.unixcraft.limitedcompanytax;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */

public class testDividendTax {

    private DividendTax unit;

    @Test
    public void testDividendAdditionalRateTaxAfterTaxedIncomeMonthly() {


        unit = new DividendTax(2, new BigDecimal("307563.43"));

        DividendTaxBreakdown dividendTax = unit.DividendYearlyTaxBreakdown();

        Assert.assertEquals(new BigDecimal("41849.58"), dividendTax.getdividendTaxAmountYearly());
        Assert.assertEquals(new BigDecimal("148781.72"), dividendTax.gettaxableDividendYearly());
        //Tax for each person
        Assert.assertEquals(new BigDecimal("106932.13"), dividendTax.getdividendAfterTaxYearly());
    }

    @Test
    public void testDividendHighRateTaxAfterTaxedIncomeMonthly() {

        unit = new DividendTax(2, new BigDecimal("107122.46"));

        DividendTaxBreakdown dividendTax = unit.DividendYearlyTaxBreakdown();

        Assert.assertEquals(new BigDecimal("9066.15"), dividendTax.getdividendTaxAmountYearly());
        Assert.assertEquals(new BigDecimal("48561.23"), dividendTax.gettaxableDividendYearly());
        //Tax for each person
        Assert.assertEquals(new BigDecimal("39495.08"), dividendTax.getdividendAfterTaxYearly());
    }

    @Test
    public void testDividendBaseRateTaxAfterTaxedIncomeMonthly() {

        unit = new DividendTax(2, new BigDecimal("39922.46"));

        DividendTaxBreakdown dividendTax = unit.DividendYearlyTaxBreakdown();

        Assert.assertEquals(new BigDecimal("1122.09"), dividendTax.getdividendTaxAmountYearly());
        Assert.assertEquals(new BigDecimal("14961.23"), dividendTax.gettaxableDividendYearly());
        //Tax for each person
        Assert.assertEquals(new BigDecimal("13839.14"), dividendTax.getdividendAfterTaxYearly());
    }

}
