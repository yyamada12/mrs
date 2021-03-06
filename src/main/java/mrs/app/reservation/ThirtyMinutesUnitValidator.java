package mrs.app.reservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalTime;

public class ThirtyMinutesUnitValidator implements ConstraintValidator<ThirtyMinutesUnit, LocalTime> {
    @Override
    public void initialize(ThirtyMinutesUnit thirtyMinutesUnit) {

    }

    @Override
    public boolean isValid(LocalTime value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.getMinute() % 30 == 0;
    }
}
