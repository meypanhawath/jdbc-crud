package dao;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    public List<Product> findAll() throws SQLException;

    // 1. Operation: Insert a new record into database
    // 2. Expected return value -> affected row number
    // 3. Parameters
    int save(Product product) throws SQLException;

    // 1. Operation: Update
    int delete(Product product) throws SQLException;
}
