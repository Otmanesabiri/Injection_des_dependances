package com.mycompany.ijection_de_dependence;

import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpl implements IDao {
    @Override
    public double getData() {
        return 15.0;
    }
}
