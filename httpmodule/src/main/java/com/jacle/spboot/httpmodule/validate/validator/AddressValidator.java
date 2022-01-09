package com.jacle.spboot.httpmodule.validate.validator;

import com.jacle.spboot.httpmodule.validate.Address;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AddressValidator implements Validator
{

    /**
     * This Validator validates *just* Address instances
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Address.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "location", "location.empty");
        Address p = (Address) obj;
        if (p != null && p.getLocation() != null && p.getLocation().length() > 5) {
            e.rejectValue("location", "value too length", "长度不能超过5");
        }
    }
}