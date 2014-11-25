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
    private double VisitRevenue;
    private double TotalProcedureRevenue;

    public RevenueVM ()
    {
        VisitCount = 0;
        VisitRevenue = 0;
        TotalProcedureRevenue = 0;
    }
    public int getVisitCount() {
        return VisitCount;
    }

    public void setVisitCount(int VisitCount) {
        this.VisitCount = VisitCount;
    }

    public double getVisitRevenue() {
        return VisitRevenue;
    }

    public void setVisitRevenue(double VisitRevenue) {
        this.VisitRevenue = VisitRevenue;
    }

    public double getTotalProcedureRevenue() {
        return TotalProcedureRevenue;
    }

    public void setTotalProcedureRevenue(double TotalProcedureRevenue) {
        this.TotalProcedureRevenue = TotalProcedureRevenue;
    }
}
