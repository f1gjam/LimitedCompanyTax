package com.unixcraft.limitedcompanytax;

import com.unixcraft.limitedcompanytax.util.TaxStatics;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by kali on 29/08/2016.
 */

public class Main {
    public static void main(String[] args) {

        BigDecimal monthlyIncome = TaxStatics.DAILY_RATE.multiply(new BigDecimal(TaxStatics.DAYS_WORKED_IN_MONTH));

        CorporationTax corpTax = new CorporationTax(monthlyIncome, TaxStatics.TOTAL_EXPENSES_MONTHLY);

        BigDecimal yearlyIncomeAfterTax = corpTax.getProfitAfterCorpTax().multiply(new BigDecimal("12"));

        DividendTax dividendTax = new DividendTax(TaxStatics.NUMBER_OF_SHAREHOLDERS, yearlyIncomeAfterTax);

        BigDecimal dividendAfterTaxMonthly = dividendTax.getDividendAfterTaxYearly().divide(new BigDecimal("12"), 2, RoundingMode.HALF_UP);
        //BigDecimal dividendAfterTaxMonthlyEachShareHolder = dividendAfterTaxMonthly.divide(new BigDecimal(numberOfShareholders));

        BigDecimal dividendTaxAmountMonthly = dividendTax.getDividendTaxAmountYearly().divide(new BigDecimal("12"), 2, RoundingMode.HALF_UP);
        //BigDecimal dividendTaxAmountMonthlyEachShareHolder = dividendTaxAmountMonthly.divide(new BigDecimal(numberOfShareholders), 2, RoundingMode.HALF_UP);

        BigDecimal payEachShareHolder = TaxStatics.PAYE_COST.divide(new BigDecimal(TaxStatics.NUMBER_OF_SHAREHOLDERS), 2, RoundingMode.HALF_UP);


        System.out.println("======================================================================");
        System.out.println("Daily Rate: " + TaxStatics.DAILY_RATE);
        System.out.println("Number of Shareholders/Employees " + TaxStatics.NUMBER_OF_SHAREHOLDERS);
        System.out.println("Days worked in Month " + TaxStatics.DAYS_WORKED_IN_MONTH);

        System.out.println("Monthly Income Before Tax: " + monthlyIncome);
        System.out.println("Monthly Expenses Before  : " + TaxStatics.TOTAL_EXPENSES_MONTHLY);
        System.out.println("======================================================================");

        System.out.println("----------------------------------------------------------------------");

        System.out.println("Monthly Profit After Tax : " + corpTax.getProfitAfterCorpTax());
        System.out.println("Monthly Corporation Tax : " + corpTax.getCorporationTaxMonthly());

        System.out.println("----------------------------------------------------------------------");

        System.out.println("Pay for each Share Holder : " + payEachShareHolder);
        System.out.println("Dividend each Share Holder : " + dividendAfterTaxMonthly);
        System.out.println("Dividend Tax each Share Holder : " + dividendTaxAmountMonthly);

        System.out.println("----------------------------------------------------------------------");


    }


}