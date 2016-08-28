package com.unixcraft.limitedcompanytax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */

public class testHighRateDividendTax {

    private DividendTax unit;

    @Before
    public void setUp(){
        unit = new DividendTax(2, new BigDecimal("107122.46"));
    }

    @Test
    public void testDividendHighRateTaxAfterTaxedIncomeMonthly(){

        DividendTaxBreakdown dividendTax = unit.DividendYearlyTaxBreakdown();

        Assert.assertEquals(new BigDecimal("9066.15"), dividendTax.getdividendTaxAmountYearly());
        Assert.assertEquals(new BigDecimal("48561.23"), dividendTax.gettaxableDividendYearly());
        //Tax for each person
        Assert.assertEquals(new BigDecimal("39495.08"), dividendTax.getdividendAfterTaxYearly());

    }


}
