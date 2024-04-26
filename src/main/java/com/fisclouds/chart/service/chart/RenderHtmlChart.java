package com.fisclouds.chart.service.chart;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fisclouds.chart.model.DatasetConfig;

@Service
public class RenderHtmlChart implements ChartService {

	@Override
	public String load(DatasetConfig datasetConfig, Model model) {
		String powered = """
				<p style="float: right; font-family: 'Roboto';font-size: 12px;">Proudly Powered By <a href="https://www.fisclouds.com/">FISClouds</a></p>
				""";
		return datasetConfig.getData().concat(powered);
	}

}
