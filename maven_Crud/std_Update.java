
package maven_Crud;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class std_Update {

   public static int id;
   public static String name,city,mob;
    public static void update() {

        //object of std_Db class
        std_Db sd =new std_Db();
        Scanner sc=new Scanner(System.in);
        System.out.println("\n ---- 3. Update details ----\n");

        //1. if id is invalid then throw exception
        try {
            System.out.print("\tSearch id here for update: ");
            id=sc.nextInt();
        //here calling another method and they returns EntityManager object
        EntityManager em=commonEntityManager.userEntityManager();
         //create transaction object
        EntityTransaction et=em.getTransaction();

        //if sd object is null then this will throw nullException
        //for printing the existing data
        sd=em.find(std_Db.class, id);

        //2. if invalid input like[c^], then throws an exception
         try{
            //print existing data whichever saved on this id there.
            System.out.println("\nBefore updation, data is here.."+"\n"+sd.toString());
        System.out.print("\n\tType new name: ");
        name=sc.next();
        System.out.print("\ttype new city: ");
        city=sc.next();
        System.out.print("\tnew mobile number: ");
        mob=sc.next();
        }catch(NullPointerException ne){  //handle null Exception
            System.out.println("\n\t'Wrong id, Kindly check the id number.'");
            update();
        }catch (Exception e) {  //handle mismatch exception
            System.out.println("'Only text is acceptable,Kindly fill your entry again.'");
            update();
        } //close 2

        //if everything is right then store in database.
        if(sd!=null){
            sd.setName(name);
            sd.setCity(city);
            sd.setMobile(mob);
            //to send the data in db
            et.begin();//start transection
            em.persist(sd);//send object of class
            et.commit();//stop transection
            System.out.println("\n\n\t'Data has been updated.'");
        } 
        }catch(Exception e){ // handle invalid id
            System.out.println("\n\n'please enter valid id from 1 to 9.'\n");
            update();
        } //close 1

        //4 Handle Exception if you type except [yes/no]
        try {
            System.out.print("\nDo you want to exit? type [yes/no] ");
         String op=sc.next();
         if(op.equalsIgnoreCase("yes")){
            Main.adminModule();
         }else if(op.equalsIgnoreCase("no")){
            //redirect on same method
           update();
         }
            } catch (Exception e) {
               System.out.println("\n\t'type [yes/no] to exit.'");
               Main.adminModule();
            }
        finally{
            sc.close();
        }

    }

}
