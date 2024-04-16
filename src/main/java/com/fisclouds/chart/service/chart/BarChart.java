package com.fisclouds.chart.service.chart;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fisclouds.chart.model.DatasetConfig;
import com.jayway.jsonpath.JsonPath;

@Service
public class BarChart implements ChartService {

	@Override
	public String load(DatasetConfig datasetConfig, Model model) {

		String data = datasetConfig.getData();

		Queue<String> lables = new LinkedList<String>();
		Queue<Integer> datas = new LinkedList<Integer>();

		List<Map<String, Object>> datasets = JsonPath.read(data, "$.datasets");
		for (Map<String, Object> dataset : datasets) {
			lables.add((String)dataset.get("label"));
			datas.add((Integer)dataset.get("value"));
		}

		String columns [] = JsonPath.read(data, "$.columns").toString().split(",");
		
		model.addAttribute("labelAttribute", lables.toArray(String[]::new));
		model.addAttribute("dataAttribute", datas.toArray(Integer[]::new));
		model.addAttribute("xLabel", columns[0]);
		model.addAttribute("yLabel", columns[1]);
		return "chart";
	}

}
