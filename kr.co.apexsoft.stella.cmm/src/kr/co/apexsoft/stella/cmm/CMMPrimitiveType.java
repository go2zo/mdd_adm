package kr.co.apexsoft.stella.cmm;

public class CMMPrimitiveType implements CMMType {

	private String name;
	
	public CMMPrimitiveType(final String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
