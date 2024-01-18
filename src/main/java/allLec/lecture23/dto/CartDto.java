package allLec.lecture23.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartDto {
    private List<ProductDto> productList;
    private String login;
}
