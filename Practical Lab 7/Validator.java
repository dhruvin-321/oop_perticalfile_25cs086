import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

// NotBlank Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

// MaxLength Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// SignupForm class
class SignupForm {

    @NotBlank
    private String name;

    @NotBlank
    @MaxLength(10)
    private String username;

    @NotBlank
    @MaxLength(15)
    private String password;

    public SignupForm(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
}

// Validator class
class FormValidator {

    public static List<String> validate(Object obj) {

        List<String> errors = new ArrayList<>();

        Class<?> cls = obj.getClass();

        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);

            try {
                Object value = field.get(obj);

                // Check NotBlank
                if (field.isAnnotationPresent(NotBlank.class)) {

                    if (value == null || value.toString().trim().isEmpty()) {
                        errors.add(field.getName() + " must not be blank");
                    }
                }

                // Check MaxLength
                if (field.isAnnotationPresent(MaxLength.class)) {

                    MaxLength max = field.getAnnotation(MaxLength.class);

                    if (value != null && value.toString().length() > max.value()) {
                        errors.add(field.getName() + " must not exceed " + max.value() + " characters");
                    }
                }

            } catch (IllegalAccessException e) {
                errors.add("Unable to access field: " + field.getName());
            }
        }

        return errors;
    }
}

// Drivers class
class Drivers {

    public static void main(String[] args) {

        SignupForm form = new SignupForm(
            "",
            "verylongusername",
            "mypassword123456789"
        );

        List<String> errors = FormValidator.validate(form);

        if (errors.isEmpty()) {
            System.out.println("Form is valid");
        } else {
            System.out.println("Validation Errors:");

            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}