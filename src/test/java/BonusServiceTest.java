import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldcalculateRegisteredandUnderlimit() {
        BonusService service = new BonusService();
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

        @Test
        void shouldcalculateRegisteredandOverlimit() {
        BonusService service = new BonusService();
        long amount = 1000_000_60;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldcalculateUnregisteredandOverlimit() {
        BonusService service = new BonusService();
        long amount = 1000_000_60;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldcalculateUnregisteredandUnderlimit() {
        BonusService service = new BonusService();
        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldcalculateRegisteredandEquallylimit() {
        BonusService service = new BonusService();
        long amount = 1666_667;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldcalculateUnregisteredandEquallylimit() {
        BonusService service = new BonusService();
        long amount = 5000_000;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

}