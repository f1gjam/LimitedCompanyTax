package com.unixcraft.limitedcompanytax;

import com.unixcraft.limitedcompanytax.util.TaxStatics;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by kali on 29/08/2016.
 */

public class Main {
    public static void main(String[] args) {
        Integer numberOfShareholders = 2;
        Integer daysWorkedinMonth = 18;
        BigDecimal dailyRate = new BigDecimal(400);


        BigDecimal monthlyIncome = new BusinessIncome(numberOfShareholders, daysWorkedinMonth, dailyRate).CalculateMonthlyIncome();
        BusinessExpenses BE = new BusinessExpenses();
        CorpTaxBreakdown C = new CorporationTax(monthlyIncome, BE.totalExpensesMonthly).calculateCorpTax();

        BigDecimal yearlyIncomeAfterTax = C.getProfitAfterCorpTax().multiply(new BigDecimal("12"));

        DividendTaxBreakdown D = new DividendTax(numberOfShareholders, yearlyIncomeAfterTax).DividendYearlyTaxBreakdown();

        BigDecimal dividendAfterTaxMonthly = D.getdividendAfterTaxYearly().divide(new BigDecimal("12"), 2, RoundingMode.HALF_UP);
        //BigDecimal dividendAfterTaxMonthlyEachShareHolder = dividendAfterTaxMonthly.divide(new BigDecimal(numberOfShareholders));

        BigDecimal dividendTaxAmountMonthly = D.getdividendTaxAmountYearly().divide(new BigDecimal("12"), 2, RoundingMode.HALF_UP);
        //BigDecimal dividendTaxAmountMonthlyEachShareHolder = dividendTaxAmountMonthly.divide(new BigDecimal(numberOfShareholders), 2, RoundingMode.HALF_UP);

        BigDecimal payEachShareHolder = TaxStatics.PAYE_COST.divide(new BigDecimal(numberOfShareholders), 2, RoundingMode.HALF_UP);


        System.out.println("======================================================================");
        System.out.println("Daily Rate: " + dailyRate);
        System.out.println("Number of Shareholders/Employees " + numberOfShareholders);
        System.out.println("Days worked in Month " + daysWorkedinMonth);

        System.out.println("Monthly Income Before Tax: " + monthlyIncome);
        System.out.println("Monthly Expenses Before  : " + BE.totalExpensesMonthly);
        System.out.println("======================================================================");

        System.out.println("----------------------------------------------------------------------");


        System.out.println("Monthly Profit After Tax : " + C.getProfitAfterCorpTax());
        System.out.println("Monthly Corporation Tax : " + C.getCorporationTaxMonthly());


        System.out.println("----------------------------------------------------------------------");


        System.out.println("Pay for each Share Holder : " + payEachShareHolder);
        System.out.println("Dividend each Share Holder : " + dividendAfterTaxMonthly);
        System.out.println("Dividend Tax each Share Holder : " + dividendTaxAmountMonthly);


        System.out.println("----------------------------------------------------------------------");


    }


}