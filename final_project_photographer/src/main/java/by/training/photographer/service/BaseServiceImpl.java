package by.training.photographer.service;

import by.training.photographer.dao.DaoFactory;
import by.training.photographer.dao.connection.Transaction;
import by.training.photographer.entity.Entity;

public abstract class BaseServiceImpl<K, T extends Entity>  implements BaseService<K, T> {

    private final DaoFactory daoFactory;

    protected BaseServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Transaction createTransaction() {
        return new Transaction();
    }

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }
}
