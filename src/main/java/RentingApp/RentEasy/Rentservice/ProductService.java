package RentingApp.RentEasy.Rentservice;


import RentingApp.RentEasy.entity.ProductDetails;

import java.util.List;

public interface ProductService {
    public List<ProductDetails> findall();

    public ProductDetails findById(int id);

    public void save(ProductDetails saveProduct);

    public void delete(ProductDetails id);
}
