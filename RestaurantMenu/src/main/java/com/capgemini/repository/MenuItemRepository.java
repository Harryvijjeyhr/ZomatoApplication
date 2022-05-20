package com.capgemini.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.*;

import com.capgemini.model.MenuItem;
@RepositoryRestResource(collectionResourceRel = "menuitems")
public interface MenuItemRepository extends PagingAndSortingRepository<MenuItem, String> {

	 @RestResource(rel = "by-rid", description = @Description("Get all menuitems by restaurant id"))
	    public List<MenuItem> findAllByRestaurantId(String rid);

	    @RestResource(rel = "by-name", description = @Description("Get menuitem by item name"))
	    public MenuItem findByName(@Param("name") String name);
}
