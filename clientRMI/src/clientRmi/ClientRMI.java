/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientRmi;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ClientRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            IDao<Machine> dao = (IDao<Machine>) Naming.lookup("rmi://localhost:1099/dao");
           IDao<Salle> dao2 = (IDao<Salle>) Naming.lookup("rmi://localhost:1099/dao2");
            Salle s1 = new Salle("salle1");
            Salle s2 = new Salle("salle2");
             dao2.create(s1);
             dao2.create(s2);
             for(Salle s : dao2.findAll())
                System.out.println(s);  
            
            dao.create(new Machine("machine1", "HP", 10000, s1));
            dao.create(new Machine("machine1", "HP", 10000, s2));
            
            
            for(Machine m : dao.findAll())
                System.out.println(m);  
        } catch (NotBoundException ex) {
    
            Logger.getLogger(ClientRMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientRMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
