package eu.guvercin.service;

import eu.guvercin.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    //there is no DB that is the why just imagine this private list is a DB! heheheh
    private List<Product> productList = new ArrayList<>();
    public List<Product> getAllProductList () {
        return productList;
    }

    public Optional<Product> getProductById(Long id) {
        return productList.stream().
                filter(product -> product.getId().
                        equals(id)).findFirst();
    }

    public void addProduct (Product product) {
        productList.add(product);
    }

    public boolean updateProduct (Long id, Product updatedProduct) {
        Optional<Product> existingProduct = getProductById(id);
        if(existingProduct.isPresent()){
            existingProduct.get().setName(updatedProduct.getName());
            existingProduct.get().setPrice(updatedProduct.getPrice());
            return true;
        }
        return false;
    }

    public boolean deleteProduct (Long id) {
        return productList.removeIf(product -> product.getId().equals(id));
    }





}
