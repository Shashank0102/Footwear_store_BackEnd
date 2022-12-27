package com.phase4.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phase4.project.Model.Shoe;
@Repository
public interface Repository_Shoe extends JpaRepository<Shoe,Integer>{

}
