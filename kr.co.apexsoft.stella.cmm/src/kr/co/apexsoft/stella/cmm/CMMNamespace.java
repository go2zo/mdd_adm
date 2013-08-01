package kr.co.apexsoft.stella.cmm;

import java.util.Arrays;

public class CMMNamespace implements CMMElement {
	
	public final static String SEPERATOR = ".";
	
	private String URI;
	private String[] segments;

	public CMMNamespace() {
		
	}
	
	public CMMNamespace(final String[] segments) {
		this.segments = Arrays.copyOf(segments, segments.length);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < segments.length; i++) {
			sb.append(segments[i]);
			if (i > 0) {
				sb.append(SEPERATOR);
			}
		}
		this.URI = sb.toString();
	}
	
	public CMMNamespace(final String uri) {
		this(uri, null);
	}
	
	public CMMNamespace(final String uri, final String seperator) {
		if (SEPERATOR.equals(seperator)) {
			this.URI = uri;
			this.segments = uri.split(SEPERATOR);
		} else {
			this.URI = uri.replaceAll(seperator, SEPERATOR);
			this.segments = uri.split(seperator);
		}
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
	
	public String seperator() {
		return SEPERATOR;
	}
	
}
