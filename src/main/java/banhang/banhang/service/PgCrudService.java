package banhang.banhang.service;

import org.springframework.stereotype.Service;

@Service
public class PgCrudService implements CrudService {
    public void create(){
        System.out.println("New object in PG SQL");
    }
}
