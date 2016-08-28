package com.unixcraft.limitedcompanytax;

import com.unixcraft.limitedcompanytax.util.TaxStatics;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */

public class testCorparationTax {

    private CorporationTax unit;

    @Before
    public void setUp(){
        unit = new CorporationTax(new BigDecimal("7000"), TaxStatics.TOTAL_EXPENSES_MONTHLY);
    }

    @Test
    public void testProfitAfterTaxForBusinessIncomeMonthlyOf7000(){

        CorpTaxBreakdown corpTaxBreakdown = unit.calculateCorpTax();

        Assert.assertEquals(new BigDecimal("831.72"), corpTaxBreakdown.getCorporationTaxMonthly());
        Assert.assertEquals(new BigDecimal("3326.87"), corpTaxBreakdown.getProfitAfterCorpTax());
    }


}
