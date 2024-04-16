package com.fisclouds.chart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fisclouds.chart.dto.ChartDataDto;
import com.fisclouds.chart.dto.ResponseData;
import com.fisclouds.chart.service.APIChartService;

@RestController
public class APIChartController {

	@Autowired
	private APIChartService APIChartService;
	
	@PostMapping("/api/v1/chart-data")
	public ResponseData chartData(@RequestBody ChartDataDto chartDataDto) throws JsonProcessingException {
		return APIChartService.chartData(chartDataDto);
	}
}
