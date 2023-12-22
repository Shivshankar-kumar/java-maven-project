

//Module-1
//C-->> Create
package maven_Crud;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
public class std_Create {

    //You have only 3 Attempt to add your id in databse
 public static int count=0;

    public static void create(){
        System.out.println("\n ---- 1. Fill Entery ----\n");
        Scanner sc=new Scanner(System.in);
        std_Db st=new std_Db();
        //conter variable
        int id;
        String name,city,mob;
        try {
            count=count+1;
        System.out.print("\tId: ");
        id=sc.nextInt();
        st.setId(id);
        }catch (Exception e) {
            System.out.println("please enter valid id from[0-9]\n");
            if(count==3){
            System.out.println("\nYou attempted 3 times wrong entry,You are not allowed to fill the entry in database.\n");
            count=0;
            Main.adminModule();
        }else{
            System.out.println("\n\t'You have only "+(3-count)+" attempt.'\n");
        }
            //call himself
            create();
           
        }  
        try{
        System.out.print("\tName: ");
        name=sc.next();
        System.out.print("\tCity: ");
        city=sc.next();
        System.out.print("\tMobile: ");
        mob=sc.next();
         st.setName(name);
        st.setCity(city);
        st.setMobile(mob);
        } catch(Exception e){
            System.out.println("Only text is acceptable,Kindly fill your entry again.");

            //check attempts
             if(count==3){
            System.out.println("\nYou attempted 3 times wrong entry,You are not allowed to fill the entry in database.\n");
            count=0;
            Main.adminModule();
        }else{
            System.out.println("\n\t'You have only "+(3-count)+" attempt.'\n");
        }
           create();
           
        }
		EntityManager em=commonEntityManager.userEntityManager();
        //create Transection
        EntityTransaction et=em.getTransaction();
		//start transection
		et.begin();
		
		//add object in db
		em.persist(st);
		//close transection
		et.commit();

         System.out.println("\n\t'Data has been inserted in database.'");
         try {
             System.out.print("\nDo you want to exit? type [yes/no] ");
         String op=sc.next();
         if(op.equalsIgnoreCase("yes")){
            count=0;
            Main.adminModule();
         }else if(op.equalsIgnoreCase("no")){
            count=0;
            create();
         }
         } catch (Exception e) {
            System.out.println("\n\t'type [yes/no] to exit'\n");
            count=0;
            Main.adminModule();
         }finally{
            sc.close();
         }
        }
    }