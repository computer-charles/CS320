import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class AppointmentTest {

    @Test
    public void testValidAppointmentCreation() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("1", futureDate, "Doctor visit");
        assertEquals("1", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor visit", appointment.getDescription());
    }

    @Test
    public void testAppointmentIdNull() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Doctor visit");
        });
    }

    @Test
    public void testAppointmentIdTooLong() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Doctor visit");
        });
    }

    @Test
    public void testAppointmentDateNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", null, "Doctor visit");
        });
    }

    @Test
    public void testAppointmentDateInPast() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", pastDate, "Doctor visit");
        });
    }

    @Test
    public void testDescriptionNull() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", futureDate, null);
        });
    }

    @Test
    public void testDescriptionTooLong() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", futureDate,
                    "This description is definitely going to be longer than fifty characters total.");
        });
    }
}