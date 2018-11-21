package br.com.webwork.springmobile.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.webwork.springmobile.response.DeviceTypeResponse;
import br.com.webwork.springmobile.service.DeviceModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/devices")
@Api(value = "/devices", produces = APPLICATION_JSON_VALUE, tags = {"Device"}, description = "Operations to verify the type of a device.")
public class DeviceController {
	
	@Autowired
	private DeviceModel service;
	
	@GetMapping
	@ApiOperation(value = "Verify the type of a device", notes = "Resource to verify the type of a device", response = DeviceTypeResponse.class)
    @ApiResponses({
    		@ApiResponse(code = 200, message = "OK."),
            @ApiResponse(code = 401, message = "Unauthorized."),
            @ApiResponse(code = 403, message = "Forbidden."),
            @ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<DeviceTypeResponse> verify(Device device) {
		 return this.service.verifyTypeDevice(device);
	}
}
