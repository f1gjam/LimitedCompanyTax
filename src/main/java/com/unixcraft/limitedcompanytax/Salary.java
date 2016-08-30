package com.unixcraft.limitedcompanytax;

/**
 * Created by kali on 21/08/2016.
 */
// Probably can kill this as PAYE will be used instead

public class Salary {
    private double grossYearlySalary = 15000;
    private double netYearlySalary;
    private double employersYearlyNI;
    private double grossMonthlySalary = 15000;
    private double netMonthlySalary;
    private double employersMonthlyNI;

    public double getGrossYearlySalary() {
        return grossYearlySalary;
    }

    public void setGrossYearlySalary(double grossYearlySalary) {
        this.grossYearlySalary = grossYearlySalary;
    }

    public double getNetYearlySalary() {
        return netYearlySalary;
    }

    public void setNetYearlySalary(double netYearlySalary) {
        this.netYearlySalary = netYearlySalary;
    }

    public double getEmployersYearlyNI() {
        return employersYearlyNI;
    }

    public void setEmployersYearlyNI(double employersYearlyNI) {
        this.employersYearlyNI = employersYearlyNI;
    }

    public double getGrossMonthlySalary() {
        return grossMonthlySalary;
    }

    public void setGrossMonthlySalary(double grossMonthlySalary) {
        this.grossMonthlySalary = grossMonthlySalary;
    }

    public double getNetMonthlySalary() {
        return netMonthlySalary;
    }

    public void setNetMonthlySalary(double netMonthlySalary) {
        this.netMonthlySalary = netMonthlySalary;
    }

    public double getEmployersMonthlyNI() {
        return employersMonthlyNI;
    }

    public void setEmployersMonthlyNI(double employersMonthlyNI) {
        this.employersMonthlyNI = employersMonthlyNI;
    }
}
