public class EMI {
	private double loanAmount;
	private double interestRate;
	private int noYears;
	private double emi;
	
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public int getNoYears() {
		return noYears;
	}
	public void setNoYears(int noYears) {
		this.noYears = noYears;
	}
	
	public void calculateEMI() {
		long timePeriod = this.getNoYears()*12;
		double convertedRate = (this.getInterestRate()/ 12)/100;
		double timeFactor = Math.pow((1 + convertedRate), timePeriod);
		double emi = (this.getLoanAmount() * convertedRate * timeFactor)/(timeFactor - 1);
		double roundedEmi = Math.round(emi*100.0)/100.0;
		this.setEmi(roundedEmi);
	}
}
