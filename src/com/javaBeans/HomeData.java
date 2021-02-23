package com.javaBeans;

import java.util.HashMap;

public class HomeData {
    private int usersNbr;
    private int appointmentNbr;
    private int nxtAppointmentNbr;
    private int doneConsultations;
    private HashMap<String,Integer> monthData;

    public HomeData(HashMap<String, Integer> monthData) {
        this.monthData = monthData;
    }

    public HashMap<String, Integer> getMonthData() {
        return monthData;
    }

    public void setMonthData(HashMap<String, Integer> monthData) {
        this.monthData = monthData;
    }

    public HomeData(int usersNbr, int appointmentNbr, int nxtAppointmentNbr, int doneConsultations) {
        this.usersNbr = usersNbr;
        this.appointmentNbr = appointmentNbr;
        this.nxtAppointmentNbr = nxtAppointmentNbr;
        this.doneConsultations = doneConsultations;
    }

    public HomeData() {

    }

    public int getUsersNbr() {
        return usersNbr;
    }

    public void setUsersNbr(int usersNbr) {
        this.usersNbr = usersNbr;
    }

    public int getAppointmentNbr() {
        return appointmentNbr;
    }

    public void setAppointmentNbr(int appointmentNbr) {
        this.appointmentNbr = appointmentNbr;
    }

    public int getNxtAppointmentNbr() {
        return nxtAppointmentNbr;
    }

    public void setNxtAppointmentNbr(int nxtAppointmentNbr) {
        this.nxtAppointmentNbr = nxtAppointmentNbr;
    }

    public int getDoneConsultations() {
        return doneConsultations;
    }

    public void setDoneConsultations(int doneConsultations) {
        this.doneConsultations = doneConsultations;
    }

    @Override
    public String toString() {
        return "HomeData{" +
                "usersNbr=" + usersNbr +
                ", appointmentNbr=" + appointmentNbr +
                ", nxtAppointmentNbr=" + nxtAppointmentNbr +
                ", doneConsultations=" + doneConsultations +
                ", monthData=" + monthData +

                '}';
    }
}
