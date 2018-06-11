package goldmansachs;

public class ATMMachine {

}

class ATMImpl{
	protected ATM atm;
	private ATMImpl(){/*implementation*/}
	public float getBalanceInfo(){ return 1.0f;}
	public ReceiptInfo getReceiptInfo(){return new ReceiptInfo().getReceiptInfo();}
	public boolean deposit(float val){return true;}
	public boolean withdraw(float val){return true;}
	public boolean verifyPIN(int pinVal){return true;}
		
}

class ATM{
	private ATMImpl impl;	//pointer to ATM implementation
	public boolean verifyPIN(int pinVal){return impl.verifyPIN(pinVal);}
	public float getBalance(){return impl.getBalanceInfo();}
	public ReceiptInfo getReceiptInfo(){return impl.getReceiptInfo();}
	public boolean deposit(float val){return impl.deposit(val);}
	public boolean withdraw(float val){return impl.withdraw(val);}
	
}

class ReceiptInfo{
	public ReceiptInfo getReceiptInfo(){
		return new ReceiptInfo();
	}
}