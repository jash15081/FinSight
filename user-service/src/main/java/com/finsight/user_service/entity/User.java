package com.finsight.user_service.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "user_table")
public class User {

    @Id
    @Column(name = "cust_id")
    private Long custId;

    @Column(name = "credit_score")
    private Double creditScore;

    @Column(name = "default_status")
    private Integer defaultStatus;

    @Column(name = "income")
    private Double income;

    @Column(name = "savings")
    private Double savings;

    @Column(name = "debt")
    private Double debt;

    @Column(name = "r_savings_income")
    private Double rSavingsIncome;

    @Column(name = "r_debt_income")
    private Double rDebtIncome;

    @Column(name = "r_debt_savings")
    private Double rDebtSavings;

    @Column(name = "t_groceries_6")
    private Double tGroceries6;

    @Column(name = "t_groceries_12")
    private Double tGroceries12;

    @Column(name = "r_groceries")
    private Double rGroceries;

    @Column(name = "r_groceries_income")
    private Double rGroceriesIncome;

    @Column(name = "r_groceries_savings")
    private Double rGroceriesSavings;

    @Column(name = "r_groceries_debt")
    private Double rGroceriesDebt;

    @Column(name = "t_clothing_6")
    private Double tClothing6;

    @Column(name = "t_clothing_12")
    private Double tClothing12;

    @Column(name = "r_clothing")
    private Double rClothing;

    @Column(name = "r_clothing_income")
    private Double rClothingIncome;

    @Column(name = "r_clothing_savings")
    private Double rClothingSavings;

    @Column(name = "r_clothing_debt")
    private Double rClothingDebt;

    @Column(name = "t_housing_6")
    private Double tHousing6;

    @Column(name = "t_housing_12")
    private Double tHousing12;

    @Column(name = "r_housing")
    private Double rHousing;

    @Column(name = "r_housing_income")
    private Double rHousingIncome;

    @Column(name = "r_housing_savings")
    private Double rHousingSavings;

    @Column(name = "r_housing_debt")
    private Double rHousingDebt;

    @Column(name = "t_education_6")
    private Double tEducation6;

    @Column(name = "t_education_12")
    private Double tEducation12;

    @Column(name = "r_education")
    private Double rEducation;

    @Column(name = "r_education_income")
    private Double rEducationIncome;

    @Column(name = "r_education_savings")
    private Double rEducationSavings;

    @Column(name = "r_education_debt")
    private Double rEducationDebt;

    @Column(name = "t_health_6")
    private Double tHealth6;

    @Column(name = "t_health_12")
    private Double tHealth12;

    @Column(name = "r_health")
    private Double rHealth;

    @Column(name = "r_health_income")
    private Double rHealthIncome;

    @Column(name = "r_health_savings")
    private Double rHealthSavings;

    @Column(name = "r_health_debt")
    private Double rHealthDebt;

    @Column(name = "t_travel_6")
    private Double tTravel6;

    @Column(name = "t_travel_12")
    private Double tTravel12;

    @Column(name = "r_travel")
    private Double rTravel;

    @Column(name = "r_travel_income")
    private Double rTravelIncome;

    @Column(name = "r_travel_savings")
    private Double rTravelSavings;

    @Column(name = "r_travel_debt")
    private Double rTravelDebt;

    @Column(name = "t_entertainment_6")
    private Double tEntertainment6;

    @Column(name = "t_entertainment_12")
    private Double tEntertainment12;

    @Column(name = "r_entertainment")
    private Double rEntertainment;

    @Column(name = "r_entertainment_income")
    private Double rEntertainmentIncome;

    @Column(name = "r_entertainment_savings")
    private Double rEntertainmentSavings;

    @Column(name = "r_entertainment_debt")
    private Double rEntertainmentDebt;

    @Column(name = "t_gambling_6")
    private Double tGambling6;

    @Column(name = "t_gambling_12")
    private Double tGambling12;

    @Column(name = "r_gambling")
    private Double rGambling;

    @Column(name = "r_gambling_income")
    private Double rGamblingIncome;

    @Column(name = "r_gambling_savings")
    private Double rGamblingSavings;

    @Column(name = "r_gambling_debt")
    private Double rGamblingDebt;

    @Column(name = "t_utilities_6")
    private Double tUtilities6;

    @Column(name = "t_utilities_12")
    private Double tUtilities12;

    @Column(name = "r_utilities")
    private Double rUtilities;

    @Column(name = "r_utilities_income")
    private Double rUtilitiesIncome;

    @Column(name = "r_utilities_savings")
    private Double rUtilitiesSavings;

    @Column(name = "r_utilities_debt")
    private Double rUtilitiesDebt;

    @Column(name = "t_tax_6")
    private Double tTax6;

    @Column(name = "t_tax_12")
    private Double tTax12;

    @Column(name = "r_tax")
    private Double rTax;

    @Column(name = "r_tax_income")
    private Double rTaxIncome;

    @Column(name = "r_tax_savings")
    private Double rTaxSavings;

    @Column(name = "r_tax_debt")
    private Double rTaxDebt;

    @Column(name = "t_fines_6")
    private Double tFines6;

    @Column(name = "t_fines_12")
    private Double tFines12;

    @Column(name = "r_fines")
    private Double rFines;

    @Column(name = "r_fines_income")
    private Double rFinesIncome;

    @Column(name = "r_fines_savings")
    private Double rFinesSavings;

    @Column(name = "r_fines_debt")
    private Double rFinesDebt;

    // Categorical Features
    @Column(name = "cat_gambling")
    private String catGambling;

    @Column(name = "cat_debt")
    private Boolean catDebt;

    @Column(name = "cat_credit_card")
    private Boolean catCreditCard;

    @Column(name = "cat_mortgage")
    private Boolean catMortgage;

    @Column(name = "cat_savings_account")
    private Boolean catSavingsAccount;

    @Column(name = "cat_dependents")
    private Boolean catDependents;

    // Getters and Setters

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public Double getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Double creditScore) {
        this.creditScore = creditScore;
    }

    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getSavings() {
        return savings;
    }

    public void setSavings(Double savings) {
        this.savings = savings;
    }

    public Double getDebt() {
        return debt;
    }

    public void setDebt(Double debt) {
        this.debt = debt;
    }

    public Double getrSavingsIncome() {
        return rSavingsIncome;
    }

    public void setrSavingsIncome(Double rSavingsIncome) {
        this.rSavingsIncome = rSavingsIncome;
    }

    public Double getrDebtIncome() {
        return rDebtIncome;
    }

    public void setrDebtIncome(Double rDebtIncome) {
        this.rDebtIncome = rDebtIncome;
    }

    public Double getrDebtSavings() {
        return rDebtSavings;
    }

    public void setrDebtSavings(Double rDebtSavings) {
        this.rDebtSavings = rDebtSavings;
    }

    public Double gettGroceries6() {
        return tGroceries6;
    }

    public void settGroceries6(Double tGroceries6) {
        this.tGroceries6 = tGroceries6;
    }

    public Double gettGroceries12() {
        return tGroceries12;
    }

    public void settGroceries12(Double tGroceries12) {
        this.tGroceries12 = tGroceries12;
    }

    public Double getrGroceries() {
        return rGroceries;
    }

    public void setrGroceries(Double rGroceries) {
        this.rGroceries = rGroceries;
    }

    public Double getrGroceriesIncome() {
        return rGroceriesIncome;
    }

    public void setrGroceriesIncome(Double rGroceriesIncome) {
        this.rGroceriesIncome = rGroceriesIncome;
    }

    public Double getrGroceriesSavings() {
        return rGroceriesSavings;
    }

    public void setrGroceriesSavings(Double rGroceriesSavings) {
        this.rGroceriesSavings = rGroceriesSavings;
    }

    public Double getrGroceriesDebt() {
        return rGroceriesDebt;
    }

    public void setrGroceriesDebt(Double rGroceriesDebt) {
        this.rGroceriesDebt = rGroceriesDebt;
    }

    // Setters and getters for the rest of the fields

    public Double gettClothing6() {
        return tClothing6;
    }

    public void settClothing6(Double tClothing6) {
        this.tClothing6 = tClothing6;
    }

    public Double gettClothing12() {
        return tClothing12;
    }

    public void settClothing12(Double tClothing12) {
        this.tClothing12 = tClothing12;
    }

    public Double getrClothing() {
        return rClothing;
    }

    public void setrClothing(Double rClothing) {
        this.rClothing = rClothing;
    }

    public Double getrClothingIncome() {
        return rClothingIncome;
    }

    public void setrClothingIncome(Double rClothingIncome) {
        this.rClothingIncome = rClothingIncome;
    }

    public Double getrClothingSavings() {
        return rClothingSavings;
    }

    public void setrClothingSavings(Double rClothingSavings) {
        this.rClothingSavings = rClothingSavings;
    }

    public Double getrClothingDebt() {
        return rClothingDebt;
    }

    public void setrClothingDebt(Double rClothingDebt) {
        this.rClothingDebt = rClothingDebt;
    }

    public Double gettHousing6() {
        return tHousing6;
    }

    public void settHousing6(Double tHousing6) {
        this.tHousing6 = tHousing6;
    }

    public Double gettHousing12() {
        return tHousing12;
    }

    public void settHousing12(Double tHousing12) {
        this.tHousing12 = tHousing12;
    }

    public Double getrHousing() {
        return rHousing;
    }

    public void setrHousing(Double rHousing) {
        this.rHousing = rHousing;
    }

    public Double getrHousingIncome() {
        return rHousingIncome;
    }

    public void setrHousingIncome(Double rHousingIncome) {
        this.rHousingIncome = rHousingIncome;
    }

    public Double getrHousingSavings() {
        return rHousingSavings;
    }

    public void setrHousingSavings(Double rHousingSavings) {
        this.rHousingSavings = rHousingSavings;
    }

    public Double getrHousingDebt() {
        return rHousingDebt;
    }

    public void setrHousingDebt(Double rHousingDebt) {
        this.rHousingDebt = rHousingDebt;
    }

    public Double gettEducation6() {
        return tEducation6;
    }

    public void settEducation6(Double tEducation6) {
        this.tEducation6 = tEducation6;
    }

    public Double gettEducation12() {
        return tEducation12;
    }

    public void settEducation12(Double tEducation12) {
        this.tEducation12 = tEducation12;
    }

    public Double getrEducation() {
        return rEducation;
    }

    public void setrEducation(Double rEducation) {
        this.rEducation = rEducation;
    }

    public Double getrEducationIncome() {
        return rEducationIncome;
    }

    public void setrEducationIncome(Double rEducationIncome) {
        this.rEducationIncome = rEducationIncome;
    }

    public Double getrEducationSavings() {
        return rEducationSavings;
    }

    public void setrEducationSavings(Double rEducationSavings) {
        this.rEducationSavings = rEducationSavings;
    }

    public Double getrEducationDebt() {
        return rEducationDebt;
    }

    public void setrEducationDebt(Double rEducationDebt) {
        this.rEducationDebt = rEducationDebt;
    }

    public Double gettHealth6() {
        return tHealth6;
    }

    public void settHealth6(Double tHealth6) {
        this.tHealth6 = tHealth6;
    }

    public Double gettHealth12() {
        return tHealth12;
    }

    public void settHealth12(Double tHealth12) {
        this.tHealth12 = tHealth12;
    }

    public Double getrHealth() {
        return rHealth;
    }

    public void setrHealth(Double rHealth) {
        this.rHealth = rHealth;
    }

    public Double getrHealthIncome() {
        return rHealthIncome;
    }

    public void setrHealthIncome(Double rHealthIncome) {
        this.rHealthIncome = rHealthIncome;
    }

    public Double getrHealthSavings() {
        return rHealthSavings;
    }

    public void setrHealthSavings(Double rHealthSavings) {
        this.rHealthSavings = rHealthSavings;
    }

    public Double getrHealthDebt() {
        return rHealthDebt;
    }

    public void setrHealthDebt(Double rHealthDebt) {
        this.rHealthDebt = rHealthDebt;
    }

    public Double gettTravel6() {
        return tTravel6;
    }

    public void settTravel6(Double tTravel6) {
        this.tTravel6 = tTravel6;
    }

    public Double gettTravel12() {
        return tTravel12;
    }

    public void settTravel12(Double tTravel12) {
        this.tTravel12 = tTravel12;
    }

    public Double getrTravel() {
        return rTravel;
    }

    public void setrTravel(Double rTravel) {
        this.rTravel = rTravel;
    }

    public Double getrTravelIncome() {
        return rTravelIncome;
    }

    public void setrTravelIncome(Double rTravelIncome) {
        this.rTravelIncome = rTravelIncome;
    }

    public Double getrTravelSavings() {
        return rTravelSavings;
    }

    public void setrTravelSavings(Double rTravelSavings) {
        this.rTravelSavings = rTravelSavings;
    }

    public Double getrTravelDebt() {
        return rTravelDebt;
    }

    public void setrTravelDebt(Double rTravelDebt) {
        this.rTravelDebt = rTravelDebt;
    }

    public Double gettEntertainment6() {
        return tEntertainment6;
    }

    public void settEntertainment6(Double tEntertainment6) {
        this.tEntertainment6 = tEntertainment6;
    }

    public Double gettEntertainment12() {
        return tEntertainment12;
    }

    public void settEntertainment12(Double tEntertainment12) {
        this.tEntertainment12 = tEntertainment12;
    }

    public Double getrEntertainment() {
        return rEntertainment;
    }

    public void setrEntertainment(Double rEntertainment) {
        this.rEntertainment = rEntertainment;
    }

    public Double getrEntertainmentIncome() {
        return rEntertainmentIncome;
    }

    public void setrEntertainmentIncome(Double rEntertainmentIncome) {
        this.rEntertainmentIncome = rEntertainmentIncome;
    }

    public Double getrEntertainmentSavings() {
        return rEntertainmentSavings;
    }

    public void setrEntertainmentSavings(Double rEntertainmentSavings) {
        this.rEntertainmentSavings = rEntertainmentSavings;
    }

    public Double getrEntertainmentDebt() {
        return rEntertainmentDebt;
    }

    public void setrEntertainmentDebt(Double rEntertainmentDebt) {
        this.rEntertainmentDebt = rEntertainmentDebt;
    }

    public Double gettGambling6() {
        return tGambling6;
    }

    public void settGambling6(Double tGambling6) {
        this.tGambling6 = tGambling6;
    }

    public Double gettGambling12() {
        return tGambling12;
    }

    public void settGambling12(Double tGambling12) {
        this.tGambling12 = tGambling12;
    }

    public Double getrGambling() {
        return rGambling;
    }

    public void setrGambling(Double rGambling) {
        this.rGambling = rGambling;
    }

    public Double getrGamblingIncome() {
        return rGamblingIncome;
    }

    public void setrGamblingIncome(Double rGamblingIncome) {
        this.rGamblingIncome = rGamblingIncome;
    }

    public Double getrGamblingSavings() {
        return rGamblingSavings;
    }

    public void setrGamblingSavings(Double rGamblingSavings) {
        this.rGamblingSavings = rGamblingSavings;
    }

    public Double getrGamblingDebt() {
        return rGamblingDebt;
    }

    public void setrGamblingDebt(Double rGamblingDebt) {
        this.rGamblingDebt = rGamblingDebt;
    }

    public Double gettUtilities6() {
        return tUtilities6;
    }

    public void settUtilities6(Double tUtilities6) {
        this.tUtilities6 = tUtilities6;
    }

    public Double gettUtilities12() {
        return tUtilities12;
    }

    public void settUtilities12(Double tUtilities12) {
        this.tUtilities12 = tUtilities12;
    }

    public Double getrUtilities() {
        return rUtilities;
    }

    public void setrUtilities(Double rUtilities) {
        this.rUtilities = rUtilities;
    }

    public Double getrUtilitiesIncome() {
        return rUtilitiesIncome;
    }

    public void setrUtilitiesIncome(Double rUtilitiesIncome) {
        this.rUtilitiesIncome = rUtilitiesIncome;
    }

    public Double getrUtilitiesSavings() {
        return rUtilitiesSavings;
    }

    public void setrUtilitiesSavings(Double rUtilitiesSavings) {
        this.rUtilitiesSavings = rUtilitiesSavings;
    }

    public Double getrUtilitiesDebt() {
        return rUtilitiesDebt;
    }

    public void setrUtilitiesDebt(Double rUtilitiesDebt) {
        this.rUtilitiesDebt = rUtilitiesDebt;
    }

    public Double gettTax6() {
        return tTax6;
    }

    public void settTax6(Double tTax6) {
        this.tTax6 = tTax6;
    }

    public Double gettTax12() {
        return tTax12;
    }

    public void settTax12(Double tTax12) {
        this.tTax12 = tTax12;
    }

    public Double getrTax() {
        return rTax;
    }

    public void setrTax(Double rTax) {
        this.rTax = rTax;
    }

    public Double getrTaxIncome() {
        return rTaxIncome;
    }

    public void setrTaxIncome(Double rTaxIncome) {
        this.rTaxIncome = rTaxIncome;
    }

    public Double getrTaxSavings() {
        return rTaxSavings;
    }

    public void setrTaxSavings(Double rTaxSavings) {
        this.rTaxSavings = rTaxSavings;
    }

    public Double getrTaxDebt() {
        return rTaxDebt;
    }

    public void setrTaxDebt(Double rTaxDebt) {
        this.rTaxDebt = rTaxDebt;
    }

    public Double gettFines6() {
        return tFines6;
    }

    public void settFines6(Double tFines6) {
        this.tFines6 = tFines6;
    }

    public Double gettFines12() {
        return tFines12;
    }

    public void settFines12(Double tFines12) {
        this.tFines12 = tFines12;
    }

    public Double getrFines() {
        return rFines;
    }

    public void setrFines(Double rFines) {
        this.rFines = rFines;
    }

    public Double getrFinesIncome() {
        return rFinesIncome;
    }

    public void setrFinesIncome(Double rFinesIncome) {
        this.rFinesIncome = rFinesIncome;
    }

    public Double getrFinesSavings() {
        return rFinesSavings;
    }

    public void setrFinesSavings(Double rFinesSavings) {
        this.rFinesSavings = rFinesSavings;
    }

    public Double getrFinesDebt() {
        return rFinesDebt;
    }

    public void setrFinesDebt(Double rFinesDebt) {
        this.rFinesDebt = rFinesDebt;
    }

    public String getCatGambling() {
        return catGambling;
    }

    public void setCatGambling(String catGambling) {
        this.catGambling = catGambling;
    }

    public Boolean getCatDebt() {
        return catDebt;
    }

    public void setCatDebt(Boolean catDebt) {
        this.catDebt = catDebt;
    }

    public Boolean getCatCreditCard() {
        return catCreditCard;
    }

    public void setCatCreditCard(Boolean catCreditCard) {
        this.catCreditCard = catCreditCard;
    }

    public Boolean getCatMortgage() {
        return catMortgage;
    }

    public void setCatMortgage(Boolean catMortgage) {
        this.catMortgage = catMortgage;
    }

    public Boolean getCatSavingsAccount() {
        return catSavingsAccount;
    }

    public void setCatSavingsAccount(Boolean catSavingsAccount) {
        this.catSavingsAccount = catSavingsAccount;
    }

    public Boolean getCatDependents() {
        return catDependents;
    }

    public void setCatDependents(Boolean catDependents) {
        this.catDependents = catDependents;
    }
}

