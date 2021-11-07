/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.service
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.service;

import com.firsthelloworld.entity.Shoe;

import java.util.List;

public interface ProductService {
    List<Shoe> showProducts();
    void addProduct(Shoe shoe);
    Long updateProduct(Shoe shoe);
    Long deleteProduct(Long id);
    Shoe getProductById(Long id);

}
