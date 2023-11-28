package repositories;

import beans.PassengerEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PassengerRepository implements PanacheRepository<PassengerEntity>{

    public PassengerEntity getById(Long id){
        return findById(id);
    }

    public void update(Long id, PassengerEntity passenger) {
        
        PassengerEntity entity = PassengerEntity.findById(id);

        if(entity == null) {
            throw new NotFoundException();
        }

        entity.surname = passenger.surname;
        entity.firstname = passenger.firstname;
        entity.email_address = passenger.email_address;
    }
}