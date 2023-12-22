package maven_Crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class commonEntityManager {

    
    //this is common code which is repeat in every module.
    public static EntityManager userEntityManager(){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("shiva");
        EntityManager em=emf.createEntityManager();
        return em;
    }
}
