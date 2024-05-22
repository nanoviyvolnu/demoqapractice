package api.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import models.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        for(UserData userData : userDataList){
            System.out.println(userData.getId() + " " + userData.getAvatar());
            if(userData.getAvatar().contains(String.valueOf(userData.getId()))){
                result = true;
            }
        }
        Assert.assertEquals(result, expectedResult);
    }
}
