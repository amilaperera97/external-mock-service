package com.external.mock.rest;

import com.external.mock.dto.CategoryDto;
import com.external.mock.service.CategoryService;
import com.techbooker.sm.util.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.external.mock.util.Constant.EndpointInfo.API_V1;
import static com.external.mock.util.Constant.EndpointInfo.CATEGORY;

@RestController
@RequestMapping(value = API_V1)
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping(value = CATEGORY)
    public ResponseDto<List<CategoryDto>> findAll() {
        return new ResponseDto<List<CategoryDto>>().buildSuccessMsgWithData(categoryService.findAll());
    }
}
