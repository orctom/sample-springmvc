package com.orctom.sample.springmvc.spring;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.orctom.sample.springmvc.exception.LogicException;

public class HandlerLogicExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		String referrer = null;
		if (ex instanceof LogicException && (null != (referrer = request.getHeader("Referer")))) {
			if (null != referrer) {				
				return redirectToReferrer(request, ex, referrer);
			}
		}
		
		return errorPage(ex);
	}

	private ModelAndView errorPage(Exception ex) {
		ModelAndView mav = new ModelAndView("500");
		mav.addObject("message", ex.getMessage());
		return mav;
	}

	private ModelAndView redirectToReferrer(HttpServletRequest request, Exception ex, String referrer) {
		Map<String, Object> flashMap = RequestContextUtils.getOutputFlashMap(request);
		if (flashMap != null) {
			flashMap.put("message", ex.getMessage());
		}
		return new ModelAndView("redirect:" + referrer);
	}
}
