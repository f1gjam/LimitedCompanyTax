package com.unixcraft.limitedcompanytax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */

public class testBaseRateDividendTax {

    private DividendTax unit;

    @Before
    public void setUp(){
        unit = new DividendTax();
    }

    @Test
    public void testDividendBaseRateTaxAfterTaxedIncomeMonthly(){

        DividendTaxBreakdown dividendTax = unit.DividendTaxTotal(2, new BigDecimal("39922.46"));

        Assert.assertEquals(new BigDecimal("1122.09"), dividendTax.getdividendTaxAmountYearly());
        Assert.assertEquals(new BigDecimal("14961.23"), dividendTax.gettaxableDividendYearly());
        //Tax for each person
        Assert.assertEquals(new BigDecimal("13839.14"), dividendTax.getdividendAfterTaxYearly());


    }


}
