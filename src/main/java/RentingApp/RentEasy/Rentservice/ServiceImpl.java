package RentingApp.RentEasy.Rentservice;

import RentingApp.RentEasy.dao.Dao;
import RentingApp.RentEasy.entity.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ServiceImpl implements ProductService {

    private Dao dao;

    @Autowired
    public ServiceImpl(@Qualifier("DaoImpl") Dao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<ProductDetails> findall() {
        return dao.findall();
    }

    @Override
    @Transactional
    public ProductDetails findById(int id) {
        return dao.findById(id);
    }

    @Override
    @Transactional
    public void save(ProductDetails saveProduct) {
        dao.save(saveProduct);
    }

    @Override
    @Transactional
    public void delete(ProductDetails id) {
    dao.deleteById(id);
    }
}
