package com.unixcraft.limitedcompanytax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */

public class testDividendTax {

    private DividendTax unit;

    @Test
    public void testDividendAdditionalRateTaxAfterTaxedIncomeMonthly(){

        unit = new DividendTax(2, new BigDecimal("307563.43"));

        Assert.assertEquals(new BigDecimal("41849.58"), unit.getDividendTaxAmountYearly());
        Assert.assertEquals(new BigDecimal("148781.72"), unit.getTaxableDividendYearly());
        //Tax for each person
        Assert.assertEquals(new BigDecimal("106932.13"), unit.getDividendAfterTaxYearly());

    }

    @Test
    public void testDividendHighRateTaxAfterTaxedIncomeMonthly(){

        unit = new DividendTax(2, new BigDecimal("107122.46"));

        Assert.assertEquals(new BigDecimal("9066.15"), unit.getDividendTaxAmountYearly());
        Assert.assertEquals(new BigDecimal("48561.23"), unit.getTaxableDividendYearly());
        //Tax for each person
        Assert.assertEquals(new BigDecimal("39495.08"), unit.getDividendAfterTaxYearly());

    }

    @Test
    public void testDividendBaseRateTaxAfterTaxedIncomeMonthly(){

        unit = new DividendTax(2, new BigDecimal("39922.46"));

        Assert.assertEquals(new BigDecimal("1122.09"), unit.getDividendTaxAmountYearly());
        Assert.assertEquals(new BigDecimal("14961.23"), unit.getTaxableDividendYearly());
        //Tax for each person
        Assert.assertEquals(new BigDecimal("13839.14"), unit.getDividendAfterTaxYearly());

    }

}
