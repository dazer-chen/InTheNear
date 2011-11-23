package hfoster.android.inthenear.resources;

public enum ITNTrueFalse {

	TRUE("true"),
	FALSE("false");
	
	ITNTrueFalse(String status) {
		this.status = status;
	}
	
	private String status;
	
	public String getStatus() {
		return status;
	}
}
