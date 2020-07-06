package ru.gik.hibernate.homwork3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
  /*  DROP TABLE if exists customers cascade;
    drop table if exists products cascade;
    drop table if exists customer_product CASCADE;

    create table customers(id serial, name varchar(255), primary key (id));
    create TABLE products(id serial, title varchar(255), cost INT, primary key (id));
    create table customer_product(customer_id integer REFERENCES customers (id),
    product_id INTEGER REFERENCES products (id));
    INSERT INTO customers (name) VALUES
		('Ivan Ivanov'),
                ('Petr Petrov'),
                ('Lev Lvov'),
                ('Sergey Sergeev');
    INSERT INTO products (title, cost) VALUES
		('bread',12),
                ('cheese',23),
                ('water',11),
                ('solt',5);
    INSERT INTO customer_product (customer_id, product_id) VALUES
		(1,1),
                (2,1),
                (3,1),
                (2,2),
                (2,3),
                (3,4),
                (1,4);*/

    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();

            session.beginTransaction();
            Long customerId = 1L;
            Customer customer = session.get(Customer.class, customerId);

            List<Product> pList = new ArrayList<>();
            for (Product p : customer.getProducts()) {
                pList.add(p);
            }
            //  System.out.println(pList);
            session.getTransaction().commit();
            //

            session = factory.getCurrentSession();
            session.beginTransaction();
            Long productId = 1L;
            Product product = session.get(Product.class, productId);

            List<Customer> customers = new ArrayList<>(product.getCustomers());
           // System.out.println(customers);
            session.getTransaction().commit();
            //
            session = factory.getCurrentSession();
            session.beginTransaction();
            Long deletingId = 3L;
            session.createQuery("delete from Customer c where c.id =:id").setParameter("id",deletingId).executeUpdate();
            session.getTransaction().commit();
            //

            session = factory.getCurrentSession();
            session.beginTransaction();
            Long deletingProductId = 3L;
            session.createQuery("delete from Product p where p.id =:id").setParameter("id",deletingProductId).executeUpdate();
            session.getTransaction().commit();

        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
