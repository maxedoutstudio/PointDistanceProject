// ------------------------------------------------------------ 
 // Assignment # 2
 // File name: assignment2_7391587
 // Written by: Maksym Perepichka ID# 7391587
 // For Comp 248 Section EE /Fall 2014 
 // ------------------------------------------------------------ 


/* This program simulates a Diner where a user can user can order various items and gives  discounts 
 *  depending on variables such as the user's name, what he orders and how much he orders. */

import java.util.Scanner;

public class assignment2_7391587 {

	public static void main(String[] args) {
		
		//This part initiates the scanner object to be used to take user input
		Scanner keyboard  = new Scanner(System.in);
		
		//Sets constants such as taxrate and prices, so if they change, it is easier to modify the program.
		final float TAXRATE = 0.07f, HAMBURGERPRICE = 2.59f, FRIESPRICE = 1.50f, DRINKPRICE = 0.97f;
		
		System.out.println("----------------------------------------------------");
		System.out.println("             Welcome to the Mac248 Diner");
		System.out.println("----------------------------------------------------");
		
		System.out.println("What is your name?");
		
		//This takes the name from the user and renders it uppercase
		String input = keyboard.next();
		String name = input.substring(0,1).toUpperCase() + input.substring(1);
		
		//This part takes orders from the customer and puts them into ints
		System.out.println("Well " + name + ", remeber to be eligible to win you need to order at leastone of everything");
		System.out.println("We are ready for your order:");
		System.out.print("\tHow many hamburgers do you want? ");
		int hamburgers = keyboard.nextInt();
		System.out.print("\tHow many orders of French Fries do you want? ");
		int fries = keyboard.nextInt();
		System.out.print("\tHow many drinks do you want? ");
		int drinks = keyboard.nextInt();
		
		//This declares the booleans that will be used to store whether or not the person has won. Used to give away prizes.
		boolean freeOrder = false, freeDrink = false, noTax = false;
		
		//This part calculates the subTotals for each item
		float subHamburgers = (hamburgers*HAMBURGERPRICE), subFries = (fries*FRIESPRICE), subDrinks = (drinks*DRINKPRICE);
		
		//This part does the testing for the three types of winners, and sets the appropriate boolean to true if they win
		if ((hamburgers >= 1) && (fries >= 1) && (drinks >= 1)){
			if (((name.charAt(0) + name.charAt(name.length() - 1)) % 7) == 0){
				freeOrder = true;
			}
			else if ((((hamburgers + fries + drinks) % 7) == 0) && (((int)(hamburgers*HAMBURGERPRICE)) % 7 == 0)){
				noTax = true;
			}
			else if ((hamburgers + fries + drinks) % 7 == 0){
				freeDrink = true;
				subDrinks -= DRINKPRICE; //We do this here because unlike the other "prizes", this one needs to apply before the subtotal
			}
		}
		
		//Calulates the subtotal
		float subTotal = subHamburgers + subFries + subDrinks;
		
		//Calulates the tax
		float tax = 0;
		if (!noTax){
			tax = (subTotal*TAXRATE);
		}
		//Calculates the total
		float total = 0;
		if (!freeOrder){
			total = subTotal + tax;
		}
		
		//Invoice begins here
		
		System.out.println("Your invoice:");
		System.out.println("============");
		
		System.out.println("\tNumber of hamburgers:   " + hamburgers + "\t" + hamburgers + " x $" + HAMBURGERPRICE + " =\t$" + String.format("%.2f",(subHamburgers)));
		System.out.println("\tNumber of French fries: " + fries + "\t" + fries + " x $" + String.format("%.2f", FRIESPRICE) + " =\t$" + String.format("%.2f",(subFries)));
		
		if (!freeDrink){
			System.out.println("\tNumber of drinks:       " + drinks + "\t" + drinks + " x $" + DRINKPRICE + " =\t$" + String.format("%.2f",(subDrinks)));
		} else {
			System.out.println("\tNumber of drinks:       " + drinks + "\t" + (drinks-1) + " x $" + DRINKPRICE + " =\t$" + String.format("%.2f",(subDrinks)));
			System.out.println("\t Congratulations! " + name + ", you have won a free drink! Value of $" + DRINKPRICE);
		}
		//Was just testing ways to indent without using \t or tons of spaces here...
		for(int i = 1;i <= 56;i++)
			System.out.print(" ");
		System.out.println("------");
		
		System.out.println("\t\t\t        Subtotal:\t\t$" + String.format("%.2f",subTotal));
		System.out.println("\t\t\t        Sales Tax:\t        $" + String.format("%.2f",tax));
		
		if (noTax)
			System.out.println("\t Congratulations! " + name + ", the tax on your order is on us! Value of $" + tax);
		
		for(int i = 1;i <= 56;i++)
			System.out.print(" ");
		System.out.println("------");
		
		System.out.println("\t\t\t        Total:    \t        $" + String.format("%.2f",total));
		
		if(freeOrder)
			System.out.println("\t Congratulations! " + name + ", you are the Grand Winner!!!! Your order is free! Value of $" + String.format("%.2f",subTotal + tax));
		else if(!noTax && !freeDrink)
			System.out.println("\t Better luck next time " + name + "!!!");
		
		System.out.println("\n" + name + ", the Mac248 Diner thanks you for your patronage.");
		
		
		
		
	}

}
