/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BankAccount {

	private int accNo;
	private double balance=1000;
	private String name;
	private Gender gender;
	private final double  taxRateM=10.5;
	private final double  taxRateF=10.0;
	public double getTaxRateM() {
		return taxRateM;
	}
	public double getTaxRateF() {
		return taxRateF;
	}
	public enum Gender{ 
		MALE,FEMALE
	};
	//public BankAccount
	public static Scanner sc = new Scanner(System.in);
	public void init(){
		System.out.println("Enter Your Account No ");
		
		this.accNo = sc.nextInt();
	}
	public void deposit(){
		System.out.println("Enter Your deposit money");
		balance = balance+sc.nextDouble();
	}
	public void withdraw() throws InsufficientBalance{
		System.out.println("Enter Your withdrawl money");
		double d = sc.nextDouble();
		if(this.balance<d){
			throw new InsufficientBalance("insufficient money in your account for withdrawl");
			//System.out.println();
		}else{
			balance = balance-d;
		}
	}
	public void createAccount(){
		System.out.println("Enter your Name: ");
		this.setName(sc.nextLine().trim());  
		System.out.println("Enter your Sex(M/F) ");
		String tempSex = sc.nextLine().trim().toUpperCase();
		if(tempSex.equals("M")){
			this.setGender(Gender.MALE);
		}else if(tempSex.equals("F")){
			this.setGender(Gender.FEMALE);
		}
		System.out.println("Enter your Account No");
		this.setAccNo(sc.nextInt());
		System.out.println("Enter initial amount" );
		this.setBalance(sc.nextDouble());
		//this.balance = sc.nextDouble();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public void display(){
		double taxtRate=0.0;
		System.out.println("Name: "+this.name);
		System.out.println("Gender: "+this.gender);
		System.out.println("Account No : "+this.accNo);
		System.out.println("Balance: "+this.balance);
		if(this.gender.equals(Gender.MALE)){
			taxtRate =this.taxRateM;
		}else{
			taxtRate = this.taxRateF;
		}
		System.out.println("Applicable tax rate: "+taxtRate);
	}
	
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
public static void main(String []args){
	BankAccount bac = new BankAccount();
	
	String str;
	String yn="N";
  	int  choice=0;
	do{
		System.out.println("Choose options:");
		System.out.print("1.\t Create Account\n");
		System.out.print("2.\t Deposit money\n");
		System.out.print("3.\t WithDraw money\n");
		System.out.print("4.\t view Account Details\n");
		System.out.print("5.\t view Balance\n");
		System.out.print("6.\t Exit\n");
		System.out.println("Entere Choice: ");
		try{
		    BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));//used for reading from console
            str=obj.readLine();//This method is used to read string from console
            choice=Integer.parseInt(str);
		switch(choice){
			case 1:bac.createAccount();break;
			case 2:bac.deposit();break;
			case 3:try{
				   bac.withdraw();break;
					}catch(InsufficientBalance ex){
					 System.out.println(ex.getMessage());	
					}
			case 4:bac.display();break;
			case 5: System.out.println("your balance is "+bac.getBalance());break;
			case 6:System.out.println("Thank you for visiting");
					System.exit(0);break;
			default: System.out.println("You enter wrong choice");
				//bac.createAccount();
		}
		System.out.println("Do you want more operation(Y/N)");
		 yn = obj.readLine().toUpperCase();
		 if(yn.equals("N")){
			 System.exit(0);
		 }
		}catch(Exception e){
			e.printStackTrace();
		}
	}while(yn.equals("Y")&&choice !=6);
}
	
}

class InsufficientBalance extends Exception {
	public InsufficientBalance(String msg){
	super(msg);
	}
}
