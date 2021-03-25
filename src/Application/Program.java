package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try 
		{
			System.out.print("Número do quarto: ");
			int num = sc.nextInt();
			System.out.print("Data de check in: ");
			Date ci = sdf.parse(sc.next());
			System.out.print("Data de check out: ");
			Date co = sdf.parse(sc.next());
			
			Reserva reserv = new Reserva(num, ci, co);
			System.out.println("Reserva:" + reserv);
			
			//Atualização da reserva
			System.out.println("Entre com a data de atualização da reserva");
			System.out.print("Data de check in: ");
			ci = sdf.parse(sc.next());
			System.out.print("Data de check out: ");
			co = sdf.parse(sc.next());
			
			reserv.updateDias(ci, co);
			System.out.println("Reserva: " + reserv);
		} 
		catch(ParseException e) 
		{
			System.out.println("Formato de data inválida");
		}
		catch(DomainException b)
		{
			System.out.println("Erro na reserva: " + b.getMessage());
		}
		catch (RuntimeException e) 
		{
			System.out.println("Erro inesperado!");
		}
		
		
		
		
		
		sc.close();
	}

}
