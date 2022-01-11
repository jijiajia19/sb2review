package com.jacle.spboot.validation.conditional;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

public class OnCustomAndCondition extends AllNestedConditions
{
    public OnCustomAndCondition()
    {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    @ConditionalOnProperty(value = "cond_v", havingValue = "2")
    static class conditionA
    {

    }

    @ConditionalOnProperty(value = "cond_r", havingValue = "1")
    static class conditionB
    {

    }
}