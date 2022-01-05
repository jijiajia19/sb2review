package com.jacle.spboot.httpmodule.jsonconfig;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;

//自定义序列化器，定制化json字符串处理
@Component
public class NullStringJsonSerializer extends JsonSerializer<String>
{
    @Override
    public void serialize(String o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException
    {
        jsonGenerator.writeString("-null定制化-");
    }
}