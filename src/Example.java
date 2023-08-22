/*
//   Interface

import java.util.Scanner;

interface Gun{
    public void fire();
}

class Mg3 implements Gun{
    public void fire(){
        System.out.println("Shoot Mg3");
    }
}

class AK47 implements Gun{
    public void fire(){
        System.out.println("Shoot AK47");
    }
}

class Uzi implements Gun{
    public void fire(){
        System.out.println("Shoot Uzi");
    }
}

class Soilder{

    String name;
    int id;

    Soilder(int id, String name){
        this.id = id;
        this.name = name;
    }

    void shoot1(Gun gun, Soilder soilder){
        System.out.println(soilder.id + " " + soilder.name);
        gun.fire();
    };

    void shoot2(Gun gun, Soilder soilder){
        System.out.println(soilder.id + " " + soilder.name);
        gun.fire();
    };

    void shoot3(Gun gun, Soilder soilder){
        System.out.println(soilder.id + " " + soilder.name);
        gun.fire();
    }


}

class Example{
    public static void main(String[] args) {
        Soilder soilder1 = new Soilder(001, "Jonny");
        Soilder soilder2 = new Soilder(002, "Mac");

        Gun mg3 =  new Mg3();
        Gun ak47 = new AK47();
        Gun uzi = new Uzi();

        soilder1.shoot1(mg3, soilder1);
        soilder1.shoot2(ak47, soilder1);
        soilder2.shoot3(uzi, soilder2);
        soilder2.shoot3(mg3, soilder2);
        soilder2.shoot3(ak47, soilder2);





    }
}






==============



import java.util.Arrays;

interface Animal{}

class Dog implements Animal{
    Dog(String name){
        System.out.println(name);
    }
}

class Cat implements Animal{
    Cat(String name){
        System.out.println(name);
    }
}

class PrintInfo<T>{
    int counter = 0;

    Object[] team = new Object[225];

    public void add(T t){
        team[counter++] = t;
    }

    public void print(){
        System.out.println(Arrays.toString(team));
    }
}

class Example{
    public static void main(String[] args) {
        Dog d1 = new Dog("Elza");
        Cat c1 = new Cat("Graffie");

        PrintInfo<Animal> printInfo = new PrintInfo<>();

        printInfo.add(d1);
        printInfo.add(c1);

        printInfo.print();
    }
}
*/

import java.util.*;

//01
//IV
class Example{

    //Database area
    static String[][] placeOrderDB = new String[100][5];


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        String[] mainMenu = {"Place Order","Search Customer","Search Order","View Reports","Change Order Status"," Delete Order"};

        for(int i=0; i< mainMenu.length; i++){
            System.out.println("["+(i+1)+"] "+mainMenu[i]);
        }

        System.out.print("Select your choice : ");

        int x = input.nextInt();

        switch (x){
            case 1:
                placeOrder();
                break;
            case 2:
//                serchCustomer();
                break;
            case 3:
//                serachOrder();
                break;
            case 4:
//                viewReports();
                break;
            case 5:
//                changeOrderStatus();
                break;
            case 6:
//                deleteOrder();
                break;
            default:
                return;
        }
    }

    public static void placeOrder(){
        String contactNo, shirtSize, orderStatus, orderId;
        int qty;
        double amount;
        char orderYesNo;

        Scanner input = new Scanner(System.in);

        while(true){

            orderId = genarateOrderID();
            System.out.println("Order ID : ODR#" + orderId);

            System.out.print("Enter Customer Contact Number : ");
            contactNo = input.nextLine();

            System.out.print("Enter T-Shirt Size (XS/S/M/L/XL/XXL) : ");
            shirtSize = input.nextLine();

            System.out.print("Enter QTY : ");
            qty = input.nextInt();

            amount = calculateOrderAmount(qty, shirtSize);
            System.out.println("Amount : " + amount);

            System.out.print("Do you want to place this order? (y/n) : ");
            orderYesNo = input.nextLine().charAt(0);
            orderYesNo=saveOrNotPlaceOrder(orderYesNo);



        }

    }

    public static char saveOrNotPlaceOrder(char orderYesNo){
        switch ('y'){
            case 'y':
                savePlaceOrder();
                return 1;
                break;
        }
    }

    public static String genarateOrderID(){
        for(int i=0; i<placeOrderDB.length; i++){
            if(placeOrderDB[i][0]!=null){
                if(i<10){
                    return "0000"+i;
                } else if(i>=10&&i<100){
                    return "000"+i;
                } else if(i>=100&&i<1000){
                    return "00"+i;
                } else if(i>=1000&&i<10000){
                    return "0"+i;
                }
                return ""+i;
            }
        }
        return null;
    }

    public static double calculateOrderAmount(int qty, String shirtSize){
        if(shirtSize=="XL"){
            return 600 * qty;
        } else if (shirtSize=="S"){
            return 800 * qty;
        } else if(shirtSize=="M"){
            return 900 * qty;
        } else if(shirtSize=="L"){
            return 1000 * qty;
        } else if(shirtSize=="XL"){
            return 1100 * qty;
        } else if(shirtSize=="XXL"){
            return 1200 * qty;
        }
        return 0;

    }


}


