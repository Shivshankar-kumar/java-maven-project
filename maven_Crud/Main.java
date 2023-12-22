package maven_Crud;

import java.util.Scanner;

public class Main {
    public static void adminModule(){
        Scanner sc=new Scanner(System.in);
    int option;
    System.out.println("\n ---- Admin module ----\n");
    System.out.println("\t1.Create");
    System.out.println("\t2.Read");
    System.out.println("\t3.Update");
    System.out.println("\t4.Delete");
    System.out.println("\t5.Exit");
    System.out.println();
    try {
        System.out.print("Choose option---->> ");
        option=sc.nextInt();
        if(option<0){
            System.out.println("\n\t'Kindly choose your option from 1 to 5.'\n");
            adminModule();
        }else if(option==1){
        std_Create.create();
    }else if(option==2){
        std_Read.read();
    }else if(option==3){
        std_Update.update();
    }else if (option==4) {
        std_Delete.delete();
    }else if(option==5){
        System.out.println("\n\t'Thanks for Visiting this module.'\n");
        System.exit(0);
    }else{
        System.out.println("\n\t'Kindly choose your option from 1 to 5.'\n");
        adminModule();
    }
}
catch (Exception e) {
    System.out.println("\n\t'Kindly choose your option from 1 to 5.'\n");
    adminModule();
}finally{
    sc.close();
}

    }
public static void main(String[] args) {
    adminModule();
    }
}
