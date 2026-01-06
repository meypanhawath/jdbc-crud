package service;

import dao.ProductDao;
import dao.ProductDaoImpl;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    private final ProductDao productDao;

    public ProductServiceImpl(){
        productDao = new ProductDaoImpl();
    }

    @Override
    public List<Product> findAll() {
        try {
             return productDao.findAll();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int save(Product product) {
        try {
            return productDao.save(product);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(Product product) {
        try {
            return productDao.delete(product);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
