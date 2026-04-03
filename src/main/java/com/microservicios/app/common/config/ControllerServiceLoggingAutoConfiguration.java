package com.microservicios.app.common.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class ControllerServiceLoggingAutoConfiguration {

	@Bean
	public ControllerServiceLoggingAspect controllerServiceLoggingAspect() {
		return new ControllerServiceLoggingAspect();
	}
}
