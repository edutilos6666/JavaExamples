package com.edutilos.junit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by edutilos on 17.06.17.
 */
public class WorkerDAOImpl implements WorkerDAO {
    private Map<Long , Worker> container ;
    public WorkerDAOImpl() {
        container = new HashMap<>();
    }
    @Override
    public void save(Worker w) {
        container.putIfAbsent(w.getId(), w);
    }

    @Override
    public void update(long id, Worker newW) {
        container.put(id, newW);
    }

    @Override
    public void remove(long id) {
        container.remove(id);
    }

    @Override
    public Worker findById(long id) {
        return container.get(id);
    }

    @Override
    public List<Worker> findAll() {
        List<Worker> ret = new ArrayList<>();
        ret.addAll(container.values());
        return ret ;
    }
}
