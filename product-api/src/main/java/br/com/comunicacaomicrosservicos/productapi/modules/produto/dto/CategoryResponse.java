package br.com.comunicacaomicrosservicos.productapi.modules.produto.dto;

import br.com.comunicacaomicrosservicos.productapi.modules.produto.model.Category;
import lombok.Data;

@Data
public class CateogryResponse {

    private Integer id;
    private String description;

    public static CateogryResponse of(Category category) {
        
    }

}
