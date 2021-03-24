package mrs.app.room;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EndDateMustBeAfterStartDateValdator implements ConstraintValidator<EndDateMustBeAfterStartDate, ReservableRoomForm> {

    private String message;

    @Override
    public void initialize(EndDateMustBeAfterStartDate constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(ReservableRoomForm value, ConstraintValidatorContext context) {
        if (value.getStartDate() == null || value.getEndDate() == null) {
            return true;
        }
        boolean isEndDateMustBeAfterStartDate = value.getEndDate().isAfter(value.getStartDate());
        if (!isEndDateMustBeAfterStartDate) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addPropertyNode("endDate").addConstraintViolation();
        }
        return isEndDateMustBeAfterStartDate;
    }
}
