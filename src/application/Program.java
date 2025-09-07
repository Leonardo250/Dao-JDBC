package application;

import model.dao.DaoFactory;
import model.dao.SelletDao;
import model.entities.Department;
import model.entities.Sellet;

import java.util.Date;

public class Program {
    public static void main(String[] args){

        Department obj = new Department(1,"books");
        Sellet seller = new Sellet(21,"bob","bob@gmail.com",300000.0, obj,new Date());
        System.out.println(seller);

        SelletDao selletDao = DaoFactory.createSellerDao();
    }
}
