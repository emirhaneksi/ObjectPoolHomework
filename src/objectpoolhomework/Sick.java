/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objectpoolhomework;

import java.lang.Thread;

public class Sick extends Thread {

    public Sick() {}

    public void run() {
        try {
            while(true){
                Doctor doctor = DoctorPool.getDoctor().fillPool();
                //Müsait doktorlar varsa
                if(doctor != null){
                    Thread.sleep(1000);
                    doctor.toCure();
                    DoctorPool.getDoctor().unloadPool(doctor);

                    break;
                }
                //Tüm doktorlar meşgul ise
                else{
                    Thread.sleep(2000);
                    System.out.println("Tüm doktorlar meşgul");
                }
            } 
        }
        catch (Exception err) {
            System.out.println("Error: " + err);
        }
    }
}
