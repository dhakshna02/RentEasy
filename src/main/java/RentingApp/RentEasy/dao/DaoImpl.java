package RentingApp.RentEasy.dao;

import RentingApp.RentEasy.entity.PostForProduct;
import RentingApp.RentEasy.entity.ProductDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository("DaoImpl")
public class DaoImpl implements Dao {

    private EntityManager entityManager;


    @Autowired
    public DaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    public List<ProductDetails> findall() {
        Query query = entityManager.createQuery("from ProductDetails");
        List<ProductDetails> products = query.getResultList();
        return products  ;
    }

    @Override
    public ProductDetails findById(int id) {

        ProductDetails product = entityManager.find(ProductDetails.class,id);
        return product;
    }

    @Override
    public void save(ProductDetails productsave) {
        ProductDetails saveProduct = entityManager.merge(productsave);

        productsave.setId(saveProduct.getId());
    }


    @Override
    public void deleteById(ProductDetails id) {
        Query que = entityManager.createQuery("delete from ProductDetails where id = :productId");

        que.setParameter("productId",id);
        que.executeUpdate();

    }
    @Override
    public void saves(PostForProduct productsave) {
       PostForProduct saveProduct = entityManager.merge(productsave);

        productsave.setId(saveProduct.getId());
    }

    @Override
    public List<PostForProduct> findallPost() {
        Query query = entityManager.createQuery("from PostForProduct");
        List<PostForProduct> products = query.getResultList();
        return products  ;
    }
}
