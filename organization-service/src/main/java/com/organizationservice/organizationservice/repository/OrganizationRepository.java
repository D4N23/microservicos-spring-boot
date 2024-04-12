package com.organizationservice.organizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;

import com.organizationservice.organizationservice.entity.Organization;

public interface OrganizationRepository  extends JpaRepository<Organization,Long>{
    Organization findByOrganizationCode(String organizationCode);
}
