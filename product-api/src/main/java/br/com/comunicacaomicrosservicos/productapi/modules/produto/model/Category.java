package br.com.comunicacaomicrosservicos.productapi.modules.produto.model;

import br.com.comunicacaomicrosservicos.productapi.modules.produto.dto.CategoryRequest;
import br.com.comunicacaomicrosservicos.productapi.modules.produto.dto.CategoryResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    public static Category of(CategoryRequest categoryRequest) {
        var category = new Category();
        BeanUtils.copyProperties(categoryRequest, category);
        return category;
    }

}
