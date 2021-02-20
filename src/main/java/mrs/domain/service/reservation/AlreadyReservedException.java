package mrs.domain.service.reservation;

public class AlreadyReservedException extends RuntimeException {
    AlreadyReservedException(String message) {
        super(message);
    }
}
