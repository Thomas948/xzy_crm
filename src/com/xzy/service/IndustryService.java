package com.xzy.service;

import com.xzy.entity.Industry;

import java.util.List;

public interface IndustryService {

    List<Industry> getIndustryList();

    Industry getIndustryByIndustryId(Integer industryId);
}
