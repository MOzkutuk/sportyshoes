/**
 * Project: sportyshoes
 * Package: com.firsthelloworld.service
 * Created By: Mehmet Baran Ozkutuk
 */

package com.firsthelloworld.service;

import com.firsthelloworld.DAO.ProductDao;
import com.firsthelloworld.entity.Shoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Shoe> showProducts() {

        List<Shoe> shoeList = productDao.showProducts();

        if(shoeList.isEmpty()){
            //throw new exception
        }

        return shoeList;
    }

    @Override
    public void addProduct(Shoe shoe) {
        productDao.addProduct(shoe);
    }

    @Override
    public Long updateProduct(Shoe shoe) {

        Long row = productDao.updateProduct(shoe);

        if(row == null){
            //thow new exception
        }

        return row;
    }

    @Override
    public Long deleteProduct(Long id) {

        Long row = productDao.deleteProduct(id);

        if(row == null){
            //thow new exception
        }

        return row;
    }

    @Override
    public Shoe getProductById(Long id) {

        Shoe productById = productDao.getProductById(id);

        if(productById.getId() == null){
            //throw new exception
        }

        return productById;
    }
}
