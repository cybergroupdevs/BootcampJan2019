package week3;

@Entity
public class Designation {
	String ID;
    String Name;
    
    public Designation(String ID, String Name) {
		this.setID(ID);
		this.setName(Name);
	}
    public Designation( String Name) {
		this.setName(Name);
	}
    
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

}
