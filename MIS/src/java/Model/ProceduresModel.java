
package Model;

public class ProceduresModel {
    private int ProcedureId;
    private String ProcedureType;
    private String ProcedureName;
    private int ProcedureCost;

    public int getProcedureId() {
        return ProcedureId;
    }

    public void setProcedureId(int ProcedureId) {
        this.ProcedureId = ProcedureId;
    }

    public String getProcedureType() {
        return ProcedureType;
    }

    public void setProcedureType(String ProcedureType) {
        this.ProcedureType = ProcedureType;
    }

    public String getProcedureName() {
        return ProcedureName;
    }

    public void setProcedureName(String ProcedureName) {
        this.ProcedureName = ProcedureName;
    }

    public int getProcedureCost() {
        return ProcedureCost;
    }

    public void setProcedureCost(int ProcedureCost) {
        this.ProcedureCost = ProcedureCost;
    }
}
