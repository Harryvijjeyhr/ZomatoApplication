package com.capgemini.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.*;

import com.capgemini.model.Restaurant;

@RepositoryRestResource(collectionResourceRel = "restaurants")
public interface RestuarantRepository extends PagingAndSortingRepository<Restaurant, String> {

	@RestResource(rel = "by-name", description = @Description("Find by name"))
    public Restaurant findFirstByName(@Param("name") String name);
}
