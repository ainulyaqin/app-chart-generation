package com.fisclouds.chart.service;

import java.util.Base64;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fisclouds.chart.dto.ChartDataDto;
import com.fisclouds.chart.dto.RenderHtmlDto;
import com.fisclouds.chart.dto.ResponseData;
import com.fisclouds.chart.model.DatasetConfig;
import com.fisclouds.chart.repository.DatasetConfigRepository;

@Service
public class APIChartService {

	@Value("${app.chart.path-chart}")
	private String chart;
	
	@Value("${app.chart.path-htmlrender}")
	private String htmlRender;
	
	private Log log = LogFactory.getLog(APIChartService.class);
	
	@Autowired
	private DatasetConfigRepository datasetConfigRepository;
	
	public ResponseData chartData(ChartDataDto chartDataDto) throws JsonProcessingException {
		
		String json = new ObjectMapper().writeValueAsString(chartDataDto);
		DatasetConfig datasetConfig = new DatasetConfig();
		datasetConfig.setId(UUID.randomUUID());
		datasetConfig.setChartType(chartDataDto.chartType());
		datasetConfig.setData(json);
		
		datasetConfigRepository.save(datasetConfig);
		
		log.info("successfully save data "+json);
		String url = chart+"?id="+datasetConfig.getId().toString();
		
		return new ResponseData("successfully save data", url, datasetConfig.getId().toString());
	}
	
	public ResponseData renderHtml(RenderHtmlDto renderHtmlDto) throws JsonProcessingException {
		
		byte[] decodedBytes = Base64.getDecoder().decode(renderHtmlDto.html());
		String decodedString = new String(decodedBytes);
		
		//String json = new ObjectMapper().writeValueAsString(renderHtmlDto);
		DatasetConfig datasetConfig = new DatasetConfig();
		datasetConfig.setId(UUID.randomUUID());
		datasetConfig.setChartType("renderhtml");
		datasetConfig.setData(decodedString);
		
		datasetConfigRepository.save(datasetConfig);
		
		log.info("successfully save data ");
		String url = htmlRender+"?id="+datasetConfig.getId().toString();
		
		return new ResponseData("successfully save data", url, datasetConfig.getId().toString());
	}
	
}
