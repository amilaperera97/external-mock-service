package com.external.mock.service.impl;

import com.external.mock.dto.CategoryDto;
import com.external.mock.repository.CategoryRepository;
import com.external.mock.service.CategoryService;
import com.external.mock.util.converter.EntityConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final EntityConverter entityConverter;

    @Override
    public List<CategoryDto> findAll() {
        return entityConverter.convert(categoryRepository.findAll(), CategoryDto.class);
    }
}
