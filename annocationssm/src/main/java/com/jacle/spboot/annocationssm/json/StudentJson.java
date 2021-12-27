package com.jacle.spboot.annocationssm.json;

/**
 * @author Jacle
 * @version 1.0
 * @description: json序列化器
 * @date 2021/12/23 17:30
 */

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用@JsonComponent注释会自动被注册到Jackson中.
 **/

//对单个class进行自定义转换的时候，可以用此处理
@JsonComponent
public class StudentJson
{
    //序列化器
    public static class MySerialer extends JsonSerializer<Double>
    {
        private DecimalFormat df = new DecimalFormat("##.00");

        @Override
        public void serialize(Double aDouble, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException
        {
            jsonGenerator.writeString(df.format(aDouble));
        }
    }

    public static class MyDeserialer extends JsonDeserializer<Date>
    {
        private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        @Override
        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException
        {
            Date date = null;
            try
            {
                date = sdf.parse(jsonParser.getText());
            } catch (ParseException e)
            {
                e.printStackTrace();
            }
            return date;
        }
    }

}
