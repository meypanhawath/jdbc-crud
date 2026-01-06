package dao;

import config.DbConfig;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{

    // Dependency
    private final Connection conn;

    public ProductDaoImpl(){
        conn = DbConfig.getInstance();
    }

    @Override
    public List<Product> findAll() throws SQLException {

        Statement stmt = conn.createStatement();

        final String sql = """
                 SELECT * FROM products
                 """;

        ResultSet rs = stmt.executeQuery(sql);

        List<Product> productList = new ArrayList<>();

        while (rs.next()){
            Product products = new Product();
            products.setId(rs.getInt("id"));
            products.setCode(rs.getString("code"));
            products.setName(rs.getString("name"));
            products.setPrice(rs.getDouble("price"));
            products.setQty(rs.getInt("qty"));
            products.setDeleted(rs.getBoolean("is_deleted"));
            productList.add(products);
        }

        return productList;
    }

    @Override
    public int save(Product product) throws SQLException {

        // Create sql first
        final String sql = """
                INSERT INTO products(code, name, price, qty, is_deleted)
                VALUES (?, ?, ?, ?, ?)
                """;
        // Create prepare statement
        PreparedStatement pstmt = conn.prepareStatement(sql);
        // Set
        pstmt.setString(1, product.getCode());
        pstmt.setString(2, product.getName());
        pstmt.setDouble(3, product.getPrice());
        pstmt.setInt(4, product.getQty());
        pstmt.setBoolean(5, product.getDeleted());
        // Execute

        return pstmt.executeUpdate();
    }

    @Override
    public int delete(Product product) throws SQLException {

        // Create sql
        final String sql = """
                DELETE FROM products
                WHERE code = ?
                """;
        // Create prepare statement
        PreparedStatement pstmt = conn.prepareStatement(sql);
        // SET
        pstmt.setString(1, product.getCode());

        // EXECUTE

        return pstmt.executeUpdate();
    }
}
