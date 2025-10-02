package RentingApp.RentEasy.dao;

import RentingApp.RentEasy.entity.PostForProduct;
import RentingApp.RentEasy.entity.ProductDetails;

import java.util.List;

public interface Dao {


    public List<ProductDetails> findall();

    public ProductDetails findById(int id);


    public void save(ProductDetails productsave);

    public void deleteById(ProductDetails id);

    public void saves(PostForProduct product);

   public List<PostForProduct> findallPost();
}