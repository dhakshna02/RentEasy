package RentingApp.RentEasy.Rentservice;


import RentingApp.RentEasy.entity.PostForProduct;
import RentingApp.RentEasy.entity.ProductDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    public List<ProductDetails> findall();

    public ProductDetails findById(int id);

    public void save(ProductDetails saveProduct);

    public void delete(ProductDetails id);

    public void saves(PostForProduct product);

    public List<PostForProduct> findallPost();
}
