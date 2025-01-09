package com.example.demoausprobieren.annotationandvalidation;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@RestController
public class AnnotationController {
    private static final String STANDARD_TEXT = "Passt oder passt nicht? \n";
    private final Validator validator;


    public AnnotationController() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @GetMapping("/annotation")
    public String validateNumberNotNegative(@RequestParam(value = "notNegative", defaultValue = "12") int alter) {
        KlasseMitNotNegativeAnnotation myBean = new KlasseMitNotNegativeAnnotation(alter);
        Set<ConstraintViolation<KlasseMitNotNegativeAnnotation>> violations = validator.validate(myBean);

        return generateResponseMessage(violations, myBean);
    }

    private static String generateResponseMessage(Set<ConstraintViolation<KlasseMitNotNegativeAnnotation>> violations,
            KlasseMitNotNegativeAnnotation myBean) {
        if (violations.isEmpty()) {
            return String.format("%s Passt es oder nicht %s", STANDARD_TEXT, myBean.getMyNotNegativeNumber());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(STANDARD_TEXT);
        for (ConstraintViolation<KlasseMitNotNegativeAnnotation> violation : violations) {
            stringBuilder.append(violation.getMessage()).append("\n");
        }
        return stringBuilder.toString();
    }
}
