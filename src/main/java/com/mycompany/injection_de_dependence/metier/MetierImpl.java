package com.mycompany.injection_de_dependence.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mycompany.injection_de_dependence.dao.IDao;

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
