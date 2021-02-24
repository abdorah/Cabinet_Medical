package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import com.DAO.ConsultationDAO;
import com.DAO.PatientDAO;
import com.DAO.PrescriptionDAO;
import com.javaBeans.Consultation;
import com.javaBeans.Patient;
import com.javaBeans.Prescription;

import org.junit.Before;
import org.junit.Test;

public class ConsultationServiceUnitTest {

    ConsultationDAO consultationDAO;
    PrescriptionDAO prescriptionDAO;
    PatientDAO patientDAO;
    Consultation consultation;
    Prescription prescription;
    Patient patient;

    @Before
    public void init(){
        consultationDAO = new ConsultationDAO();
        consultation = new Consultation();
        prescription = new Prescription();
        patient = new Patient(10, "UB98226", "abderrahmane", "kotbi", "0633559921", "specialty", "kotbi@gmail.com", "password");
        prescription.setId_prescription(15);
        prescription.setDescription("simple calmant des douleurs");
        prescription.setMedicationList("doliprane");
        prescription.setTitle("douleur de tete pour les enfants");
        prescription.setDateOfPrescription("10-11-2020");
        consultation.setId_consultation(10);
        consultation.setMotif("fièvre");
        consultation.setConsulationDate("10-11-2020");
        consultation.setPrice(100.0);
        consultation.setPrescription(prescription);
        consultation.setPatient(patient);
    }

    @Test
    public void consultationShouldBeAdded() throws SQLException {
        assertNotEquals(0, prescriptionDAO.addPrescription(prescription));
        assertTrue(consultationDAO.addConsultation(consultation));
        assertEquals(15, prescriptionDAO.getPrescriptionById(prescription.getId_prescription())); 
        assertEquals(10, consultationDAO.getConsultationById(consultation.getId_consultation()));
    }

    @Test
    public void consultationShouldBeDeleted() throws SQLException {
        assertTrue(prescriptionDAO.deletePrescriptionById(15));
        assertTrue(consultationDAO.deleteConsultationById(10));
    }

}
