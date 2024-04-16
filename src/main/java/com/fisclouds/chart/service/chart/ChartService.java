package com.fisclouds.chart.service.chart;

import org.springframework.ui.Model;

import com.fisclouds.chart.model.DatasetConfig;

interface ChartService {
	public String load (DatasetConfig datasetConfig,Model model);
}
