package model.dao;

import model.entities.Department;
import model.entities.Sellet;

import java.util.List;

public interface SelletDao {
    void insert(Sellet obj);
    void update(Sellet obj);
    void DeleteById(Integer id );
    Sellet findById(Integer id);
    List<Sellet> findAll();
    List<Sellet> findByDepartment(Department department);
}

