import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;

class AppointmentTest {

    private Date createDate(int year, int month, int day) {
        // Implement the Date creation logic using appropriate constructors or methods
        // Alternatively, consider using LocalDate from java.time
        // For simplicity, using a placeholder Date implementation for now
        return new Date(year - 1900, month, day); // Note: Year is represented as years since 1900
    }

    @Test
    @DisplayName("Appointment ID cannot have more than 10 characters")
    void testAppointmentIDWithMoreThanTenCharacters() {
        Appointment appointment = new Appointment(createDate(2022, Calendar.JANUARY, 1), "Description");
        assertFalse(appointment.getAppointmentID().length() > 10, "Appointment ID has more than 10 characters.");
    }

    @Test
    @DisplayName("Appointment Description cannot have more than 50 characters")
    void testAppointmentDescWithMoreThanFiftyCharacters() {
        Appointment appointment = new Appointment(createDate(2022, Calendar.JANUARY, 1),
                "123456789 is nine characters long" 
                        + "123456789 is another nine characters long" 
                        + "123456789 is another nine characters long"
                        + "123456789 is another nine characters long");
        assertFalse(appointment.getAppointmentDesc().length() > 50, "Appointment Description has more than 50 characters.");
    }

    @Test
    @DisplayName("Appointment Date cannot be before current date")
    void testAppointmentDateBeforeCurrent() {
        Appointment appointment = new Appointment(createDate(1022, Calendar.JANUARY, 1), "Description");
        assertFalse(appointment.getAppointmentDate().before(new Date()), "Appointment Date is before the current date.");
    }

    @Test
    @DisplayName("Appointment Date shall not be null")
    void testAppointmentDateNotNull() {
        Appointment appointment = new Appointment(null, "Description");
        assertNotNull(appointment.getAppointmentDate(), "Appointment Date was null.");
    }

    @Test
    @DisplayName("Appointment Description shall not be null")
    void testAppointmentDescNotNull() {
        Appointment appointment = new Appointment(createDate(2022, Calendar.JANUARY, 1), null);
        assertNotNull(appointment.getAppointmentDesc(), "Appointment Description was null.");
    }
}
