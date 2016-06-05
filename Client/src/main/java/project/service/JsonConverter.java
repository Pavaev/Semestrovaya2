package project.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import project.exception.JsonException;
import project.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonConverter {
    private ObjectMapper mapper;

    public JsonConverter() {
        mapper = new ObjectMapper();
    }
    public User convert(InputStream inputStream) throws JsonException {
        try {
            return mapper.readValue(inputStream, User.class);
        } catch (IOException e) {
            throw new JsonException(e.getMessage(), e);
        }
    }

    public String convert(User user) throws JsonException {
        try {
            return mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new JsonException(e.getMessage(), e);
        }
    }


    public List<User> convertToList(InputStream inputStream) throws JsonException {

        try {
            return mapper.readValue(inputStream, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        } catch (IOException e) {
            throw new JsonException(e.getMessage(), e);
        }
    }


    public String convertToList(List<User> userList) throws JsonException {
        try {
            return mapper.writeValueAsString(userList);
        } catch (IOException e) {
            throw new JsonException(e.getMessage(), e);
        }
    }
}
