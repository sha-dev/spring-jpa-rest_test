package jp.co.scsac.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jp.co.scsac.entity.Book;
import jp.co.scsac.entity.ProcessTypeMaster;


public interface ProcessTypeMasterRepository extends PagingAndSortingRepository<ProcessTypeMaster, Integer> {

}
