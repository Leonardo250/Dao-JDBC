package application;

import model.dao.DaoFactory;
import model.dao.SelletDao;
import model.entities.Department;
import model.entities.Sellet;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args){

        SelletDao selletDao = DaoFactory.createSellerDao();

        System.out.println("TESTE 1: seler finfById");
        Sellet seller = selletDao.findById(3);
        System.out.println(seller);

        System.out.println("TESTE 2: seller findByDepartment");
        Department department = new Department(2,null);
        List<Sellet> list = selletDao.findByDepartment(department);
        for(Sellet obj : list){
            System.out.printf(String.valueOf(obj));
        }
    }
}
