package com.organizationservice.organizationservice.services;

import com.organizationservice.organizationservice.dto.OrganizationDto;

public interface OrganizationService {

    public OrganizationDto saveOrganization(OrganizationDto organizationDto);

    public OrganizationDto getOrganizationByCode(String organizationCode);

}
