package com.DAO;
import com.javaBeans.HomeData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Year;
import java.util.HashMap;


public class DoctorDAO implements DoctorService{
    private DbConfigDAO dbInstance;
    private Connection connection;
    private PreparedStatement preStat;
    private ResultSet result;
    private String query;
    private HomeData homeData;
    @Override
    public HomeData getData() {
        homeData = new HomeData();
        Year thisYear = Year.now();
        HashMap<String,Integer> monthData = new HashMap<>();

        try {
            // get database connection
            dbInstance = DbConfigDAO.getInstance();
            Connection connection = dbInstance.getConnection();

            // prepare statement
            PreparedStatement qs ;

            // queries for the above part of the page
            String userQuery = "SELECT COUNT(*) AS userNbr FROM user";
            String apoinQuery = " SELECT COUNT(*)   AS  appointmentNbr FROM appointment";
            String nxtQuery = " SELECT COUNT(*)   AS  NxtAppointmentNbr FROM appointment WHERE DateofAppointment > SYSDATE()";
            String doneQuery = " SELECT COUNT(*)  AS  doneConsultations FROM  consultation";

            // queries for the chart in the bottom
            String janQuery = "SELECT COUNT(*) AS janQuery FROM consultation WHERE ConsultationDate > '"+thisYear+"-01-01' AND ConsultationDate < '"+thisYear+"-02-01'  ";
            String febQuery = "SELECT COUNT(*) AS febQuery FROM consultation WHERE ConsultationDate > '"+thisYear+"-02-01' AND ConsultationDate < '"+thisYear+"-03-01'  ";
            String marQuery = "SELECT COUNT(*) AS marQuery FROM consultation WHERE ConsultationDate > '"+thisYear+"-03-01' AND ConsultationDate < '"+thisYear+"-04-01'  ";
            String aprQuery = "SELECT COUNT(*) AS aprQuery FROM consultation WHERE ConsultationDate > '"+thisYear+"-04-01' AND ConsultationDate < '"+thisYear+"-05-01'  ";
            String maiQuery = "SELECT COUNT(*) AS maiQuery FROM consultation WHERE ConsultationDate > '"+thisYear+"-05-01' AND ConsultationDate < '"+thisYear+"-06-01'  ";
            String junQuery = "SELECT COUNT(*) AS junQuery FROM consultation WHERE ConsultationDate > '"+thisYear+"-06-01' AND ConsultationDate < '"+thisYear+"-07-01'  ";
            String julQuery = "SELECT COUNT(*) AS julQuery FROM consultation WHERE ConsultationDate > '"+thisYear+"-07-01' AND ConsultationDate < '"+thisYear+"-08-01'  ";
            String augQuery = "SELECT COUNT(*) AS augQuery FROM consultation WHERE ConsultationDate > '"+thisYear+"-08-01' AND ConsultationDate < '"+thisYear+"-09-01'  ";
            String sepQuery = "SELECT COUNT(*) AS sepQuery FROM consultation WHERE ConsultationDate > '"+thisYear+"-09-01' AND ConsultationDate < '"+thisYear+"-10-01'  ";
            String octQuery = "SELECT COUNT(*) AS octQuery FROM consultation WHERE ConsultationDate > '"+thisYear+"-10-01' AND ConsultationDate < '"+thisYear+"-11-01'  ";
            String novQuery = "SELECT COUNT(*) AS novQuery FROM consultation WHERE ConsultationDate > '"+thisYear+"-11-01' AND ConsultationDate < '"+thisYear+"-12-01'  ";
            String decQuery = "SELECT COUNT(*) AS decQuery FROM consultation WHERE ConsultationDate > '"+thisYear+"-12-01' AND ConsultationDate < '"+thisYear+"-01-01'  ";

            // fetch the usernumber
            qs= connection.prepareStatement(userQuery);
            result = qs.executeQuery();
            if (result.next()){
                homeData.setUsersNbr(result.getInt("userNbr"));
            }
            qs.close();

            // fetch the apointement
            qs = connection.prepareStatement(apoinQuery);
            result = qs.executeQuery();
            if (result.next()){
                homeData.setAppointmentNbr(result.getInt("appointmentNbr"));
            }
            qs.close();

            // fetch the next apointements
            qs = connection.prepareStatement(nxtQuery);
            result = qs.executeQuery();
            if (result.next()){
                homeData.setNxtAppointmentNbr(result.getInt("NxtAppointmentNbr"));
            }
            qs.close();

            // fetch the done consultations
            qs = connection.prepareStatement(doneQuery);
            result = qs.executeQuery();
            if (result.next()){
                homeData.setDoneConsultations(result.getInt("doneConsultations"));
            }
            qs.close();

            // fetch month januarry
            qs = connection.prepareStatement(janQuery);
            result = qs.executeQuery();
            if (result.next()){
                monthData.put("jan",result.getInt("janQuery"));
            }
            qs.close();

            // fetch month januarry
            qs = connection.prepareStatement(febQuery);
            result = qs.executeQuery();
            if (result.next()){
                monthData.put("feb",result.getInt("febQuery"));
            }
            qs.close();


            // fetch month januarry
            qs = connection.prepareStatement(marQuery);
            result = qs.executeQuery();
            if (result.next()){
                monthData.put("mar",result.getInt("marQuery"));
            }
            qs.close();


            // fetch month januarry
            qs = connection.prepareStatement(aprQuery);
            result = qs.executeQuery();
            if (result.next()){
                monthData.put("apr",result.getInt("aprQuery"));
            }
            qs.close();

            // fetch month januarry
            qs = connection.prepareStatement(maiQuery);
            result = qs.executeQuery();
            if (result.next()){
                monthData.put("mai",result.getInt("maiQuery"));
            }
            qs.close();

            // fetch month jun
            qs = connection.prepareStatement(junQuery);
            result = qs.executeQuery();
            if (result.next()){
                monthData.put("jun",result.getInt("junQuery"));
            }
            qs.close();


            // fetch month januarry
            qs = connection.prepareStatement(julQuery);
            result = qs.executeQuery();
            if (result.next()){
                monthData.put("jul",result.getInt("julQuery"));
            }
            qs.close();


            // fetch month januarry
            qs = connection.prepareStatement(augQuery);
            result = qs.executeQuery();
            if (result.next()){
                monthData.put("aug",result.getInt("augQuery"));
            }
            qs.close();


            // fetch month januarry
            qs = connection.prepareStatement(sepQuery);
            result = qs.executeQuery();
            if (result.next()){
                monthData.put("sep",result.getInt("sepQuery"));
            }
            qs.close();


            // fetch month januarry
            qs = connection.prepareStatement(octQuery);
            result = qs.executeQuery();
            if (result.next()){
                monthData.put("oct",result.getInt("octQuery"));
            }
            qs.close();


            // fetch month januarry
            qs = connection.prepareStatement(novQuery);
            result = qs.executeQuery();
            if (result.next()){
                monthData.put("nov",result.getInt("novQuery"));
            }
            qs.close();


            // fetch month januarry
            qs = connection.prepareStatement(decQuery);
            result = qs.executeQuery();
            if (result.next()){
                monthData.put("dec",result.getInt("decQuery"));
            }
            qs.close();

            homeData.setMonthData(monthData);

        }catch (Exception e){
            System.out.println(e);

        }
        return homeData;

    }
}
