package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	 private Integer numQuarto;
	 private Date checkIn;
	 private Date checkOut;
	 
	 private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	 public Reserva() {
		 
	 }
	 public Reserva(Integer numQuarto, Date checkIn, Date checkOut) {
		this.numQuarto = numQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	 
	public Long duracaoDias() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDias(Date checkIn, Date checkOut) {
		Date now = new Date();
		
		if((checkIn.before(now)) || (checkOut.before(now))) {
			return "Datas de atualização devem ser em datas futuras";
		}
		if(!checkOut.after(checkIn)) {
			return "Erro em reservar: a data de checkout é anterior a de checkin";
		}	
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
	}
	
	@Override
	public String toString() {
		return "Quarto: " + numQuarto + 
				", check in: " + sdf.format(checkIn) +
				", check out: " + sdf.format(checkOut) +
				", duração: " + duracaoDias() + " noite.s";
	}
}
