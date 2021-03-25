package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int num = sc.nextInt();
		System.out.print("Data de check in: ");
		Date ci = sdf.parse(sc.next());
		System.out.print("Data de check out: ");
		Date co = sdf.parse(sc.next());
		
		if(!co.after(ci)) {
			System.out.println("Erro em reservar: a data de checkout é anterior a de checkin");
		}else{
			Reserva reserv = new Reserva(num, ci, co);
			System.out.println("Reserva:" + reserv);
			
			//Atualização da reserva
			System.out.println("Entre com a data de atualização da reserva");
			System.out.print("Data de check in: ");
			ci = sdf.parse(sc.next());
			System.out.print("Data de check out: ");
			co = sdf.parse(sc.next());
			
			String erro = reserv.updateDias(ci, co);
			
			if(erro != null) {
				System.out.println("Erro em reservar: " + erro);
			}else {
				System.out.println("Reserva: " + reserv);
			}
		}
		
		
		
		
		
		sc.close();
	}

}
