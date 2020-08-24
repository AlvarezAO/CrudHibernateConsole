package cl.alvarez.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cl.alvarez.model.Empleado;

public class MainApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		
		System.out.println("Menu");
		System.out.println("\n1- Agregar Empleado \n2- Editar Empleado \n3- Eliminar Empleado \n4- Ver Empleados");
		
		int choice = scan.nextInt();
		scan.nextLine();
		
		session.beginTransaction();
		
		if(choice == 1) {
			Empleado emp = new Empleado();
			System.out.println("Ingresa el nombre");
			emp.setNombre(scan.nextLine());
			System.out.println("Ingresa el apellido");
			emp.setApellido(scan.nextLine());
			System.out.println("Ingresa la compañia");
			emp.setCompany(scan.nextLine());
			
			
			session.save(emp);
			session.getTransaction().commit();
			
		} else if (choice == 2) {
			System.out.println("Ingresa el ID del usuario");
			int idRecovery = scan.nextInt();
			scan.nextLine();
			Empleado myEmp = session.get(Empleado.class, idRecovery);
			System.out.println("El empleado a editar es: " + myEmp.toString());
			System.out.println("\nNombre: ");
			myEmp.setNombre(scan.nextLine());
			System.out.println("\nApellido: ");
			myEmp.setApellido(scan.nextLine());
			System.out.println("\nCompañia");
			myEmp.setCompany(scan.nextLine());
			session.update(myEmp);
			session.getTransaction().commit();
			System.out.println("\n\nEmpleado Actualizado Correctamente");
			System.out.println(myEmp.toString());
			
		} else if(choice == 3) {
			System.out.println("Ingresa el ID del usuario");
			int idDestroy = scan.nextInt();
			scan.nextLine();
			Empleado myEmp = session.get(Empleado.class, idDestroy);
			System.out.println("El empleado a eliminar es: " + myEmp.toString());
			System.out.println("¿Confirma que quiere eliminar?");
			String confirm = scan.nextLine();
				if(confirm.equalsIgnoreCase("si")) {
					session.delete(myEmp);
					session.getTransaction().commit();
				} else {
					System.out.println("Ha decidido no borrar");
				}
			
		} else if (choice == 4) {
			List<Empleado> empList = session.createQuery("from Empleado order by id").getResultList();
			
			for(Empleado lista: empList) {
				System.out.println(lista);
			}
		}
		
		
		session.getTransaction();
		

	}

}
