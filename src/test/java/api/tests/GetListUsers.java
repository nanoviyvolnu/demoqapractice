package api.tests;

import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers.*;
import models.User;
import models.UserPut;
import org.hamcrest.Matchers.*;
import models.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        String name = "morpheus";
        String job = "leader";

        User newUser = new User();
        newUser.setName(name);
        newUser.setJob(job);

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
        Assert.assertEquals(user.getName(), name);
        System.out.println(user.getName() + " " + name);
        Assert.assertEquals(user.getJob(), job);
        System.out.println(user.getJob() + " " + job);
    }

    @Test
    public void whenRequestedPut_thenUpdated(){
        UserPut updatedUser = new UserPut();
        updatedUser.setName("morpheus");
        updatedUser.setJob("zion resident");

        // Assume we are updating user with ID 2
        int userId = 2;

        // Send the PUT request and validate the response
        UserPut userAfterUpdate = given()
                .contentType(ContentType.JSON)
                .body(updatedUser)
                .when()
                .put(url + "api/users/" + userId)
                .then()
                .statusCode(200)
                .log().all()
                .extract().body().as(UserPut.class);

        // Validate the updated user details
        Assert.assertEquals(userAfterUpdate.getName(), updatedUser.getName());
        System.out.println(updatedUser.getName() + " " + userAfterUpdate.getName());
        Assert.assertEquals(userAfterUpdate.getJob(), updatedUser.getJob());
        System.out.println(updatedUser.getJob() + " " + userAfterUpdate.getJob());
    }
}
