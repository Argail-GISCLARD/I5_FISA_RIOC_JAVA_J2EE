package fr.unilasalle.flight.api;
import beans.PassengerEntity;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class PassengerRessourceTest {

    @Test
    public void testGetPassengerById() {
        given()
          .pathParam("id", 1)
          .when().get("/passengers/{id}")
          .then()
             .statusCode(200)
             .body("id", equalTo(1));
    }

    @Test
    public void testUpdatePassenger() {
        PassengerEntity passengerEntity = new PassengerEntity();
        passengerEntity.surname = "surname";
        passengerEntity.firstname = "firstname";
        passengerEntity.email_address = "aladin.saleh@etu.unilasalle.fr";
        given()
          .contentType(ContentType.JSON)
          .body(passengerEntity)
          .pathParam("id", 1)
          .when().put("/passengers/{id}")
          .then()
             .statusCode(200);
    }
}
