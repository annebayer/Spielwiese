package com.example.demoAusprobieren.annotationandvalidation;

import java.util.Set;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnotationController {
    @GetMapping("/annotation")
    public String ersteSahne(@RequestParam(value = "notNegative", defaultValue = "12") int alter) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Passt oder passt nicht? \n");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        KlasseMitNotNegativeAnnotation myBean = new KlasseMitNotNegativeAnnotation(alter);

        Set<ConstraintViolation<KlasseMitNotNegativeAnnotation>> violations = validator.validate(myBean);

        return buildString(stringBuilder, violations, myBean);
    }

    private static String buildString(StringBuilder stringBuilder,
            Set<ConstraintViolation<KlasseMitNotNegativeAnnotation>> violations,
            KlasseMitNotNegativeAnnotation myBean) {
        if (!violations.isEmpty()) {
            stringBuilder.append("Passt nicht!\nFolgende Verletzungen: \n");
            for (ConstraintViolation<KlasseMitNotNegativeAnnotation> violation : violations) {
                stringBuilder.append(violation.getMessage()).append("\n");
            }
        } else {
            stringBuilder.append(String.format("Passt es oder nicht %s", myBean.getMyNotNegativeNumber()));
        }
        return stringBuilder.toString();
    }
}
