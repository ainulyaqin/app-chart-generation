package com.fisclouds.chart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisclouds.chart.service.chart.ChartServiceFactory;

@RestController
public class ChartController {
	
	@Autowired
	private ChartServiceFactory chartServiceFactory;
	
	
	@GetMapping(value="/data/chart",produces = MediaType.TEXT_HTML_VALUE)
	public String renderHtml(Model model, String id) {
		return chartServiceFactory.getChart(id,model);
	}
	
}
