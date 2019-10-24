package com.touchsoft.service;

import lombok.extern.log4j.Log4j2;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;
@Log4j2
public class JsonUtilService {
    public static String stringToJsonMessage(final String name, final String message) {
        log.info(name + " " + message + " stringToJsonMessage ");
        return Json.createObjectBuilder().add("name", name).add("text", message).build().toString();
    }

    public static String jsonMessageToString(final String response) {
        log.info(response + " jsonMessageToString");
        JsonObject root = Json.createReader(new StringReader(response)).readObject();
        String message = root.getString("text");
        String sender = root.getString("name");
        String result = sender + " " + message;
        return result;
    }
}
