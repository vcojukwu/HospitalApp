/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModel;

import java.util.HashMap;

/**
 *
 * @author TheKey
 */
public class RevenueVM {
    private int VisitCount; 
    private int VisitRevenue;
    private int TotalProcedureRevenue;
    private int TotalRevenue;
    public RevenueVM ()
    {
        VisitCount = 0;
        VisitRevenue = 0;
        TotalProcedureRevenue = 0;
        TotalRevenue = TotalProcedureRevenue + VisitRevenue;
    }
    public int getVisitCount() {
        return VisitCount;
    }

    public void setVisitCount(int VisitCount) {
        this.VisitCount = VisitCount;
    }

    public int getVisitRevenue() {
        return VisitRevenue;
    }

    public void setVisitRevenue(int VisitRevenue) {
        this.VisitRevenue = VisitRevenue;
    }

    public int getTotalProcedureRevenue() {
        return TotalProcedureRevenue;
    }

    public void setTotalProcedureRevenue(int TotalProcedureRevenue) {
        this.TotalProcedureRevenue = TotalProcedureRevenue;
    }

    public int getTotalRevenue() {
        return TotalRevenue;
    }

    public void setTotalRevenue() {
        this.TotalRevenue = this.TotalProcedureRevenue + this.VisitRevenue;
    }
}
