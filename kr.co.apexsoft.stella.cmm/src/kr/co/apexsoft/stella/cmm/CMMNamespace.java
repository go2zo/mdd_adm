package kr.co.apexsoft.stella.cmm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CMMNamespace implements CMMElement {
	private String URI;
	private String[] segments;
	private List<CMMClass> memberClasses;

	public CMMNamespace(String[] segments) {
		this.segments = Arrays.copyOf(segments, segments.length);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < segments.length; i++) {
			sb.append(segments[i]);
			if (i > 0) {
				sb.append(".");
			}
		}
		this.URI = sb.toString();
	}
	
	public CMMNamespace(String uri) {
		this.URI = uri;
		this.segments = uri.split(".");
	}
	
	public String getURI() {
		return URI;
	}

	public void setURI(String uRI) {
		URI = uRI;
	}
	
	public String[] getSegments() {
		return segments;
	}
	
	public List<CMMClass> getClasses() {
		if (memberClasses == null) {
			memberClasses = new ArrayList<CMMClass>();
		}
		return memberClasses;
	}
}
