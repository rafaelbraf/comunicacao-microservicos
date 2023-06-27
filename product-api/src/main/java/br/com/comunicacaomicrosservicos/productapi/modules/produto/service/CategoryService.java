package br.com.comunicacaomicrosservicos.productapi.modules.produto.service;

import br.com.comunicacaomicrosservicos.productapi.config.exception.ValidationException;
import br.com.comunicacaomicrosservicos.productapi.modules.produto.dto.CategoryRequest;
import br.com.comunicacaomicrosservicos.productapi.modules.produto.dto.CategoryResponse;
import br.com.comunicacaomicrosservicos.productapi.modules.produto.model.Category;
import br.com.comunicacaomicrosservicos.productapi.modules.produto.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponse save(CategoryRequest request) {
        validateCategoryNameInformed(request);
        var category = categoryRepository.save(Category.of(request));
        return CategoryResponse.of(category);
    }

    private void validateCategoryNameInformed(CategoryRequest request) {
        if (ObjectUtils.isEmpty(request.getDescription())) {
            throw new ValidationException("The category description was not informed.");
        }
    }

}
