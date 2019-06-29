package tests.Utils;

import java.lang.reflect.Field;
import java.util.List;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.PropertyNamingStrategy;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.cfg.MapperConfig;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotatedField;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import org.apache.commons.lang3.reflect.FieldUtils;

public class CustomJSONNamingStrategy extends PropertyNamingStrategy {

    @Override
    public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) {
        return field.getName();
    }

    @Override
    public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        return convert(method, defaultName);
    }

    @Override
    public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        return convert(method, defaultName);
    }

    private String convert(AnnotatedMethod method, String defaultName) {
        Class<?> _class = method.getDeclaringClass();
        List<Field> fields = FieldUtils.getAllFieldsList(_class);
        for (Field fld : fields) {
            if (fld.getName().equalsIgnoreCase(defaultName)) {
                return fld.getName();
            }
        }
        return defaultName;
    }
}