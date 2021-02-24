package com.gryszkoszymon.projectplanner.repository;

import com.gryszkoszymon.projectplanner.model.Column;
import com.gryszkoszymon.projectplanner.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


public interface ColumnRepository extends JpaRepository<Column, Long> {

}
