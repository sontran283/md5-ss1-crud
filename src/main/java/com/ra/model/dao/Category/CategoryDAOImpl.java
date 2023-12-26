package com.ra.model.dao.Category;

import com.ra.model.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            list = session.createQuery("from Category").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public Boolean saveOrUpdate(Category category) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
//            Query query =  session.createQuery("UPDATE from Category set status = :status WHERE id = :id").
//            setParameter("status",category.getStatus()).setParameter("id",category.getId());
//            query.executeUpdate();

//            Query query = session.createNativeQuery("UPDATE categories SET name = ?,status = ?");
//            query.setParameter(1,"gsagsa");
//            query.setParameter(2,"dfghjk");
//            query.executeUpdate();
            session.saveOrUpdate(category);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Category findById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            Category category = session.get(Category.class, id);
            return category;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
