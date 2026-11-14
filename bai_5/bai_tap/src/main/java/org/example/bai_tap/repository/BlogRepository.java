package org.example.bai_tap.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.bai_tap.entity.Blog;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository {
    private static EntityManager entityManager;
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Blog> findAll() {
        String queryStr = "SELECT b FROM Blog AS b";
        TypedQuery<Blog> query = entityManager.createQuery(queryStr, Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Integer id) {
        String queryStr = "SELECT b FROM Blog AS b  WHERE b.id = :id";
        TypedQuery<Blog> query = entityManager.createQuery(queryStr, Blog.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public boolean save(Blog blog) {
        Transaction transaction = null;
        Blog origin = blog.getId() == null ? new Blog() : findById(blog.getId());
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            origin.setTitle(blog.getTitle());
            origin.setContent(blog.getContent());
            session.saveOrUpdate(origin);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean remove(Integer id) {
        Blog blog = findById(id);
        if (blog != null) {
            Transaction transaction = null;
            try (Session session = sessionFactory.openSession()) {
                transaction = session.beginTransaction();
                session.remove(blog);
                transaction.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                if (transaction != null) {
                    transaction.rollback();
                }
                return false;
            }
        }
        return false;
    }
}
