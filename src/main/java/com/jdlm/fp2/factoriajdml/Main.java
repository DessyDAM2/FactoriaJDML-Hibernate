package com.jdlm.fp2.factoriajdml;

import MapeoClases.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {


    static EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
    static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1 -> leerDatos();
                case 2 -> insertarDatos();
                case 3 -> modificarDatos();
                case 4 -> eliminarDatos();
                case 0 -> em.close();
            }
        } while (opcion != 0);
    }

    public static int menu() {
        int opcion = -1;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("1- Leer Datos");
            System.out.println("2- Insertar Datos");
            System.out.println("3- Modificar Datos");
            System.out.println("4- Eliminar Datos");
            System.out.println("0- Salir");
            opcion = sc.nextInt();
        } catch (InputMismatchException e) {
            sc.next();
        }

        return opcion;
    }

    public static void leerDatos() {

        String tabla = Leer.pedirCadena("Introduce la tabla para mostrar los datos" +
                "\nTablas:" +
                "\n -Centros" +
                "\n -Proyectos" +
                "\n -Usuarios");

        tabla = tabla.toLowerCase();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Query query;
            switch (tabla) {
                case "centros" -> {
                    query = em.createQuery("Select c FROm CentrosEntity c");
                    for (Object object : query.getResultList()) {
                        CentrosEntity centros = (CentrosEntity) object;
                        System.out.println("\nId centro: " + centros.getIdCentro());
                        System.out.println("Nombre del centro" + centros.getNombre() + "\n");
                        System.out.println("-------------------------------------------------");
                    }
                }
                case "proyectos" -> {
                    query = em.createQuery("Select p from ProyectosEntity p");
                    for (Object object : query.getResultList()) {
                        ProyectosEntity proyectos = (ProyectosEntity) object;
                        System.out.println(proyectos.getProyectoId());
                        System.out.println(proyectos.getTitulo());
                        System.out.println("-------------------------------------------------");
                    }
                }
                case "usuarios" -> {
                    query = em.createQuery("SELECT u from UsuarioEntity u");
                    for (Object object : query.getResultList()) {
                        UsuarioEntity usuario = (UsuarioEntity) object;
                        System.out.println(usuario.getIdUsuario());
                        System.out.println(usuario.getNombre());
                        System.out.println("-------------------------------------------------");
                    }
                }
                default -> System.out.println("Opción no válida");
            }
            transaction.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void insertarDatos() {
        String tabla = Leer.pedirCadena("Introduce una tabla para insertar datos:" +
                "\n Tablas:  " +
                "\n Centros" +
                "\n Proyectos");
        System.out.println();
        tabla = tabla.toLowerCase();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Query query;
            switch (tabla) {
                case "centros" -> {
                    CentrosEntity centro = new CentrosEntity();
                    centro.setIdCentro(Leer.pedirEntero("Introduce el Id del centro"));
                    centro.setNombre(Leer.pedirCadena("Introduce el nombre del centro"));
                    centro.setWeb(Leer.pedirCadena("Introduce la web del centro"));
                    centro.setContacto(Leer.pedirCadena("Introduce el nombre del contacto del centro"));
                    em.persist(centro);
                }
                case "proyectos" -> {
                    ProyectosEntity proyectos = new ProyectosEntity();
                    proyectos.setProyectoId(Leer.pedirEntero("Itroduce el Id del proyecto"));
                    proyectos.setTitulo(Leer.pedirCadena("Introduce el titulo del proyecto"));
                    proyectos.setDescripcion(Leer.pedirCadena("Introduce la descripción del proyecto"));
                    proyectos.setCoordinador(Leer.pedirCadena("Introduce al coordinador del proyecto"));
                    proyectos.setEstado(Leer.pedirCadena("Introduce el estado del proyecto"));
                    proyectos.setVisibilidad(Leer.pedirCadena("Introduce la visibilidad del proyecto"));
                    proyectos.setVisitas(Leer.pedirEntero("Introduce las visitas del proyecto"));
                    em.persist(proyectos);
                }
                default -> System.out.println("Opción no válida");
            }
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void modificarDatos() {

    }

    public static void eliminarDatos() {

    }


}
