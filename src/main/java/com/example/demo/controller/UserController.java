package com.example.demo.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;

@RestController
@RequestMapping("/user")
public class UserController {

//    private UserService userService;

//    @Autowired
//    public void setUserService(UserService userDAO) {
//        this.userService = userDAO;
//    }

    @RequestMapping("/all")
    public void listAllUsers(){
        System.out.println("Listing all users...");

//        return userService.listAllUsers();
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<HttpStatus> test(@RequestBody String jsonResponse){

        try {
            JSONArray jsonArray = new JSONArray(jsonResponse);
            System.out.println(jsonArray.toString());
            Object o = jsonArray;
            System.out.println(o.getClass());


//            fieldParse(o);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
//         catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    public void fieldParse(Object o) throws IllegalAccessException {
        for (Field field : o.getClass().getDeclaredFields()) {
            field.setAccessible(true); // You might want to set modifier to public first.
            Object value = field.get(o);
            if (value != null) {
                System.out.println(field.getName() + "=" + value);
            }
        }
    }
}
