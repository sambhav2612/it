package stack;



/**
 *
 * @author my
 */

import java.util.ArrayList;
import java.util.Scanner;

abstract class Stack
{
   abstract public void push(int n);
   abstract public int pop();
   abstract public void display();
}

class DynamicStack extends Stack
{
    ArrayList<Integer> stk;
    public DynamicStack()
    {
      stk= new ArrayList<>();
    }
    @Override
    public void push(int n)
    {
        stk.add(n);
    }
    @Override
    public int pop()
    {
        if(stk.size()>0)
        {
            int n= stk.get(stk.size()-1);
        stk.remove(stk.size()-1);
        return n;
        }
        else
        {
        System.out.println("Stack underflow i.e empty");
        return 0;                     
        }
    }
    @Override
    public void display()
    {
      System.out.println("Contents of stack");
      for(int n=stk.size()-1;n>=0;n--)
      {
         System.out.print(stk.get(n)+" ");
      }
    }
}

class StaticStack extends Stack {
    
    private final int[] stack;
    private final int size;
    private int SP = -1;
    
    public StaticStack(int size){
        this.size = size;
        stack = new int[size];
    }
    
    @Override
    public void push(int data){
        if(SP<size-1){
            stack[++SP] = data;
            
        }
        else{
            throw new ArrayIndexOutOfBoundsException("Stack Overflow.");
        }
    }
    
    @Override
    public int pop(){
        if(SP>-1){
            return stack[SP--];
        }
        else{
            throw new ArrayIndexOutOfBoundsException("Stack Underflow.");
        }
    }
    
    @Override
    public void display(){
        if(SP==-1){
            System.out.println("Stack is empty");
        }
        else{
            for(int i=SP;i>-1;i--){
                System.out.println(stack[i]);
            }
        }
    }
    
    
}

 class StackTest{
	
    public static void main(String[] args){
       StaticStack sstack = new StaticStack(20); 
       DynamicStack dstack= new DynamicStack();
       Scanner sc= new Scanner(System.in);
       int ch1,ch2;
       char c='y';
       do
       {

            System.out.println("Enter your choice");
            System.out.println("1.Static Stack.");
            System.out.println("2.Dynamic Stack.");
	
            ch1=sc.nextInt();

            switch(ch1){

                case 1:

                    do{
                        System.out.println("Enter yout choice:");
                        System.out.println("1.push a item onto stack");
                        System.out.println("2.pop a item from stack");
                        System.out.println("3.display the content of stack");
                        ch2= sc.nextInt();
                        switch (ch2)
                        {
                            case 1: System.out.println("enter no to push onto stack");
                                    int k=sc.nextInt();
                                    try{
                                        sstack.push(k);
                                    }
                                    catch(ArrayIndexOutOfBoundsException exception){
                                    System.out.println(exception.getMessage());
                                    }
                                break;
                            case 2: int l;
                                    try{
                                        l=sstack.pop();
                                        System.out.println("The element popped"+l);
                                    }
                                    catch(ArrayIndexOutOfBoundsException exception){
                                        System.out.println(exception.getMessage());
                                    }
                                break;
                            case 3: sstack.display();
                                break;
                            default: System.out.println("Wrong choice");
                        }
                        System.out.println("do you wish to continue(y/n)");
                        c=sc.next().charAt(0);
                    }while(c=='y');
                break;

                case 2:
                    do{
                        System.out.println("Enter yout choice:");
                        System.out.println("1.push a item onto stack");
                        System.out.println("2.pop a item from stack");
                        System.out.println("3.display the content of stack");
                        ch2 = sc.nextInt();
                        switch (ch2)
                        {
                            case 1: System.out.println("enter no to push onto stack");
                                    int k=sc.nextInt();
                                    dstack.push(k);
                                break;
                            case 2: int l=dstack.pop();
                                    if(l!=0)
                                        System.out.println("Popped item: "+l);
                                break;
                            case 3: dstack.display();
                                break;
                            default: System.out.println("Wrong choice");
                                break;
                        }
                        System.out.println("do you wish to continue(y/n)");
                        c=sc.next().charAt(0);
                    }while(c=='y');
                    break;
                default: System.out.println("Wrong Choice.");
                    break;
            }
            System.out.println("do you wish to try it again : continue(y/n)");
            c=sc.next().charAt(0);
        }while(c=='y');
    }
}
