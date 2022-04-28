/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objectpoolhomework;

import java.util.ArrayList;

public class DoctorPool {
    private static DoctorPool doctorPool ;
    private int numOfDoctor = 10;
    public ArrayList<Doctor> free = new ArrayList<>(numOfDoctor);
    public ArrayList<Doctor> used = new ArrayList<>(numOfDoctor);

    private DoctorPool(){
        
    }

    public static DoctorPool getDoctor(){
        synchronized (DoctorPool.class) {
            if(doctorPool == null){
                doctorPool = new DoctorPool();
            }
            return doctorPool;
        }

    }
    synchronized
    public Doctor fillPool(){
        Doctor doctor = null;
        if(free.size() > 0 && free.size() <= numOfDoctor){
            doctor = free.remove(0);
            used.add(doctor);
        }
        else if(used.size() != numOfDoctor){
            doctor = new Doctor();
            used.add(doctor);
        }
        return doctor;
    }
    synchronized
    public void unloadPool(Doctor doctor){
        if(free.size() < numOfDoctor){
            free.add(doctor);
            used.remove(doctor);
        }
    }

}
