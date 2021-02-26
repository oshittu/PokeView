package Model;

public class ListItem
{
    private String pName;
    private String pType;

    public ListItem(String pName, String pType)
    {
        this.pName=pName;
        this.pType=pType;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String name) {
        this.pName = pName;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }
}