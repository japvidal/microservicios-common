package com.microservicios.app.common.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ControllerServiceLoggingAspect {

	@Before("execution(* com.microservicios.app..controllers..*(..)) || execution(* com.microservicios.app..services..*ServiceImpl.*(..))")
	public void logMethodInit(JoinPoint joinPoint) {
		Class<?> targetClass = joinPoint.getTarget() != null
				? joinPoint.getTarget().getClass()
				: joinPoint.getSignature().getDeclaringType();
		Logger logger = LoggerFactory.getLogger(targetClass);
		logger.info("Init method {}.{}", targetClass.getSimpleName(), joinPoint.getSignature().getName());
	}
}
