package com.external.mock.service;

import com.external.mock.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();
}
