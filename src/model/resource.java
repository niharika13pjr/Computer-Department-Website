package model;

public class resource {
	private String resourcetype;
	private String resourcedate;
	private int slotID;
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	private int userID;
	public int getSlotID() {
		return slotID;
	}

	public void setSlotID(int slotID) {
		this.slotID = slotID;
	}

	public String getResourcetype() {
		return resourcetype;
	}

	public void setResourcetype(String resourcetype) {
		this.resourcetype = resourcetype;
	}

	public String getResourcedate() {
		return resourcedate;
	}

	public void setResourcedate(String resourcedate) {
		this.resourcedate = resourcedate;
	}

}
