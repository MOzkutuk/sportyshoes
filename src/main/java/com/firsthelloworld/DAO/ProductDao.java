/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.DAO
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.DAO;

import com.firsthelloworld.entity.Shoe;

import java.util.List;

public interface ProductDao {

    List<Shoe> showProducts();
    void addProduct(Shoe shoe);
    Long updateProduct(Shoe shoe);
    Long deleteProduct(Long id);
    Shoe getProductById(Long id);

}
