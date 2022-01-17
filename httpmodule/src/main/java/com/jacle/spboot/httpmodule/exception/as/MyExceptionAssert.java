package com.jacle.spboot.httpmodule.exception.as;

import java.text.MessageFormat;

public interface MyExceptionAssert extends IResponseEnum, SelfAssert
{
    @Override
    default BaseException newException(Object... args)
    {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new BusinessException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args)
    {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new BusinessException(this, args, msg, t);
    }
}
