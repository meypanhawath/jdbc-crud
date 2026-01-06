import config.DbConfig;
import model.Product;
import service.ProductService;
import service.ProductServiceImpl;
import util.InputUtil;
import util.ViewUtil;

import java.sql.Connection;
import java.util.List;

public class Main {

        public static void main(String[] args){

            DbConfig.init();

            ProductService productService = new ProductServiceImpl();

            do {
                ViewUtil.printMenu();

                int opt = InputUtil.getInteger("Choose option: ");
                switch (opt) {
                    case 0 -> System.exit(0);
                    case 1 -> {
                        List<Product> productList = productService.findAll();
                        ViewUtil.printProductList(productList);
                    }
                    case 2 -> System.out.println("Search");
                    case 3 -> {
                        String code = InputUtil.getText("Enter code");
                        String name = InputUtil.getText("Enter name");
                        Double price = InputUtil.getMoney("Enter price");
                        Integer qty = InputUtil.getInteger("Enter quantity");

                        Product product = new Product(code, name, price, qty, false);
                        try {
                            productService.save(product);
                            ViewUtil.printHeader("Product saved successfully!");
                        } catch (RuntimeException e){
                            ViewUtil.printHeader(e.getMessage());
                        }
                    }
                    case 4 -> System.out.println("Update");
                    case 5 -> {
                        String code = InputUtil.getText("Enter code to delete");
                        Product product = new Product();
                        product.setCode(code);

                        int result = productService.delete(product);
                        if (result > 0) {
                            ViewUtil.printHeader("Product deleted successfully!");
                        } else {
                            ViewUtil.printHeader("Product failed to deleted!");
                        }

                    }
                    default -> System.out.println("Invalid option...");
                }
            }while (true);
        }
    }
