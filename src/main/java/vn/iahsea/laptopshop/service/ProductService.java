package vn.iahsea.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import vn.iahsea.laptopshop.domain.Cart;
import vn.iahsea.laptopshop.domain.CartDetail;
import vn.iahsea.laptopshop.domain.Product;
import vn.iahsea.laptopshop.domain.User;
import vn.iahsea.laptopshop.repository.CartDetailRepository;
import vn.iahsea.laptopshop.repository.CartReposiroty;
import vn.iahsea.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CartReposiroty cartReposiroty;
    private final CartDetailRepository cartDetailRepository;
    private final UserService userService;

    public ProductService(
            ProductRepository productRepository,
            CartReposiroty cartReposiroty,
            CartDetailRepository cartDetailRepository,
            UserService userService) {
        this.productRepository = productRepository;
        this.cartReposiroty = cartReposiroty;
        this.cartDetailRepository = cartDetailRepository;
        this.userService = userService;
    }

    public Product createProduct(Product pr) {
        return this.productRepository.save(pr);
    }

    public List<Product> fetchProducts() {
        return this.productRepository.findAll();
    }

    public void deleteProduct(long id) {
        this.productRepository.deleteById(id);
    }

    public Optional<Product> fetchProductById(long id) {
        return this.productRepository.findById(id);
    }

    public void handleAddProductToCart(String email, long productId, HttpSession session) {

        User user = this.userService.getUserByEmail(email);

        if (user != null) {
            // check user đã có cart chưa ? nếu chưa -> tạo mới
            Cart cart = this.cartReposiroty.findByUser(user);

            if (cart == null) {
                // tạo mới cart
                Cart othercCart = new Cart();
                othercCart.setUser(user);
                othercCart.setSum(0);

                cart = this.cartReposiroty.save(othercCart);
            }
            // save cart_detail
            // tìm product by id

            Optional<Product> productOptional = this.productRepository.findById(productId);
            if (productOptional.isPresent()) {
                Product realProduct = productOptional.get();

                CartDetail oldDetail = this.cartDetailRepository.findByCartAndProduct(cart, realProduct);

                if (oldDetail == null) {

                    CartDetail cartDetail = new CartDetail();
                    cartDetail.setCart(cart);
                    cartDetail.setProduct(realProduct);
                    cartDetail.setPrice(realProduct.getPrice());
                    cartDetail.setQuantity(1);
                    this.cartDetailRepository.save(cartDetail);

                    // update cart (sum);
                    int s = cart.getSum() + 1;
                    cart.setSum(s);
                    this.cartReposiroty.save(cart);
                    session.setAttribute("sum", s);
                } else {
                    oldDetail.setQuantity(oldDetail.getQuantity() + 1);
                    this.cartDetailRepository.save(oldDetail);
                }

            }
        }

        // lưu cart_detail
    } 

    public Cart fetchByUser(User user){
        return this.cartReposiroty.findByUser(user);
    }

}
