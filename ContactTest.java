import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("123", "Justin", "Charles", "1234567890", "123 Main Street");
        assertEquals("123", contact.getContactId());
        assertEquals("Justin", contact.getFirstName());
        assertEquals("Charles", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Justin", "Charles", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Justin", "Charles", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Charles", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "VeryLongName", "Charles", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Justin", null, "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Justin", "VeryLongLast", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Justin", "Charles", null, "123 Main Street");
        });
    }

    @Test
    public void testPhoneNotTenDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Justin", "Charles", "12345", "123 Main Street");
        });
    }

    @Test
    public void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Justin", "Charles", "1234567890", null);
        });
    }

    @Test
    public void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Justin", "Charles", "1234567890",
                    "1234567890123456789012345678901");
        });
    }

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("123", "Justin", "Charles", "1234567890", "123 Main Street");
        contact.setFirstName("Jay");
        assertEquals("Jay", contact.getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("123", "Justin", "Charles", "1234567890", "123 Main Street");
        contact.setLastName("Brown");
        assertEquals("Brown", contact.getLastName());
    }

    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("123", "Justin", "Charles", "1234567890", "123 Main Street");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("123", "Justin", "Charles", "1234567890", "123 Main Street");
        contact.setAddress("456 Oak Avenue");
        assertEquals("456 Oak Avenue", contact.getAddress());
    }

    @Test
    public void testUpdateFirstNameInvalid() {
        Contact contact = new Contact("123", "Justin", "Charles", "1234567890", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    @Test
    public void testUpdateLastNameInvalid() {
        Contact contact = new Contact("123", "Justin", "Charles", "1234567890", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("VeryLongLast");
        });
    }

    @Test
    public void testUpdatePhoneInvalid() {
        Contact contact = new Contact("123", "Justin", "Charles", "1234567890", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("123");
        });
    }

    @Test
    public void testUpdateAddressInvalid() {
        Contact contact = new Contact("123", "Justin", "Charles", "1234567890", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("1234567890123456789012345678901");
        });
    }
}