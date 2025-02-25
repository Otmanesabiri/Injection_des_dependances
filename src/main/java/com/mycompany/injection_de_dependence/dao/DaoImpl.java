package com.mycompany.injection_de_dependence.dao;
import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpl implements IDao {
    @Override
    public double getData() {
        return 15.0;
    }
}
