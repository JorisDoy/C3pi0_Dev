package com.indra.iopen.repositories;

import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * Main repository for JPA Repositories with commond operations.
 * @author mbaez
 *
 * @param <T>
 */
public interface MasterDataRepository<T> {
    int count();

    void edit(@NotNull T entity);

    List<T> findAll();

    T findById(@NotNull Object id);

    List<T> findRange(@NotNull int[] range);

    void remove(@NotNull Object object);

    void save(@NotNull T entity);
}
