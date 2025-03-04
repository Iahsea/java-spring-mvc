package vn.iahsea.laptopshop.service.spcecifition;

import org.springframework.data.jpa.domain.Specification;

import vn.iahsea.laptopshop.domain.Product;
import vn.iahsea.laptopshop.domain.Product_;

public class ProductSpecs {
        public static Specification<Product> nameLike(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Product_.NAME), "%" + name + "%");
    }
}
