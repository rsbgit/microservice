package com.microservice.rating.repository;

import com.microservice.rating.model.ProductRating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRatingRepository extends PagingAndSortingRepository<ProductRating, Long> {

    @Query("select avg(pr.rating) from ProductRating pr where productId =:productId")
    Float getAvgRatingByProductId(@Param("productId") Long productId);
}
