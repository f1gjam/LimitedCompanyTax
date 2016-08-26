package com.unixcraft.limitedcompanytax;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */
public class DividendTax {

    private BigDecimal baseRate = new BigDecimal("7.5");
    private BigDecimal higherRate = new BigDecimal("32.5");
    private BigDecimal additionalRate = new BigDecimal("38.1");

    private BigDecimal yearlyDividendAllowance = new BigDecimal("5000");

    private BigDecimal startBaseRateBand = yearlyDividendAllowance;
    private BigDecimal endOfBaseRateBand = new BigDecimal("31865");

    private BigDecimal startHigherRateBand = new BigDecimal("31866");
    private BigDecimal endOfHigherRateBand = new BigDecimal("150000");

    private BigDecimal startAdditionalRateBand = new BigDecimal("150001");
    private BigDecimal endOfAdditionalRateBand = new BigDecimal("99999999");


    private BigDecimal baseRateMaxTaxable = endOfBaseRateBand.subtract(startBaseRateBand);
    private BigDecimal highRateMaxTaxable = (endOfHigherRateBand.subtract(startHigherRateBand)).add(new BigDecimal("1"));
    private BigDecimal additionalRateMaxTaxable = (endOfAdditionalRateBand.subtract(startAdditionalRateBand)).add(new BigDecimal("1"));


    public DividendTaxBreakdown DividendTaxTotal(Integer numberOfShareholders, BigDecimal monthlyProfitAfterCorpTax) {

        DividendTaxBreakdown DividendYearlyTaxBreakdown = DividendYearlyTaxBreakdown(numberOfShareholders, monthlyProfitAfterCorpTax);


        return DividendYearlyTaxBreakdown;

    }

    public DividendTaxBreakdown DividendYearlyTaxBreakdown(Integer numberOfShareholders, BigDecimal yearlyProfitAfterCorpTax) {
        BigDecimal baseRateTaxAmount;
        BigDecimal highRateTaxAmount;
        BigDecimal additionalRateTaxAmount;

        DividendTaxBreakdown D = null;

        BigDecimal grossDividendYearly;

        BigDecimal dividendAllowanceYearly;

        BigDecimal taxableDividendYearly;


        BigDecimal aboveEndOfBaseRateBand;


        BigDecimal aboveAdditionalRate;

       // Ensure the number of users is part of the return results object!!!
        grossDividendYearly = yearlyProfitAfterCorpTax;

        BigDecimal perShareHolder = grossDividendYearly.divide(new BigDecimal(numberOfShareholders));

        taxableDividendYearly = perShareHolder.subtract(startBaseRateBand);


        if (taxableDividendYearly.compareTo(baseRateMaxTaxable) <= 0) {

            baseRateTaxAmount = baseRateTax(taxableDividendYearly);

            D = new DividendTaxBreakdown(baseRateTaxAmount, taxableDividendYearly);
        }

        if (taxableDividendYearly.compareTo(baseRateMaxTaxable) > 0 && taxableDividendYearly.compareTo(endOfHigherRateBand) <= 0) {
            aboveEndOfBaseRateBand = taxableDividendYearly.subtract(baseRateMaxTaxable);
            baseRateTaxAmount = baseRateTax(baseRateMaxTaxable);
            highRateTaxAmount = highRateTax(aboveEndOfBaseRateBand);

            D = new DividendTaxBreakdown(baseRateTaxAmount, highRateTaxAmount, taxableDividendYearly);
        }

        if (taxableDividendYearly.add(startBaseRateBand).compareTo(startAdditionalRateBand) >= 0) {
            aboveAdditionalRate = taxableDividendYearly.subtract(baseRateMaxTaxable.add(highRateMaxTaxable));

            baseRateTaxAmount = baseRateTax(baseRateMaxTaxable);
            highRateTaxAmount = highRateTax(highRateMaxTaxable);
            additionalRateTaxAmount = additionalRateTax(aboveAdditionalRate);

            D = new DividendTaxBreakdown(baseRateTaxAmount, highRateTaxAmount, additionalRateTaxAmount, taxableDividendYearly);

        }
        
        return D;
    }

    public BigDecimal baseRateTax(BigDecimal baseTaxableDividendYearly) {
        BigDecimal baseRateTaxAmount;
        baseRateTaxAmount = baseTaxableDividendYearly.divide(new BigDecimal("100")).multiply(baseRate);
        return baseRateTaxAmount;
    }

    public BigDecimal highRateTax(BigDecimal HigherTaxableDividendYearly) {
        BigDecimal highRateTaxAmount;
        highRateTaxAmount = HigherTaxableDividendYearly.divide(new BigDecimal("100")).multiply(higherRate);
        return highRateTaxAmount;
    }

    public BigDecimal additionalRateTax(BigDecimal additionlTaxableDividendYearly) {
        BigDecimal additionalRateTaxAmount;
        additionalRateTaxAmount = additionlTaxableDividendYearly.divide(new BigDecimal("100")).multiply(additionalRate);
        return additionalRateTaxAmount;
    }
}

