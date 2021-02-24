package test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import com.DAO.ConsultationDAO;
import com.DAO.PrescriptionDAO;
import com.javaBeans.Consultation;
import com.javaBeans.Patient;
import com.javaBeans.Prescription;

import org.junit.Test;

public class ConsultationServiceUnitTest {

    @Test
    public void consultationShouldBeAdded() throws SQLException {
        ConsultationDAO consultationDAO = new ConsultationDAO();
        PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
        Consultation consultation = new Consultation();
        Prescription prescription= new Prescription();
        Patient patient = new Patient(10, "UB98226", "abderrahmane", "kotbi", "0633559921", "specialty", "kotbi@gmail.com", "password");
        prescription.setId_prescription(15);
        prescription.setDescription("simple calmant des douleurs");
        prescription.setMedicationList("doliprane");
        prescription.setTitle("douleur de tete pour les enfants");
        prescription.setDateOfPrescription("2020-10-11");
        consultation.setId_consultation(10);
        consultation.setMotif("fièvre");
        consultation.setConsulationDate("2020-10-11");
        consultation.setPrice(100.0);
        consultation.setPrescription(prescription);
        consultation.setPatient(patient);
        assertNotEquals(0, prescriptionDAO.addPrescription(prescription));
        assertTrue(consultationDAO.addConsultation(consultation));
    }

    @Test
    public void consultationShouldBeDeleted() throws SQLException {
        ConsultationDAO consultationDAO = new ConsultationDAO();
        PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
        Consultation consultation = new Consultation();
        Prescription prescription= new Prescription();
        Patient patient = new Patient(10, "UB98226", "abderrahmane", "kotbi", "0633559921", "specialty", "kotbi@gmail.com", "password");
        prescription.setId_prescription(15);
        prescription.setDescription("simple calmant des douleurs");
        prescription.setMedicationList("doliprane");
        prescription.setTitle("douleur de tete pour les enfants");
        prescription.setDateOfPrescription("2020-10-11");
        consultation.setId_consultation(10);
        consultation.setMotif("fièvre");
        consultation.setConsulationDate("2020-10-11");
        consultation.setPrice(100.0);
        consultation.setPrescription(prescription);
        consultation.setPatient(patient);
        assertNotEquals(0, prescriptionDAO.addPrescription(prescription));
        assertTrue(consultationDAO.addConsultation(consultation));
    }

}
