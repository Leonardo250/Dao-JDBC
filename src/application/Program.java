package application;

import model.dao.DaoFactory;
import model.dao.SelletDao;
import model.entities.Department;
import model.entities.Sellet;

import java.util.Date;

public class Program {
    public static void main(String[] args){

        SelletDao selletDao = DaoFactory.createSellerDao();

        Sellet seller = selletDao.findById(3);

        System.out.println(seller);
    }
}
