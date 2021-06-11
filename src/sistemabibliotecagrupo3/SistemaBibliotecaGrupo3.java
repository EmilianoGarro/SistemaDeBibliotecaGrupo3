/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabibliotecagrupo3;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import sistemabibliotecagrupo3.modelos.*;

/**
 *
 * @author Emiliano
 */
public class SistemaBibliotecaGrupo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

       
        Conexion conexion;
        try {
                conexion = new Conexion();
                Connection con = conexion.getConexion();
                AutorData autorData = new AutorData(conexion);
                LibroData libroData = new LibroData(conexion);
                LectorData lectorData = new LectorData(conexion);
                EjemplarData ejemplarData = new EjemplarData(conexion);
                MultaData multaData = new MultaData(conexion);
                PrestamoData prestamoData = new PrestamoData(conexion);

//            ---------------------------PRUEBA AUTORDATA-------------------------------------------
//  ---------------------------------AUTORES--------------------------------------------------------------------
//                Autor a1 = new Autor(5748365,"Céline","Louis-Ferdinand","Francia",LocalDate.of(1894,5,27),true);
//                Autor a2 = new Autor(1657826,"Wilde","Oscar","Irlanda",LocalDate.of(1854,10,16),true);
//                Autor a3 = new Autor(3459461,"Shakespeare","Willian","Reino Unido",LocalDate.of(1564,4,5),true);
//                Autor a4 = new Autor(4562168,"Coelho","Paulo","Brasil",LocalDate.of(1947,8,24),true);
//                Autor a5 = new Autor(8416783,"Dilkens","Charles","Reino Unido",LocalDate.of(1812,2,7),true);
//                Autor a6 = new Autor(3754170,"Huxley","Aldous","Reino Unido",LocalDate.of(1894,6,26),true);

//          -----------------------------CARGA DE AUTORES A LA BASE DE DATOS-----------------------------------------
//                autorData.guardarAutor(a1);
//                autorData.guardarAutor(a2);
//                autorData.guardarAutor(a3);
//                autorData.guardarAutor(a4);
//                autorData.guardarAutor(a5);
//                autorData.guardarAutor(a6);
//                autorData.guardarAutor(a1);//tiene que dar error
//----------------------------PRUEBA DE METODOS VARIOS-------------------------------------------
//                ArrayList<Autor>pruebaAutor = new ArrayList<>();
//                pruebaAutor = (ArrayList)autorData.obtenerAutores();
//                JOptionPane.showMessageDialog(null,autorData.buscarAutor(pruebaAutor.get(4).getId_Autor()).getApellido());
//                JOptionPane.showMessageDialog(null,autorData.buscarAutor(pruebaAutor.get(5).getId_Autor()).getApellido());
//                autorData.darBajaAutor(pruebaAutor.get(4).getId_Autor());
//                autorData.darBajaAutor(125);
//                autorData.darBajaAutor(pruebaAutor.get(2).getId_Autor());
//                autorData.darBajaAutor(pruebaAutor.get(5).getId_Autor());
//                autorData.datAltaAutor(pruebaAutor.get(4).getId_Autor());
//                autorData.datAltaAutor(pruebaAutor.get(4).getId_Autor());
//
//                Autor auxA6 = new Autor(1212,"prueba","prueba","arg",LocalDate.of(1894,6,26),true);
//                autorData.guardarAutor(auxA6);
//                Autor auxA7 = new Autor(12222,"prueba","prueba","arg",LocalDate.of(1894,6,26),true);
//                autorData.actualizarAutor(auxA7);
//                pruebaAutor = (ArrayList)autorData.obtenerAutores();
//                auxA7.setId_Autor(pruebaAutor.get(6).getId_Autor());
//                autorData.actualizarAutor(auxA7);
//                ArrayList<Autor>auxAutor3=(ArrayList)autorData.obtenerAutoresSegunEstado(false);
//                JOptionPane.showMessageDialog(null,auxAutor3);

//       -----------------------------------------PRUEBA LIBRODATA-------------------------------------------------
//       ----------------------------------LIBROS-------------------------------------        
//                Libro l1 = new Libro(pruebaAutor.get(0),"2398","Viaje al fin de la noche","Novela","Denoël",1932,true);
//                Libro l2 = new Libro(pruebaAutor.get(0),"2399","Muerte a crédito","Ficción","deBolsillo",2021,true);
//                Libro l3 = new Libro(pruebaAutor.get(1),"4624","El retrato de Dorian Gray","Horror","AGeBe",1840,true);
//                Libro l4 = new Libro(pruebaAutor.get(1),"4683","El Fantasma de Canterville","Ficcion","AGeBe",1887,true);
//                Libro l5 = new Libro(pruebaAutor.get(2),"6753","Romeo y Julieta","Tragedia","Alma",1597,true);
//                Libro l6 = new Libro(pruebaAutor.get(2),"7876","Mucho ruido y pocas nueces","Romance","Alianza",2020,true);
//                Libro l7 = new Libro(pruebaAutor.get(3),"5875","El Alquimista","Drama","Planeta",1988,true);
//                Libro l8 = new Libro(pruebaAutor.get(3),"5786","Once Minutos","Ficcion","Booket",2003,true);
//                Libro l9 = new Libro(pruebaAutor.get(4),"5987","Cuentos de Navidad","Ficcion","Austral",1843,true);
//                Libro l10 = new Libro(pruebaAutor.get(4),"8732","Tiempos Dificiles","Ficcion","Alianza",1854,true);
//                Libro l11 = new Libro(pruebaAutor.get(5),"4216","Un Mundo Feliz","Novela","Edhasa",1932,true);
//                Libro l12 = new Libro(pruebaAutor.get(5),"1654","La Isla","Novela","Octaedro",1862,true);
//                Libro l13 = new Libro(pruebaAutor.get(5),"5375","Las Puertas de la Percepción","Ficcion","Debolsillo",2018,true);

//             ---------------------------------CARGA DE LIBROS--------------------------------------------------
//                libroData.guardarLibro(l1);
//                libroData.guardarLibro(l2);
//                libroData.guardarLibro(l3);
//                libroData.guardarLibro(l4);
//                libroData.guardarLibro(l5);
//                libroData.guardarLibro(l6);
//                libroData.guardarLibro(l7);
//                libroData.guardarLibro(l8);
//                libroData.guardarLibro(l9);
//                libroData.guardarLibro(l10);
//                libroData.guardarLibro(l11);
//                libroData.guardarLibro(l12);
//                libroData.guardarLibro(l13);
//                libroData.guardarLibro(l13);

//             ------------------------------------PRUEBA DE METODOS VARIOS------------------------------
//                ArrayList<Libro>pruebaLibros=new ArrayList<>();  
//                pruebaLibros = (ArrayList)libroData.obtenerLibros();
//                libroData.darBajaLibro(pruebaLibros.get(0).getId_Libro());
//                libroData.darBajaLibro(pruebaLibros.get(1).getId_Libro());
//                libroData.darBajaLibro(pruebaLibros.get(2).getId_Libro());
//                libroData.darBajaLibro(pruebaLibros.get(2).getId_Libro());
//                libroData.darAltaLibro(pruebaLibros.get(0).getId_Libro());
//
//                JOptionPane.showMessageDialog(null, libroData.buscarLibro(pruebaLibros.get(0).getId_Libro()).getNombre());
//                JOptionPane.showMessageDialog(null,pruebaLibros.get(0).getNombre());
//                JOptionPane.showMessageDialog(null, pruebaLibros.get(0).getAutor().getApellido());
//                Libro lp = new Libro(pruebaAutor.get(0),"1020","prueba","prueba","prueba",1234,true);
//                libroData.guardarLibro(lp);
//                pruebaLibros = (ArrayList)libroData.obtenerLibros();
//                libroData.eliminarLibro(pruebaLibros.get(13).getId_Libro());
//                libroData.eliminarLibro(412);
//                ArrayList<Libro>auxLibro2 = (ArrayList)libroData.obtenerLibrosSegunEstado(true);
//                JOptionPane.showMessageDialog(null, auxLibro2.get(0).getAutor().getApellido());             
// --------------------------------------PRUEBA LECTOR DATA--------------------------------------------------
//              -------------------------LECTORES-------------------
//                Lector lc1 = new Lector(42744219,"Gomez","Renzo","prueba@gmail.com",true);
//                Lector lc2 = new Lector(23568456,"Altamirano","Franco","prueba@gmail.com",true);
//                Lector lc3 = new Lector(42395443,"Martinez","Maria","prueba@gmail.com",true);   
//                Lector lc4 = new Lector(12435745,"Cabañez","Maria","prueba@gmail.com",true);
//                Lector lc5 = new Lector(47234244,"Gatica","Marcos","Marcos@gmail.com",true);
//                Lector lc6 = new Lector(33583430,"Fernandez","Macarena","prueba@hotmail.com",true);
//                Lector lc7 = new Lector(9567254,"Rivarola","Jorge","prueba@gmail.com",true);
//                Lector lc8 = new Lector(47295443,"Quiroga","Ariel","prueba@gmail.com",true);
//                Lector lc9 = new Lector(39583434,"Garro","Emiliano","emilianoGarro1998@gmail.com",true);
//                Lector lc10 = new Lector(228543694,"Pogliese","Javier","ejemplo@gmail.com",true);
////     -------------------------GUARDAMOS LOS LECTORES-------------------------------           
//                lectorData.guardarLector(lc1);
//                lectorData.guardarLector(lc2);
//                lectorData.guardarLector(lc3);
//                lectorData.guardarLector(lc4);
//                lectorData.guardarLector(lc5);
//                lectorData.guardarLector(lc6);
//                lectorData.guardarLector(lc7);
//                lectorData.guardarLector(lc8);
//                lectorData.guardarLector(lc9);
//                lectorData.guardarLector(lc10);
//      ------------------------PRUEBA DE METODOS VARIOS----------------------------------------
//                ArrayList<Lector> lectores = (ArrayList)lectorData.obtenerLectores();
//                JOptionPane.showMessageDialog(null, lectorData.buscarLector(lectores.get(1).getId_Lector()).getNombre());
//                lectorData.darBajaLector(lectores.get(0).getId_Lector());
//                lectorData.darBajaLector(lectores.get(0).getId_Lector());
//                Lector auxLc = new Lector(228543694,"Pogliese","Javier","prueba@gmail.com",true);
//                auxLc.setId_Lector(lectores.get(9).getId_Lector());
//                lectorData.actualizarLector(auxLc);
//                lectorData.eliminarLector(auxLc.getId_Lector());
//                ArrayList<Lector>auxLector=(ArrayList)lectorData.obtenerLectoresSegunEstado(false);
//                JOptionPane.showMessageDialog(null, auxLector.get(0).getEmail());
//    -------------------------------PRUEBA EJEMPLAR---------------------------
//                ArrayList<Libro> auxL = (ArrayList)libroData.obtenerLibros();
//                Ejemplar e1 = new Ejemplar(auxL.get(0),"Disponible",true);
//                Ejemplar e2 = new Ejemplar(auxL.get(1),"Disponible",true);
//                Ejemplar e3 = new Ejemplar(auxL.get(2),"Disponible",true);
//                Ejemplar e4 = new Ejemplar(auxL.get(2),"Disponible",true);
//                Ejemplar e5 = new Ejemplar(auxL.get(4),"Disponible",true);
//                Ejemplar e6 = new Ejemplar(auxL.get(4),"Disponible",true);
//                Ejemplar e7 = new Ejemplar(auxL.get(4),"Disponible",true);
//                Ejemplar e8 = new Ejemplar(auxL.get(5),"Disponible",true);
//                Ejemplar e9 = new Ejemplar(auxL.get(6),"Disponible",true);
//                Ejemplar e10 = new Ejemplar(auxL.get(7),"Disponible",true);
//                Ejemplar e11 = new Ejemplar(auxL.get(7),"Disponible",true);
//                Ejemplar e12 = new Ejemplar(auxL.get(8),"Disponible",true);
//                Ejemplar e13 = new Ejemplar(auxL.get(9),"Disponible",true);
//                Ejemplar e14 = new Ejemplar(auxL.get(9),"Disponible",true);
//                Ejemplar e15 = new Ejemplar(auxL.get(10),"Disponible",true);
//                Ejemplar e16 = new Ejemplar(auxL.get(10),"Disponible",true);
//                Ejemplar e17 = new Ejemplar(auxL.get(11),"Disponible",true);
//                Ejemplar e18 = new Ejemplar(auxL.get(12),"Disponible",true);
//                Ejemplar e19 = new Ejemplar(auxL.get(12),"Disponible",true);
//                Ejemplar e20 = new Ejemplar(auxL.get(12),"Disponible",true);
//                Ejemplar e21 = new Ejemplar(auxL.get(12),"Disponible",true);
//                Ejemplar e22 = new Ejemplar(auxL.get(12),"Disponible",true);
//                Ejemplar e23 = new Ejemplar(auxL.get(12),"Disponible",true);
//            ------------------CARGA DE EJEMPLARES A LA BASE DE DATOS------------------
//                ejemplarData.guardarEjemplar(e1);
//                ejemplarData.guardarEjemplar(e2);
//                ejemplarData.guardarEjemplar(e3);
//                ejemplarData.guardarEjemplar(e4);
//                ejemplarData.guardarEjemplar(e5);
//                ejemplarData.guardarEjemplar(e6);
//                ejemplarData.guardarEjemplar(e7);
//                ejemplarData.guardarEjemplar(e8);
//                ejemplarData.guardarEjemplar(e9);
//                ejemplarData.guardarEjemplar(e10);
//                ejemplarData.guardarEjemplar(e11);
//                ejemplarData.guardarEjemplar(e12);
//                ejemplarData.guardarEjemplar(e13);
//                ejemplarData.guardarEjemplar(e14);
//                ejemplarData.guardarEjemplar(e15);
//                ejemplarData.guardarEjemplar(e16);
//                ejemplarData.guardarEjemplar(e17);
//                ejemplarData.guardarEjemplar(e18);
//                ejemplarData.guardarEjemplar(e19);
//                ejemplarData.guardarEjemplar(e20);
//                ejemplarData.guardarEjemplar(e21);
//                ejemplarData.guardarEjemplar(e22);
//                ejemplarData.guardarEjemplar(e23);
//            -------------------PRUEBA DE METODOS -------------------
//                ArrayList<Ejemplar>ejemplares=(ArrayList)ejemplarData.obtenerEjemplares();
//                ejemplarData.darBajaEjemplar(ejemplares.get(0).getId_Ejemplar());
//                ejemplarData.darBajaEjemplar(ejemplares.get(0).getId_Ejemplar());
//                ejemplarData.darAltaEjemplar(ejemplares.get(1).getId_Ejemplar());
//                Ejemplar auxEjemplar1 = new Ejemplar(auxL.get(12),"Prestado",true);
//                ejemplarData.guardarEjemplar(auxEjemplar1);
//                ejemplares=(ArrayList)ejemplarData.obtenerEjemplares();
//                auxEjemplar1.setEstado("En Reparacion");
//                auxEjemplar1.setId_Ejemplar(ejemplares.get(23).getId_Ejemplar());
//                ejemplarData.actualizarEjemplar(auxEjemplar1);
//                ejemplarData.eliminarEjemplar(ejemplares.get(23).getId_Ejemplar());
//                ejemplarData.eliminarEjemplar(25);
//                ArrayList<Ejemplar>auxEjemplares=(ArrayList)ejemplarData.obtenerEjemplaresSegunEstado(false);
//                JOptionPane.showMessageDialog(null, auxEjemplares.get(0).getLibro().getAutor().getApellido()); 
//                JOptionPane.showMessageDialog(null,ejemplarData.buscarEjemplar(ejemplares.get(0).getId_Ejemplar()).getEstado());
//          --------------------PRUEBA MULTA DATA-----------------------------------------
//            Multa m1 = new Multa(LocalDate.of(2000, 1, 25),LocalDate.of(2021, 6, 6),true);
//            Multa m2 = new Multa(LocalDate.of(1992, 1, 25),LocalDate.of(2021, 6, 6),false);
//            Multa m3 = new Multa(LocalDate.of(2012, 1, 25),LocalDate.of(2021, 6, 6),false);
//            Multa m4 = new Multa(LocalDate.of(2020, 2, 28),LocalDate.of(2021, 6, 6),true);    
//            --------------CARGA DE MULTAS---------------------------------------
//            multaData.guardarMulta(m1);
//            multaData.guardarMulta(m2);
//            multaData.guardarMulta(m3);
//            multaData.guardarMulta(m4);
//            ArrayList<Multa> multas = (ArrayList)multaData.obtenerMultas();
//            multaData.darAltaMulta(multas.get(1).getId_Multa());
//            multaData.darAltaMulta(multas.get(2).getId_Multa());
//            multaData.darBajaMulta(multas.get(0).getId_Multa());
//            multaData.darBajaMulta(multas.get(3).getId_Multa()); 
//            Multa auxMulta = new Multa(LocalDate.of(1999, 1, 25),LocalDate.of(2021, 6, 6),true);
//            auxMulta.setId_Multa(multas.get(3).getId_Multa());
//            multaData.actualizarMulta(auxMulta);
//            ArrayList<Multa>auxMultas=(ArrayList)multaData.obtenerMultasSegunEstado(true);
//            JOptionPane.showMessageDialog(null,auxMultas.get(0).getFechaInicio());
//            multas.forEach((m) -> multaData.eliminarMulta(m.getId_Multa()));
//           -------------------------------PRESTAMO DATA-------------------------------
//              ArrayList<Ejemplar> ejemplaresP = (ArrayList)ejemplarData.obtenerEjemplares();
//              ArrayList<Lector> lectoresP = (ArrayList)lectorData.obtenerLectores();
//              for(Lector l:lectoresP){
//              l.setActivo(true);
//              lectorData.actualizarLector(l);
//              }
//              for(Ejemplar e:ejemplaresP){
//              e.setEstado("Disponible");
//              e.setActivo(true);
//              ejemplarData.actualizarEjemplar(e);
//              }
//              prestamoData.solicitarPrestamo(ejemplaresP.get(0),lectoresP.get(0));
//              prestamoData.solicitarPrestamo(ejemplaresP.get(0),lectoresP.get(0));//tiene que dar error 
//              prestamoData.solicitarPrestamo(ejemplaresP.get(0),lectoresP.get(2));//tiene que dar error
//              prestamoData.solicitarPrestamo(ejemplaresP.get(2),lectoresP.get(3));
//              prestamoData.solicitarPrestamo(ejemplaresP.get(4),lectoresP.get(0));
//              prestamoData.solicitarPrestamo(ejemplaresP.get(5),lectoresP.get(0));
//              prestamoData.solicitarPrestamo(ejemplaresP.get(6),lectoresP.get(0));//tiene que dar error
//              prestamoData.solicitarPrestamo(ejemplaresP.get(2),lectoresP.get(2));//tiene que dar error
//              prestamoData.solicitarPrestamo(ejemplaresP.get(4),lectoresP.get(4));//tiene que dar error
//              prestamoData.solicitarPrestamo(ejemplaresP.get(5),lectoresP.get(5));//tiene que dar error
//              prestamoData.solicitarPrestamo(ejemplaresP.get(6),lectoresP.get(6));
//              prestamoData.solicitarPrestamo(ejemplaresP.get(2),lectoresP.get(2));//tiene que dar error
//              prestamoData.solicitarPrestamo(ejemplaresP.get(1),lectoresP.get(4));
//              prestamoData.solicitarPrestamo(ejemplaresP.get(6),lectoresP.get(6));//tiene que dar error
//-------------------------------------------PRUEBA DE METODOS-----------------------------------------
//              ArrayList<Prestamo>prestamoV=(ArrayList)prestamoData.obtenerLectoresConPrestamosVencidos();
//              JOptionPane.showMessageDialog(null, prestamoV.size());  // tiene que dar 0 por que no hay ninguno vencido
                    
//              ArrayList<Prestamo>prestamoVigentesPorLector=(ArrayList)prestamoData.obtenerPrestamosVigentesPorLector(lectoresP.get(0));
//              JOptionPane.showMessageDialog(null, prestamoVigentesPorLector.size()+", "+prestamoVigentesPorLector.get(0).getLector().getApellido()); //tiene que dar 3  y mustra el apellido del lector
                
//              ArrayList<Prestamo>prestamoPorFecha=(ArrayList)prestamoData.obtenerPrestamosPorFecha(LocalDate.now());//consultamos dentro de este mes
//              JOptionPane.showMessageDialog(null, prestamoPorFecha.size()+", "+prestamoPorFecha.get(0).getFechaPrestamo()); //tiene que dar 6 y muestra la fecha del prstamo
                
              ArrayList<Prestamo>p=(ArrayList)prestamoData.obtenerPrestamos(); //obtiene todos los prestamos
//              JOptionPane.showMessageDialog(null, p.size()); // tiene que dar 6 O menos o mas dependiendo cuantos alla
//              Prestamo p1 = p.get(0);
//              Prestamo p2 = p.get(1);
//              Prestamo p3 = p.get(2);
//              Prestamo p4 = p.get(3);
//              Prestamo p5 = p.get(4);
//              Prestamo p6 = p.get(5);
//              p1.setFechaPrestamo(LocalDate.of(2021, 1, 1)); //cumple mas de un mes 
//              p2.setFechaPrestamo(LocalDate.of(2021,5,5));  // cumple mas de 30 dias
//              p3.setFechaPrestamo(LocalDate.of(2021,5,30));
//              prestamoData.actualizarPrestamo(p1);  //actualiza la fecha de los prestamos
//              prestamoData.actualizarPrestamo(p2);  //actualiza la fecha de los prestamos
//              prestamoData.actualizarPrestamo(p3);  //actualiza la fecha de los prestamos
//              ArrayList<Prestamo>prestamoPorFecha=(ArrayList)prestamoData.obtenerPrestamosPorFecha(LocalDate.now());//consultamos dentro de este mes
//              JOptionPane.showMessageDialog(null, prestamoPorFecha.size()+", "+prestamoPorFecha.get(0).getFechaPrestamo()); //tiene que dar 3 y muestra la fecha del prstamo

//              ArrayList<Lector>lectoresConPrestamoVencido=(ArrayList)prestamoData.obtenerLectoresConPrestamosVencidos();
//              JOptionPane.showMessageDialog(null, lectoresConPrestamoVencido.size()+", "+lectoresConPrestamoVencido.get(0).getApellido()); 
                    
                

//              prestamoData.revisionDePrestamosSinDevolucion(); //revisa todos los prestamos y si correcponde multa la aplica
//              
//              JOptionPane.showMessageDialog(null, prestamoData.obtenerLectoresConMultas().get(0).getApellido());
//              
//              prestamoData.devolverPrestamo(p.get(0));
//              prestamoData.solicitarPrestamo(ejemplaresP.get(0), lectoresP.get(0));
//

//FUNCIONANDO TODO COMO CORRESPONDE
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null, "Problema con los drivers de conexion.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema con la conexion de la Bases de Datos.");
        }
    }
    
}
