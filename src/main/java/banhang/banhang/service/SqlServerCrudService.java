package banhang.banhang.service;

import org.springframework.stereotype.Service;

// @Service
public class SqlServerCrudService implements CrudService {
    public void create(){
        System.out.println("New object in SQL Server");
    }
}
