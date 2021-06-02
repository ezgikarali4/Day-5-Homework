package day5Homework.entities.concretes;

public class VerificationCode {

	public int verificationCode = (int)(Math.random()*1000000);
	
	public VerificationCode(User user) {
		
	}

	public VerificationCode(int verificationCode) {
		super();
		this.verificationCode = verificationCode;
	}

	public int getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(int verificationCode) {
		this.verificationCode = verificationCode;
	}
}
