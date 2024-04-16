package com.fisclouds.chart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fisclouds.chart.service.chart.ChartServiceFactory;

@Controller()
public class ChartController {
	
	@Autowired
	private ChartServiceFactory chartServiceFactory;
	
	@GetMapping("/chart")
	public String greeting(Model model, String id) {
		return chartServiceFactory.getChart(id,model);
	}
	
}
