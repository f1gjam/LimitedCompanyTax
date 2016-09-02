package com.unixcraft.limitedcompanytax;

import com.unixcraft.limitedcompanytax.util.TaxStatics;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */
public class DividendTax {

    private final BigDecimal baseRateMaxTaxable = TaxStatics.END_OF_BASE_RATE_BAND.subtract(TaxStatics.START_BASE_RATE_BAND);
    private final BigDecimal highRateMaxTaxable = (TaxStatics.END_OF_HIGHER_RATE_BAND.subtract(TaxStatics.START_HIGHER_RATE_BAND)).add(new BigDecimal("1"));
    private BigDecimal additionalRateMaxTaxable = (TaxStatics.END_OF_ADDITIONAL_RATE_BAND.subtract(TaxStatics.START_ADDITIONAL_RATE_BAND)).add(new BigDecimal("1"));
    private Integer numberOfShareholders;
    private BigDecimal yearlyProfitAfterCorpTax;

    private  BigDecimal dividendTaxAmountYearly = BigDecimal.ZERO;
    private  BigDecimal taxableDividendYearly = BigDecimal.ZERO;
    private  BigDecimal dividendAfterTaxYearly = BigDecimal.ZERO;

    public DividendTax(Integer numberOfShareholders, BigDecimal yearlyProfitAfterCorpTax) {
        this.numberOfShareholders = numberOfShareholders;
        this.yearlyProfitAfterCorpTax = yearlyProfitAfterCorpTax;
        DividendYearlyTaxBreakdown();
    }

    public void DividendYearlyTaxBreakdown() {

        BigDecimal baseRateTaxAmount;
        BigDecimal highRateTaxAmount;
        BigDecimal additionalRateTaxAmount;
        BigDecimal aboveEndOfBaseRateBand;
        BigDecimal aboveAdditionalRate;

       // Ensure the number of users is part of the return results object!!!
        taxableDividendYearly = yearlyProfitAfterCorpTax.divide(new BigDecimal(numberOfShareholders))
                .subtract(TaxStatics.START_BASE_RATE_BAND);

        if (taxableDividendYearly.compareTo(baseRateMaxTaxable) <= 0) {

            dividendTaxAmountYearly = getRateTax(TaxStatics.BASE_RATE, taxableDividendYearly);
            dividendAfterTaxYearly = subtractDividendTaxAmountYearly();
        }

        if (taxableDividendYearly.compareTo(baseRateMaxTaxable) > 0 && taxableDividendYearly.compareTo(TaxStatics.END_OF_HIGHER_RATE_BAND) <= 0) {
            aboveEndOfBaseRateBand = taxableDividendYearly.subtract(baseRateMaxTaxable);
            baseRateTaxAmount = getRateTax(TaxStatics.BASE_RATE, baseRateMaxTaxable);
            highRateTaxAmount = getRateTax(TaxStatics.HIGHER_RATE, aboveEndOfBaseRateBand);

            dividendTaxAmountYearly = baseRateTaxAmount.add(highRateTaxAmount);
            dividendAfterTaxYearly = subtractDividendTaxAmountYearly();

        }

        if (taxableDividendYearly.add(TaxStatics.START_BASE_RATE_BAND).compareTo(TaxStatics.START_ADDITIONAL_RATE_BAND) >= 0) {
            aboveAdditionalRate = taxableDividendYearly.subtract(baseRateMaxTaxable.add(highRateMaxTaxable));

            baseRateTaxAmount = getRateTax(TaxStatics.BASE_RATE, baseRateMaxTaxable);
            highRateTaxAmount = getRateTax(TaxStatics.HIGHER_RATE, highRateMaxTaxable);
            additionalRateTaxAmount = getRateTax(TaxStatics.ADDITIONAL_RATE, aboveAdditionalRate);

            dividendTaxAmountYearly = baseRateTaxAmount.add(highRateTaxAmount).add(additionalRateTaxAmount);
            dividendAfterTaxYearly = subtractDividendTaxAmountYearly();
        }
    }

    private BigDecimal subtractDividendTaxAmountYearly() {
        return taxableDividendYearly.subtract(dividendTaxAmountYearly);
    }

    private BigDecimal getRateTax(BigDecimal rate, BigDecimal taxableDividend) {
        return taxableDividend.divide(new BigDecimal("100")).multiply(rate);
    }

    public BigDecimal getDividendTaxAmountYearly() {
        return dividendTaxAmountYearly.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getTaxableDividendYearly() {
        return taxableDividendYearly.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getDividendAfterTaxYearly() {
        return dividendAfterTaxYearly.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

}

