package phoneNumbers;

public class Model {
    private String name, home, cell;
    
    public Model(String newName, String newHome, String newCell) {
        this.name = newName;
        this.home = newHome;
        this.cell = newCell;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getHome() {
        return this.home;
    }

    public void setHome(String newHome) {
        this.home = newHome;
    }

    public String getCell() {
        return this.cell;
    }

    public void setCell(String newCell) {
        this.cell = newCell;
    }
}