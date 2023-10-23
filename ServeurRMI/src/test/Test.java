/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.IDao;
import entities.Machine;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import util.HibernateUtil;

/**
 *
 * @author hp
 */
public class Test {
     public static void main(String[]  args){
         try {
             IDao<Machine> dao = new MachineService();
             dao.create(new Machine("001", "HPA", 1525.6));
             dao.create(new Machine("002", "HPA", 152.56));
             dao.create(new Machine("003", "HPA", 15.256));
             dao.create(new Machine("004", "HPA", 1.5256));
             for(Machine m : dao.findAll())
                 System.out.println(m);
         } catch (RemoteException ex) {
             Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
         }
            }}
