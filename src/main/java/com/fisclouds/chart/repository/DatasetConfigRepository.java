package com.fisclouds.chart.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fisclouds.chart.model.DatasetConfig;

@Repository
public interface DatasetConfigRepository extends CrudRepository<DatasetConfig, UUID> {

}
