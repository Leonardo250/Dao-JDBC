package model.dao;

import model.impl.SellerDaoJDBC;

public class DaoFactory {
    public static SelletDao createSellerDao(){
        return new SellerDaoJDBC();
    }
}
