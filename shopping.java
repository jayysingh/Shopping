package practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class shopping {
    public static HashMap<String, Integer> discount(int a, int b, int c) {
        HashMap<String, Integer> resultMap = new HashMap<>();
        int amountA = a*20;
        int amountB = b*40;
        int amountC = c*50;
        int totalAmount = amountA+amountB+amountC;

        //  if flat_10_discount Applicable
        int quantity = a+b+c;
        if(totalAmount>200){
            resultMap.put("flat_10_discount", 10);
        }
        // if bulk_5_discount Applicable
        if(a>10||b>10||c>10){
            if(a>10){
                int d2 = (amountA*5)/100;
                resultMap.put("bulk_5_discount",d2);
            } else if (b>10) {
                int d2 = (amountB*5)/100;
                resultMap.put("bulk_5_discount",d2);
            }else {
                int d2 = (amountC*5)/100;
                resultMap.put("bulk_5_discount",d2);
            }
        }

        // if bulk_10_discount Applicable
        if(quantity>20){
            int d3 = (totalAmount*10)/100;
            resultMap.put("bulk_10_discount",d3);
        }
        // if tiered_50_discount is Applicable
        if(quantity>30 && (a>15||b>15||c>15)){
            int d4;
            if(a>b && a>c){
                d4 =(a-15)*10;
                resultMap.put("tiered_50_discount",d4);
            } else if (b>c) {
                d4 =(b-15)*20;
                resultMap.put("tiered_50_discount",d4);
            }
            else{
                d4 =(c-15)*25;
                resultMap.put("tiered_50_discount",d4);
            }

        }
        return resultMap;



    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantity of Product A");
        int productA = sc.nextInt();

        System.out.println("Quantity of Product B");
        int productB = sc.nextInt();

        System.out.println("Quantity of Product C");
        int productC = sc.nextInt();





        int amountA = productA*20;
        int amountB = productB*40;
        int amountC = productC*50;
        int totalAmount = amountA+amountB+amountC;

        int quantity = productA+productB+productC;
//






        int shipping_fee =(quantity%10!=0)?((quantity/10)+1)*5:(quantity/10)*5;

        System.out.println("Product A" + " "+ productA +" "+ "Amount "+" "+ amountA );
        System.out.println("Product B" + " "+ productB +" "+ "Amount "+ " "+amountB );
        System.out.println("Product C" + " "+ productC +" "+ "Amount "+" "+ amountC );

        System.out.println("Sub Total " + " "+ totalAmount );

        System.out.println("Do you want gift wrap");

        String inputString = sc.next();

        // Use if-else statement to make a decision based on the input





        HashMap<String, Integer> resultMap = discount(productA, productB, productC);
        // iterate each entry of hashmap
//        int max = Integer.MIN_VALUE;
//        for(Entry<String, Integer> entry: resultMap.entrySet()) {
//            if (entry.getValue() > max) {
//                max = entry.getValue();
//            }
//        }
        int maxDiscount = Integer.MIN_VALUE;
        String k = "";
        for (Map.Entry<String, Integer> entry: resultMap.entrySet())
        {
            if (entry.getValue() > maxDiscount) {
              k = entry.getKey();
            maxDiscount = entry.getValue();
          }


        }
        System.out.println(k + "=" + maxDiscount);
        System.out.println("Shipping fee is: "+ shipping_fee);
        if (inputString.equals("yes")) {
            System.out.println("giftwrap fee is: "+quantity);
        }
        int total = totalAmount-maxDiscount + quantity + shipping_fee;
        System.out.println("total amount :"+ total);


    }


}

