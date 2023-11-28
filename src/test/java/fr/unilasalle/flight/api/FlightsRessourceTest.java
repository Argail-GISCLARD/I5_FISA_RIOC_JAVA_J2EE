package fr.unilasalle.flight.api;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import beans.FlightEntity;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import java.sql.Date;
import java.sql.Time;

@QuarkusTest
public class FlightsRessourceTest {

    @Test
    public void testGetFlightById() {
        given()
          .pathParam("id", 1)
          .when().get("/flights/{id}")
          .then()
             .statusCode(200)
             .body("id", equalTo(1));
    }

    @Test
    public void testGetFlightsByDestination() {
        given()
          .pathParam("dst", "Malaisie")
          .when().get("/flights/destination/{dst}")
          .then()
             .statusCode(200)
             .body("size()",greaterThan(0));
    }

    @Test
    public void testCreateFlight() {
        FlightEntity flightEntity = new FlightEntity();
        flightEntity.number = "number";
        flightEntity.origin = "origin";
        flightEntity.destination = "destination";
        flightEntity.departure_date = new Date(0);
        flightEntity.departure_time = new Time(0);
        flightEntity.arrival_date = new Date(0);
        flightEntity.arrival_time = new Time(0);
        flightEntity.plane_id = 1;

        given()
          .contentType(ContentType.JSON)
          .body(flightEntity)
          .when().post("/flights")
          .then()
             .statusCode(200);
    }

    @Test
    public void testDeleteFlight() {
        given()
          .pathParam("id", 1)
          .when().delete("/flights/{id}")
          .then()
             .statusCode(200);
    }
}
