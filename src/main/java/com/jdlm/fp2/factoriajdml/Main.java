package com.jdlm.fp2.factoriajdml;

import MapeoClases.*;
import jakarta.persistence.*;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import java.util.InputMismatchException;
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
        try {
            System.out.println("1- Leer Datos");
            System.out.println("2- Insertar Datos");
            System.out.println("3- Modificar Datos");
            System.out.println("4- Eliminar Datos");
            System.out.println("0- Salir");
            opcion = Leer.pedirEntero("");
        } catch (InputMismatchException e) {
            e.printStackTrace();
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
                        System.out.println("Nombre del centro: " + centros.getNombre() + "\n");
                        System.out.println("-------------------------------------------------");
                    }
                }
                case "proyectos" -> {
                    query = em.createQuery("Select p from ProyectosEntity p");
                    for (Object object : query.getResultList()) {
                        ProyectosEntity proyectos = (ProyectosEntity) object;
                        System.out.println("\n Id Proyecto: " + proyectos.getProyectoId());
                        System.out.println("\n Titulo Proyecto: " + proyectos.getTitulo());
                        System.out.println("-------------------------------------------------");
                    }
                }
                case "usuarios" -> {
                    query = em.createQuery("SELECT u from UsuarioEntity u");
                    for (Object object : query.getResultList()) {
                        UsuarioEntity usuario = (UsuarioEntity) object;
                        System.out.println("\n Id Usuario" + usuario.getIdUsuario());
                        System.out.println("\n Nombre Usuario" + usuario.getNombre());
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
            switch (tabla) {
                case "centros" -> {
                    CentrosEntity centro = new CentrosEntity();
                    centro.setIdCentro(Leer.pedirEntero("Introduce el Id del centro"));
                    centro.setNombre(Leer.pedirCadena("Introduce el nombre del centro"));
                    centro.setWeb(Leer.pedirCadena("Introduce la web del centro"));
                    centro.setContacto(Leer.pedirCadena("Introduce el nombre del contacto del centro"));
                    centro.setActivo((byte) 1);
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
        String tabla = Leer.pedirCadena("Introduce la tabla que deseas modificar: " +
                "\nTablas: " +
                "\n -Centros" +
                "\n -Proyectos");
        tabla = tabla.toLowerCase();
        Query query;
        try {
            EntityTransaction transaction = em.getTransaction();
            switch (tabla) {
                case "centros" -> {
                    CentrosEntity centro;
                    int idNew;
                    String nombre, web, contacto;
                    int id = Leer.pedirEntero("Introduce el id del centro");
                    transaction.begin();
                    query = em.createQuery("Select c from CentrosEntity c where c.id = " + id);
                    if (query.getSingleResult() != null) {
                        centro = (CentrosEntity) query.getSingleResult();
                        System.out.println("En caso de no quere modificar pulsar solo enter");
                        idNew = Leer.pedirEntero("Introduce un nuevo id(si no desea modificar poner 0)");
                        nombre = Leer.pedirCadena("Introduce un nuevo nombre");
                        web = Leer.pedirCadena("Introduce una nueva URL");
                        contacto = Leer.pedirCadena("Introduce el nuevo contacto");
                        if (!nombre.equals("")) {
                            centro.setNombre(nombre);
                        }
                        if (idNew != 0) {
                            centro.setIdCentro(idNew);
                        }
                        if (!web.equals("")) {
                            centro.setWeb(web);
                        }
                        if (!contacto.equals("")) {
                            centro.setContacto(contacto);
                        }
                    } else System.out.println("Id no encontrado");
                    transaction.commit();
                }
                case "proyectos" -> {
                    ProyectosEntity proyectos;
                    int idNew, id = Leer.pedirEntero("1"), visitas;
                    String titulo, descripcion, coordinador, estado, visibilidad;
                    transaction.begin();
                    query = em.createQuery("select p from ProyectosEntity p where p.id = " + id);
                    if (query.getSingleResult() != null) {
                        proyectos = (ProyectosEntity) query.getSingleResult();
                        System.out.println("En caso de no quere modificar pulsar solo enter");
                        idNew = Leer.pedirEntero("Introduce un nuevo id(si no desea modificar poner 0)");
                        titulo = Leer.pedirCadena("Introduce un titulo nuevo");
                        descripcion = Leer.pedirCadena("Introduce una descripción nueva");
                        coordinador = Leer.pedirCadena("Introduce un nuevo coordinador");
                        visibilidad = Leer.pedirCadena("Introduce la nueva visibilidad");
                        visitas = Leer.pedirEntero("Introduce el número nuevo de visitas (si no desea modificar poner 0)");

                        if (idNew != 0) {
                            proyectos.setProyectoId(idNew);
                        }
                        if (!titulo.equals("")) {
                            proyectos.setTitulo(titulo);
                        }
                        if (!descripcion.equals("")) {
                            proyectos.setDescripcion(descripcion);
                        }
                        if (!coordinador.equals("")) {
                            proyectos.setCoordinador(coordinador);
                        }
                        if (!visibilidad.equals("")) {
                            proyectos.setVisibilidad(visibilidad);
                        }
                        if (visitas != 0) {
                            proyectos.setVisitas(visitas);
                        }
                    } else System.out.println("Id no encontrado");
                }
            }
        } catch (HibernateException | NoResultException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarDatos() {

    }


}
