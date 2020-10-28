
public class SIP {
	private double amount;
	private int time;
	private double rate;
	private double sip;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public double getSip() {
		return sip;
	}
	public void setSip(double sip) {
		this.sip = sip;
	}
	
	public void calculateSIP() {
		int timeInMonths = this.getTime()*12;
		double i = (this.getRate()/100)/12;
		double newI = 1 + i;
		double intermediate = (newI * timeInMonths - 1)/i;
		//double intermediate = (Math.pow(newI , timeInMonths) - 1)/i;
		double sip = this.getAmount()*intermediate*newI;
		double roundedSIP = Math.round(sip*100.0)/100.0;
		this.setSip(roundedSIP);
	}
}
