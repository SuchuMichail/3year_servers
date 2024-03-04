package handlers;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IHandler {
    String handle(String json) throws JsonProcessingException;
}
