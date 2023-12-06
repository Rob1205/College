import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class AppointmentService {
    private final ArrayList<Appointment> appointmentList = new ArrayList<>();

    public void addAppointment(Appointment appointment) {
        // Validate input and add appointment
        if appointment.getAppointmentID()does not exist in appointmentList
        appointmentList.add(appointment);
        otherwise
                throw an exception
    }

    public void deleteAppointment(String appointmentID) {
        // Find and remove appointment by ID
        Iterator<Appointment> iterator = appointmentList.iterator();
        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            if (appointment.getAppointmentID().equals(appointmentID)) {
                iterator.remove();
                return;
            }
        }
        System.out.println("Appointment ID: " + appointmentID + " not found.");
    }
}

