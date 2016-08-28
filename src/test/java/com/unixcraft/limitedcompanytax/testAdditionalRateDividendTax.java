package com.unixcraft.limitedcompanytax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */

public class testAdditionalRateDividendTax {

    private DividendTax unit;

    @Before
    public void setUp(){
        unit = new DividendTax(2, new BigDecimal("307563.43"));
    }

    @Test
    public void testDividendAdditionalRateTaxAfterTaxedIncomeMonthly(){

        DividendTaxBreakdown dividendTax = unit.DividendYearlyTaxBreakdown();

        Assert.assertEquals(new BigDecimal("41849.58"), dividendTax.getdividendTaxAmountYearly());
        Assert.assertEquals(new BigDecimal("148781.72"), dividendTax.gettaxableDividendYearly());
        //Tax for each person
        Assert.assertEquals(new BigDecimal("106932.13"), dividendTax.getdividendAfterTaxYearly());


    }


}
