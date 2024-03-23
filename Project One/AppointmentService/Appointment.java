import java.util.Date;
import java.util.Calendar;

public class Appointment {
    private final String appointmentID;
    private final Date appointmentDate;
    private final String appointmentDesc;

    public Appointment(String appointmentID, Date appointmentDate, String appointmentDesc) {
        // Validate and set appointment ID
        if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        this.appointmentID = appointmentID;

        // Validate and set appointment date
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        this.appointmentDate = appointmentDate;

        // Validate and set description
        if (appointmentDesc == null || appointmentDesc.length() > 50) {
            throw new IllegalArgumentException("Invalid appointment description");
        }
        this.appointmentDesc = appointmentDesc;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return new Date(appointmentDate.getTime()); // Return a defensive copy
    }

    public String getAppointmentDesc() {
        return appointmentDesc;
    }
}


