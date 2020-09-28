package com.xzy.service;

import com.xzy.entity.Sources;

import java.util.List;

public interface SourcesService {

    List<Sources> getSourcesList();

    Sources getSourcesBySourceId(Integer sourceId);
}
