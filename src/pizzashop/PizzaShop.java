/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzashop;

import java.util.Scanner;

/**
 * Review class for Final Exam Part D review. Creates a pizza of a given type
 * and cuts it into slices. Note that the following source was used as a
 * reference in creating this example: Freeman, E.Freeman, E., Sierra, K., &
 * Bates, B. (2004). Head First Design patterns. Sebastopol, CA: O'Reilly.
 *
 * @author dancye, 2019
 */
public class PizzaShop {

    private static PizzaCutter pizzaCutter = PizzaCutter.getInstance();//we only ever want one 
    // of these. The pizza shop takes consistency very seriously
    //and all pizzas must be cut by the same cutter.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the pizza shop");
        System.out.println("What kind of pizza do you want?");
        System.out.println("Please enter exactly cheese or pepperoni");
        String type = sc.nextLine().toLowerCase();

        if (type.equals("cheese") || type.equals("pepperoni")) {
            PizzaFactory pf = new PizzaFactory();
            Pizza pizza = pf.createPizza(type);

            if (pizza != null) {
                System.out.println("How many slices would you like?");
                int numSlices = sc.nextInt();
                // Remove "pizzaCutter." from numSlices assignment
                pizzaCutter.setNumSlices(numSlices);
                System.out.println("Great job, here is your " + type + " pizza in " + numSlices + " slices");
            } else {
                System.out.println("Sorry, we couldn't create your pizza.");
            }
        } else {
            System.out.println("Enter a valid pizza type (cheese or pepperoni) so we can cut it next time!");
        }
    }

}
