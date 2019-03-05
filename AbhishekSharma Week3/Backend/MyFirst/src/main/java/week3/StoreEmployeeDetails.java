package week3;
import java.util.List;




public class StoreEmployeeDetails {
	
	String StoreEmployeeId;
	String StoreFirstName;
	String StoreLastName;
	String StoreDesignationId;
	String StoreEmailId;
	String StoreContact;
	String StoreAddressLine1;
	String StoreAddressLine2;
	String StoreCity;
	String StoreCountry;
	
	public List<EmployeeDetails> EmployeeRecords;
	
	public String getStoreEmployeeId() {
		return StoreEmployeeId;
	}
	public void setStoreEmployeeId(String storeEmployeeId) {
		StoreEmployeeId = storeEmployeeId;
	}
	public String getStoreFirstName() {
		return StoreFirstName;
	}
	public void setStoreFirstName(String storeFirstName) {
		StoreFirstName = storeFirstName;
	}
	public String getStoreLastName() {
		return StoreLastName;
	}
	public void setStoreLastName(String storeLastName) {
		StoreLastName = storeLastName;
	}
	public String getStoreDesignationId() {
		return StoreDesignationId;
	}
	public void setStoreDesignationId(String storeDesignationId) {
		StoreDesignationId = storeDesignationId;
	}
	public String getStoreEmailId() {
		return StoreEmailId;
	}
	public void setStoreEmailId(String storeEmailId) {
		StoreEmailId = storeEmailId;
	}
	public String getStoreContact() {
		return StoreContact;
	}
	public void setStoreContact(String storeContact) {
		StoreContact = storeContact;
	}
	public String getStoreAddressLine1() {
		return StoreAddressLine1;
	}
	public void setStoreAddressLine1(String storeAddressLine1) {
		StoreAddressLine1 = storeAddressLine1;
	}
	public String getStoreAddressLine2() {
		return StoreAddressLine2;
	}
	public void setStoreAddressLine2(String storeAddressLine2) {
		StoreAddressLine2 = storeAddressLine2;
	}
	public String getStoreCity() {
		return StoreCity;
	}
	public void setStoreCity(String storeCity) {
		StoreCity = storeCity;
	}
	public String getStoreCountry() {
		return StoreCountry;
	}
	public void setStoreCountry(String storeCountry) {
		StoreCountry = storeCountry;
	}
	
	
	private static StoreEmployeeDetails EmpReg=null;
	public static StoreEmployeeDetails getInstance() {
	
		if(EmpReg==null) {
			EmpReg = new StoreEmployeeDetails();
            return EmpReg;
			
		}
		return EmpReg;
	}
	
	public void add(EmployeeDetails Emp) {
		EmployeeRecords.add(Emp);
	}
	
	}


