package com.mycompany.ijection_de_dependence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {

    private IDao dao;

    public MetierImpl() {
    }

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        return dao.getData() * 2;
    }

    @Autowired
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
