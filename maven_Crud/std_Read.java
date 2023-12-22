
package maven_Crud;
import java.util.Scanner;

import javax.persistence.EntityManager;

//program to read data from database Using hibernate

public class std_Read {

     //You have only 3 Attempt to fetch your data from databse
 public static int count=0;
    public static void read() {
        
        System.out.println("\n ---- 2. Search id ----\n");
        //object of Scanner
        Scanner sc=new Scanner(System.in);
        int id;
        try{
            count=count+1;
        System.out.print("\tSearch your id here: ");
        id=sc.nextInt();
        //create object
        EntityManager em=commonEntityManager.userEntityManager();
        //find id exist or not?
        std_Db sd= em.find(std_Db.class, id);
        if(sd!=null){
            System.out.println("\n\n\tYour fetching data is..\n"+sd.toString());
            System.out.print("\nDo you want to exit? type [yes/no] ");
         String op=sc.next();
         if(op.equalsIgnoreCase("yes")){
            count=0;
            Main.adminModule();
         }else if(op.equalsIgnoreCase("no")){
            count=0;
            read();
         }
        }else{
            System.out.println("\n\t'Id doesn't exist,therefore data not found.'");
            if(count==3){
                System.out.println("\nYou attempted 3 times wrong entry,You are not allowed to fetch the entry from database.\n");
                count=0;
                Main.adminModule();
            }else{
                System.out.println("\n\t'You have only "+(3-count)+" attempt.'\n");
            }
            read();
        }
         }catch(Exception e){
            System.out.println("\n\t'Search Valid id'");
            if(count==3){
                System.out.println("\nYou attempted 3 times wrong entry,You are not allowed to fetch the entry from database.\n");
                count=0;
                Main.adminModule();
            }else{
                System.out.println("\n\t'You have only "+(3-count)+" attempt.'\n");
            }
            read();
        }
        sc.close();
        
    }
}
