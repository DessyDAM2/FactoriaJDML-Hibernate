package com.jdlm.fp2.factoriajdml;

import MapeoClases.CentrosEntity;
import jakarta.persistence.*;
import org.hibernate.HibernateException;

public class prueba {
    static EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
    static EntityManager em = emf.createEntityManager();
    public static void main(String[] args) {
        try{
            CentrosEntity centros = new CentrosEntity();
            EntityTransaction transaction = em.getTransaction();
            Query query;
            int id = Leer.pedirEntero("Introduce el id del centro");
            transaction.begin();
            query = em.createQuery("Select c from CentrosEntity c where c.id = " + id);
            centros = (CentrosEntity) query.getSingleResult();
            System.out.println(centros.getIdCentro());
        }catch (HibernateException | NoResultException e){
            System.out.println("No existe el id de la tabla elegida");
        }
    }
}
