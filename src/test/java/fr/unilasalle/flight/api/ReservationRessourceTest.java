package fr.unilasalle.flight.api;

import io.quarkus.test.junit.QuarkusTest;
import repositories.PassengerRepository;

import org.junit.jupiter.api.Test;
import beans.PassengerEntity;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
public class ReservationRessourceTest {
    @jakarta.inject.Inject
    PassengerRepository passengerRepository;

    @Test
    public void testGetAllReservations() {
        given()
          .when().get("/reservations")
          .then()
             .statusCode(200)
             .body("size()", greaterThan(0)); // Assuming you expect a non-empty list
    }

    @Test
    public void testGetReservationsByFlight() {
        given()
          .pathParam("flight_id", 2)
          .when().get("/reservations/flight/{flight_id}")
          .then()
             .statusCode(200)
             .body("size()", greaterThan(0));
    }

    @Test
    public void testCreateReservation() {
        given()
            .pathParam("flight_id",2)
            .body("{\"surname\":\"Aladin\",\"firstname\":\"SALEH\",\"email_address\":\"aladin.saleh@etu.unilasalle.fr\"}")
            .header("Content-Type", "application/json")
            .when().post("/reservations/{flight_id}")
            .then()
                .statusCode(201);
    }

    @Test
    public void testDeleteReservation() {
        given()
          .pathParam("id", 3)
          .when().delete("/reservations/{id}")
          .then()
             .statusCode(200);
    }
}
