package banhang.banhang.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {
    @NotBlank(message = "Tên bắt buộc phải nhập!")
    String name;
    @NotBlank(message = "Mô tả bắt buộc phải nhập!!" )
    String description;
    Integer price;
    String image_url;
    Integer status;
}
