package br.com.webwork.springmobile.response;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@ApiModel(description = "Fields of the object DeviceTypeResponse")
public class DeviceTypeResponse {
	
	private boolean isNormal;

	private boolean isMobile;
	
	private boolean isTablet;
	
	private String platform;
	
}
