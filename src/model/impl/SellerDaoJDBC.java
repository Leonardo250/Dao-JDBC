package model.impl;

import db.DB;
import db.DbException;
import model.dao.SelletDao;
import model.entities.Department;
import model.entities.Sellet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC implements SelletDao {

    private Connection conn;

    public  SellerDaoJDBC (Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Sellet obj) {

    }

    @Override
    public void update(Sellet obj) {

    }

    @Override
    public void DeleteById(Integer id) {

    }

    @Override
    public Sellet findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "Select seller.*,department.Name as DepName"
                    +"from seller INNER join department"
                    +"on seller.DepartmentId = department.Id"
                    +"where seller.Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                Department dep = intantiateDepartment(rs);
                dep.setId(rs.getInt("DepartmentId"));
                dep.setName(rs.getString("DepName"));
                Sellet obj = instantiateSeller(rs,dep);
                return obj;
            }
            return null;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }

    private Sellet instantiateSeller(ResultSet rs, Department dep) throws SQLException {
        Sellet obj = new Sellet();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBirthDate(rs.getDate("BirthDate"));
        obj.setDepartment(dep);
        return obj;
    }

    private Department intantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }

    @Override
    public List<Sellet> findAll() {
        return null;
    }
}
