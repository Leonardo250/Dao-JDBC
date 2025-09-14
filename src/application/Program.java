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

        System.out.println("TESTE 3: seller findAll");
        list = selletDao.findAll();
        for(Sellet obj : list){
            System.out.printf(String.valueOf(obj));
        }

        System.out.println("TESTE 4: inserção");
        Sellet newSeller = new Sellet(null,"greg","greg@email.com",4000.0,department,new Date());
        selletDao.insert(newSeller);
        System.out.println("Inserido novo id = " + newSeller.getId());

        System.out.println("TESTE 5: update");
        seller = selletDao.findById(1);
        seller.setName("bob rod");
        selletDao.update(seller);
        System.out.println("atualizado");
    }
}
