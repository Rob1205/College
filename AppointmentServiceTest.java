import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;
import Appointment.AppointmentService;

class AppointmentServiceTest {

    private Date createDate(int year, int month, int day) {
        // Implement the Date creation logic using appropriate constructors or methods
        // Alternatively, consider using LocalDate from java.time
        // For simplicity, using a placeholder Date implementation for now
        return new Date(year - 1900, month, day); // Note: Year is represented as years since 1900
    }

    @Test
    @DisplayName("Test to Update appointment date")
    @Order(1)
    void testUpdateAppointmentDate() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(createDate(2022, Calendar.JANUARY, 1), "Description");
        // Uncomment the line below for debugging if needed
        // service.displayAppointmentList();
        service.updateAppointmentDate(createDate(3022, Calendar.FEBRUARY, 2), "1");
        // Uncomment the line below for debugging if needed
        // service.displayAppointmentList();
        assertEquals(
            createDate(3022, Calendar.FEBRUARY, 2),
            service.getAppointment("1").getAppointmentDate(),
            "Appointment date was not updated."
        );
    }

    @Test
    @DisplayName("Test to Update appointment description.")
    @Order(2)
    void testUpdateAppointmentDesc() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(createDate(2022, Calendar.JANUARY, 1), "Description");
        // Uncomment the line below for debugging if needed
        // service.displayAppointmentList();
        service.updateAppointmentDesc("Updated Description", "1");
        // Uncomment the line below for debugging if needed
        // service.displayAppointmentList();
        assertEquals(
            "Updated Description",
            service.getAppointment("1").getAppointmentDesc(),
            "Appointment description was not updated."
        );
    }

    @Test
    @DisplayName("Test to ensure that service correctly deletes appointments.")
    @Order(3)
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(createDate(2022, Calendar.JANUARY, 1), "Description");
        // Uncomment the line below for debugging if needed
        // service.displayAppointmentList();
        service.deleteAppointment("1");
        // Uncomment the line below for debugging if needed
        // service.displayAppointmentList();
        ArrayList<Appointment> appointmentListEmpty = new ArrayList<>();
        assertEquals(appointmentListEmpty, service.appointmentList, "The appointment was not deleted.");
    }

    @Test
    @DisplayName("Test to ensure that service can add an appointment.")
    @Order(4)
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(createDate(2022, Calendar.JANUARY, 1), "Description");
        // Uncomment the line below for debugging if needed
        // service.displayAppointmentList();
        assertNotNull(service.getAppointment("1"), "Appointment was not added correctly.");
    }
}
