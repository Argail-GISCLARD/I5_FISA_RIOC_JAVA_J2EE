package repositories;

import java.util.List;
import beans.AvionEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AvionRepository implements PanacheRepository<AvionEntity>{

    public List<AvionEntity> getAll() {
        return listAll();
    }

    public List<AvionEntity> getByOperator(String operator){
        return list("operator",operator);
    }

    public AvionEntity getById(Long id){
        return findById(id);
    }

    public void delete(Long id){
        delete("id",id);
    }

    public void add(AvionEntity avionEntity){
        persist(avionEntity);
    }
}