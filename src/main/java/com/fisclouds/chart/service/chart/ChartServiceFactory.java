package com.fisclouds.chart.service.chart;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fisclouds.chart.model.DatasetConfig;
import com.fisclouds.chart.repository.DatasetConfigRepository;

@Service
public class ChartServiceFactory {
	
	private Log log = LogFactory.getLog(ChartServiceFactory.class);
	
	@Autowired
	private DatasetConfigRepository datasetConfigRepository;
	
	@Autowired
	private ChartService barChart; 
	
	@Autowired
	private ChartService pieChart; 
	
	@Autowired
	private ChartService lineChart; 
	
	public String getChart(String id,Model model) {
		
		log.info("incoming request chart id : "+id);
		
		DatasetConfig datasetConfig = datasetConfigRepository.findById(UUID.fromString(id))
		.orElse(null);
		
		if(datasetConfig==null) {
			return "error";
		}else if(datasetConfig.getChartType().equalsIgnoreCase("bar")) {
			
			log.info("incoming request chart type : "+datasetConfig.getChartType());
			
			return barChart.load(datasetConfig,model);
		
		}else if(datasetConfig.getChartType().equalsIgnoreCase("pie")) {
			
			log.info("incoming request chart type : "+datasetConfig.getChartType());
			
			return pieChart.load(datasetConfig,model);
			
		}else if(datasetConfig.getChartType().equalsIgnoreCase("line")) {
			
			log.info("incoming request chart type : "+datasetConfig.getChartType());
			
			return lineChart.load(datasetConfig,model);
		}
		
		return "error";
	}
}
