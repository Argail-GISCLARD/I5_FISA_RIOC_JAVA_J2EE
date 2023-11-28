package fr.unilasalle.flight.api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import beans.AvionEntity;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class PlanesRessourceTest {

    @Test
    public void testGetAllPlanes() {
        given()
          .when().get("/planes")
          .then()
             .statusCode(200)
             .body("size()", greaterThan(0));
    }

    @Test
    public void testGetSinglePlane() {
        given()
          .pathParam("id", 1)
          .when().get("/planes/{id}")
          .then()
             .statusCode(200)
             .body("id", equalTo(1));
    }

    @Test
    public void testSearchByOperator() {
        given()
          .pathParam("name", "Boeing")
          .when().get("/planes/operator/{name}")
          .then()
             .statusCode(200)
             .body("size()", greaterThan(0));
    }

    @Test
    public void testCreatePlane() {
        AvionEntity avionEntity = new AvionEntity();
        avionEntity.model = "747";
        avionEntity.capacity = 10;
        avionEntity.operator = "AirFrance";
        avionEntity.registration = "N°12";
        given()
          .body(avionEntity)
          .header("Content-Type", "application/json")
          .when().post("/planes")
          .then()
             .statusCode(201);
    }

}