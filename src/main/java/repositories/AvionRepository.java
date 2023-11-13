package repositories;

import java.util.List;

import beans.AvionEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public class AvionRepository implements PanacheRepositoryBase<AvionEntity,Integer>{
    ● Ajouter un avion
    public List<AvionEntity> listAll() {
        List<AvionEntity> avions = AvionEntity.listAll();
    }

    public AvionEntity findByIdAvionEntity(Integer id){
        AvionEntity avionEntity = new AvionEntity();
        return AvionEntity.findById(id);
    }

    public void addAvionEntity(){
        AvionEntity.update(null, null)
    }
}