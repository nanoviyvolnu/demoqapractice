package api.tests;

import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import models.User;
import models.UserPut;
import models.UserRegister;
import org.hamcrest.Matchers.*;
import models.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetListUsers {

    private final static String url = "https://reqres.in/";

    @Test
    public void checkAvatarAndIdTest(){
        boolean result = false;
        boolean expectedResult = true;
        List<UserData> userDataList = given()
                .when()
                .contentType(ContentType.JSON)
                .get(url + "api/users?page=2")
                .then().statusCode(200).log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        for(UserData userData : userDataList){
            System.out.println(userData.getId() + " " + userData.getAvatar());
            if(userData.getAvatar().contains(String.valueOf(userData.getId()))){
                result = true;
            }
        }
        Assert.assertEquals(result, expectedResult);
    }


    @Test
    public void checkIfUserAreDisplayed(){
        get(url + "api/users/2").then().statusCode(200).assertThat()
                .body("data.id", equalTo(2));
    }

    @Test
    public void whenRequestedPost_thenCreated(){
        User newUser = new User();
        newUser.setName("morpheus");
        newUser.setJob("leader");

        User user = given()
                .contentType(ContentType.JSON)
                .body(newUser)
                .post(url + "api/users")
                .then()
                .statusCode(201)
                .log().all()
                .extract().body()
                .as(User.class);

        Assert.assertNotNull(user.getId());
        System.out.println(user.getId());
        Assert.assertEquals(user.getName(), newUser.getName());
        System.out.println(user.getName() + " " + newUser.getName());
        Assert.assertEquals(user.getJob(), newUser.getJob());
        System.out.println(user.getJob() + " " + newUser.getJob());
    }

    @Test
    public void whenRequestedPut_thenUpdated(){
        UserPut updatedUser = new UserPut();
        updatedUser.setName("morpheus");
        updatedUser.setJob("zion resident");

        int userId = 2;

        UserPut userAfterUpdate = given()
                .contentType(ContentType.JSON)
                .body(updatedUser)
                .when()
                .put(url + "api/users/" + userId)
                .then()
                .statusCode(200)
                .log().all()
                .extract().body().as(UserPut.class);

        Assert.assertEquals(userAfterUpdate.getName(), updatedUser.getName());
        System.out.println(updatedUser.getName() + " " + userAfterUpdate.getName());
        Assert.assertEquals(userAfterUpdate.getJob(), updatedUser.getJob());
        System.out.println(updatedUser.getJob() + " " + userAfterUpdate.getJob());
    }

    @Test
    public void whenRequestPut_thenRegister(){
        String expectedResult = "QpwL5tke4Pnpja7X4";

        UserRegister userRegister = new UserRegister();
        userRegister.setEmail("eve.holt@reqres.in");
        userRegister.setPassword("pistol");

        UserRegister userRegisterResponse = given()
                .contentType(ContentType.JSON)
                .body(userRegister)
                .post(url + "api/register")
                .then()
                .statusCode(200)
                .log().all().extract().body().as(UserRegister.class);

        Assert.assertNotNull(userRegisterResponse.getToken());
        Assert.assertEquals(userRegisterResponse.getToken(), expectedResult);
        System.out.println("Actual : " + userRegisterResponse.getToken() + " Expected : " + expectedResult);
    }

    @Test
    public void whenRequest_thenLogin(){
        String expectedResult = "QpwL5tke4Pnpja7X4";

        UserRegister userRegister = new UserRegister();
        userRegister.setEmail("eve.holt@reqres.in");
        userRegister.setPassword("cityslicka");

        UserRegister userRegisterResponse = given()
                .contentType(ContentType.JSON)
                .body(userRegister)
                .post(url + "api/login")
                .then()
                .statusCode(200)
                .log().all().extract().body().as(UserRegister.class);

        Assert.assertNotNull(userRegisterResponse.getToken());
        Assert.assertEquals(userRegisterResponse.getToken(), expectedResult);
        System.out.println("Actual : " + userRegisterResponse.getToken() + " Expected : " + expectedResult);
    }

    @Test
    public void whenRequest_thenLoginError(){
        String expectedResult = "Missing password";

        UserRegister userRegister = new UserRegister();
        userRegister.setEmail("epeter@klaven");

        UserRegister userRegisterResponse = given()
                .contentType(ContentType.JSON)
                .body(userRegister)
                .post(url + "api/login")
                .then()
                .statusCode(400)
                .log().all().extract()
                .body().as(UserRegister.class);

        Assert.assertEquals(userRegisterResponse.getError(), expectedResult);
        System.out.println("Actual : " + userRegisterResponse.getError() + " Expected : " + expectedResult);
    }

    @Test
    public void whenRequest_theDisplayedWithDelay(){
        long expectedResult = 3;

        Response response = given()
                .contentType(ContentType.JSON)
                .get(url + "api/users?delay=3")
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response();

        List<UserData> userDataList = given()
                .when()
                .contentType(ContentType.JSON)
                .get(url + "api/users?delay=3")
                .then().statusCode(200).log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        int responseTimeInSeconds = (int) (response.time() / 1000);
        Assert.assertEquals(responseTimeInSeconds, expectedResult);
        Assert.assertNotNull(userDataList);

        userDataList.forEach(x -> System.out.println(x.getId() + " " + x.getEmail() + " " + x.getFirst_name() + " " + x.getLast_name() + "\n"));
    }


}
