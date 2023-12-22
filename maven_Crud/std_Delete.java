
package maven_Crud;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class std_Delete {

    // wrong Attempt counter variable
    public static int count=0;
    
    public static void delete() {
        int id;
        Scanner sc=new Scanner(System.in);
        System.out.println("\n ---- 4. Delete Records ----\n");
        //Handle InputMismatchException
        try {
            count=count+1;
            System.out.print("\tEnter the id Which You Want to Delete: ");
            id=sc.nextInt();

             //Create object to delete
       EntityManager em=commonEntityManager.userEntityManager();
        std_Db sd=em.find(std_Db.class, id);

        EntityTransaction et=em.getTransaction();

         //check condition for student object they should not be null
        // if true then if block executed, otherwise else will executed
        if(sd!=null){
            et.begin();
            em.remove(sd);
            et.commit();
            System.out.println("\n\t'Data Has been Deleted.'");
        }else{
            System.out.println("\n\t'Id doesn't exist, kindly check id number.'");
            //Check condition How many attempted wrong input
            if(count==3){
                System.out.println("\nYou attempted 3 times wrong entry,You are not allowed to delete the entry from database.\n");
                count=0;
                Main.adminModule();
            }else{
                System.out.println("\n\t'You have only "+(3-count)+" attempt.'\n");
            }
            delete();
        }
         }
            catch (Exception e) {
            System.out.println("\n\t'Invalid input, kindly check id number.'");
            //Check condition How many attempted wrong input
            if(count==3){
                System.out.println("\nYou attempted 3 times wrong entry,You are not allowed to delete the entry from database.\n");
                count=0;
                Main.adminModule();
            }else{
                System.out.println("\n\t'You have only "+(3-count)+" attempt.'\n");
            }
            delete();
            }
            //Handle InputMismatchException 
            try {
                 System.out.print("\nDo you want to exit? type [yes/no] ");
            String op=sc.next();
            if(op.equalsIgnoreCase("yes")){
               count=0;
               Main.adminModule();
            }else if(op.equalsIgnoreCase("no")){
               count=0;
               delete();
            }
            } catch (Exception e) {
                System.out.println("\n\t'type [yes/no] to exit.'\n");
                count=0;
                Main.adminModule();
            } finally{
                sc.close();
            }
    }
}
