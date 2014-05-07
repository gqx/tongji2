package excel;

public class MyClass {
	private String name;
	private String school;
	private int ASum;
	private int BSum;
	private int CSum;
	private int sum;
	private double APersent;
	private double BPersent;
	private double CPersent;
	
	public MyClass(){
		ASum = 0;
		BSum = 0;
		CSum = 0;
		APersent = 0;
		BPersent = 0;
		CPersent = 0;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getASum() {
		return ASum;
	}

	public void setASum(int aSum) {
		ASum = aSum;
	}

	public int getBSum() {
		return BSum;
	}

	public void setBSum(int bSum) {
		BSum = bSum;
	}

	public int getCSum() {
		return CSum;
	}

	public void setCSum(int cSum) {
		CSum = cSum;
	}

	public double getAPersent() {
		APersent = (double)ASum/(double)(sum); 
		return APersent;
	}

	public void setAPersent(double aPersent) {
		APersent = aPersent;
	}

	public double getBPersent() {
		BPersent = (double)BSum/(double)(sum); 
		return BPersent;
	}

	public void setBPersent(double bPersent) {
		BPersent = bPersent;
	}

	public double getCPersent() {
		CPersent =(double)CSum/(double)(sum); 
		return CPersent;
	}

	public void setCPersent(double cPersent) {
		CPersent = cPersent;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	
	
}
