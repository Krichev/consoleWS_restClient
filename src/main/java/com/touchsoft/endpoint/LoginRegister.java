package com.touchsoft.endpoint;


import com.touchsoft.dto.RoleTokenDTO;
import com.touchsoft.dto.UserDataDTO;
import com.touchsoft.model.Role;
import com.touchsoft.model.User;
import com.touchsoft.service.PreparesSslContextService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LoginRegister {
    private static final String LOGIN = "http://localhost:8080/web/login";
    private static final String REGISTER = "http://localhost:8080/web/register";



    public int loginClient(String username, String password) {
        String role;
        int code = -1;
        RestTemplate restTemplate = PreparesSslContextService.prepareRestTemplate();


        List<Role> listRole = new ArrayList<Role>(Arrays.asList(Role.ROLE_AGENT));
        UserDataDTO userDataDTO = new UserDataDTO(username, password, listRole);

        HttpEntity<UserDataDTO> entity = new HttpEntity<>(userDataDTO);

        restTemplate.setMessageConverters(getMessageConverters());

        HttpEntity<RoleTokenDTO> user = restTemplate
                .exchange(LOGIN, HttpMethod.POST, entity, RoleTokenDTO.class);
        User.role = user.getBody().getRole();
        User.token = (user.getBody().getToken());
        User.setRoomName(User.username, User.role);

        return user != null ? 200 : 500;

    }


    public int registerClient(String username, String password, String role) {
        int code = -1;
        List<Role> listRole = null;

        if (role.equals("agent")) {
            listRole = new ArrayList<Role>(Arrays.asList(Role.ROLE_AGENT));
        } else if (role.equals("client")) {
            listRole = new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT));
        }
        RestTemplate restTemplate = PreparesSslContextService.prepareRestTemplate();
        UserDataDTO userDataDTO = new UserDataDTO(username, password, listRole);
        HttpEntity<UserDataDTO> entity = new HttpEntity<UserDataDTO>(userDataDTO);

        restTemplate
                .exchange(REGISTER, HttpMethod.POST, entity, Void.class);
        code = loginClient(username, password);


        return code;
    }


    private List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> converters =
                new ArrayList<HttpMessageConverter<?>>();
        converters.add(new MappingJackson2HttpMessageConverter());
        return converters;
    }
}