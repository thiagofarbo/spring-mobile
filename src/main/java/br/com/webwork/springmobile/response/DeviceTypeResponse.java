package br.com.webwork.springmobile.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DeviceTypeResponse {
	
	private boolean isNormal;

	private boolean isMobile;
	
	private boolean isTablet;
	
	private String platform;
	
}
