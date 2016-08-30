package com.unixcraft.limitedcompanytax;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */
public class PAYEDetails {
    private static BigDecimal grossIncomeYearly = BigDecimal.ZERO;
    private static BigDecimal netIncomeYearly  = BigDecimal.ZERO;
    private static BigDecimal employersNIYearly  = BigDecimal.ZERO;


    public PAYEDetails(BigDecimal grossIncomeYearly, BigDecimal netIncomeYearly, BigDecimal employersNIYearly) {

        this.grossIncomeYearly = grossIncomeYearly;
        this.netIncomeYearly = netIncomeYearly;
        this.employersNIYearly = employersNIYearly;
    }


    //Method needed for UK TX PAYE returning Employee Gross, NET income and Tax details. Also provide Employers NI contribution.
}
