import io.qameta.allure.Epic;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.UserModel;
import models.UserPostPutDeleteResponseModel;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.notNullValue;

@Epic("User object test")
public class UserTest {

    String firstUserName = getRandomName(5);
    String lastUserName = getRandomName(5);
    String userName = getRandomName(5);
    String password = getRandomPassword(5);
    String phone = getRandomPhone();
    String email = getRandomEmail();
    String message;

    UserModel testUser = new UserModel(firstUserName, lastUserName, userName, password, phone, email, 0);

    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .addHeader("api_key", "1qa2ws3ed4rfvcxz")
            .setBaseUri("http://petstore.swagger.io/")
            .setBasePath("v2/user/")
            .setContentType(ContentType.JSON)
            //.log(LogDetail.ALL)
            .build();

    ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectContentType(ContentType.JSON)
            .expectResponseTime(Matchers.lessThan(5000L))
            .expectStatusCode(200)
            .build();

    @Test
    public void createNewUser() {
        message = RestAssured.given(requestSpecification)
                .body(testUser)
                .when().post()
                .then().spec(responseSpecification).body("message", notNullValue()).extract().path("message");
    }

    @Test
    public void getUser() {
        createNewUser();
        UserModel responseUser = RestAssured.given(requestSpecification)
                .pathParam("username", testUser.getUsername())
                .when().get("{username}")
                .then().spec(responseSpecification).extract().as(UserModel.class);
        Assert.assertTrue(testUser.equals(responseUser));
    }

    @Test
    public void putUser() {
        createNewUser();
        testUser.setPhone("12312312311");
        UserPostPutDeleteResponseModel response = RestAssured.given(requestSpecification)
                .pathParam("username", testUser.getUsername())
                .body(testUser)
                .when().put("{username}")
                .then().spec(responseSpecification)
                .extract().as(UserPostPutDeleteResponseModel.class);
        Assert.assertNotNull(response.getMessage());
    }

    @Test
    public void deleteUser() {
        createNewUser();
        UserPostPutDeleteResponseModel response = RestAssured.given(requestSpecification)
                .pathParam("username", testUser.getUsername())
                .when().delete("{username}")
                .then().spec(responseSpecification)
                .extract().as(UserPostPutDeleteResponseModel.class);
        Assert.assertEquals(testUser.getUsername(), response.getMessage());
    }

    public String getRandomName(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }

    public int getRandomId(int count) {
        return Integer.parseInt(RandomStringUtils.randomNumeric(count));
    }

    public String getRandomPassword(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    public String getRandomPhone() {
        return RandomStringUtils.randomNumeric(11);
    }

    public String getRandomEmail() {
        return RandomStringUtils.randomAlphabetic(5) + "@" + RandomStringUtils.randomAlphabetic(5) + ".com";
    }
}
