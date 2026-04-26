import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {

    @Test
    public void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("1",
                new Date(System.currentTimeMillis() + 100000), "Doctor visit");
        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointment("1"));
    }

    @Test
    public void testAddDuplicateAppointmentId() {
        AppointmentService service = new AppointmentService();
        Appointment appointment1 = new Appointment("1",
                new Date(System.currentTimeMillis() + 100000), "Doctor visit");
        Appointment appointment2 = new Appointment("1",
                new Date(System.currentTimeMillis() + 200000), "Dental checkup");

        service.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment2);
        });
    }

    @Test
    public void testAddNullAppointment() {
        AppointmentService service = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(null);
        });
    }

    @Test
    public void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("1",
                new Date(System.currentTimeMillis() + 100000), "Doctor visit");
        service.addAppointment(appointment);
        service.deleteAppointment("1");
        assertThrows(IllegalArgumentException.class, () -> {
            service.getAppointment("1");
        });
    }

    @Test
    public void testDeleteNonexistentAppointment() {
        AppointmentService service = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("99");
        });
    }

    @Test
    public void testGetNonexistentAppointment() {
        AppointmentService service = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.getAppointment("99");
        });
    }
}