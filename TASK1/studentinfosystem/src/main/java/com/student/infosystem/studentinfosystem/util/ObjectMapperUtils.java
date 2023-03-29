package com.student.infosystem.studentinfosystem.util;

        import com.fasterxml.jackson.databind.ObjectMapper;

        import java.util.List;
        import java.util.stream.Collectors;

public class ObjectMapperUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T map(Object fromValue, Class<T> toClass) {
        return mapper.convertValue(fromValue, toClass);
    }

    public static <T> List<T> mapAll(List<?> fromList, Class<T> toClass) {
        return fromList.stream()
                .map(from -> map(from, toClass))
                .collect(Collectors.toList());
    }
}
