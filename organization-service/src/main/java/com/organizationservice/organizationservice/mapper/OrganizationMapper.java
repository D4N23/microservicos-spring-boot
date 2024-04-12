package com.organizationservice.organizationservice.mapper;

import com.organizationservice.organizationservice.dto.OrganizationDto;
import com.organizationservice.organizationservice.entity.Organization;

public class OrganizationMapper {
    public static OrganizationDto mapToOrganizationDto(Organization organization){

        OrganizationDto organizationDto = new OrganizationDto(
            organization.getId(),
            organization.getOrganizationName(),
            organization.getOrganizationdescription(),
            organization.getOrganizationCode(),
            organization.getCreateDate()
        );
        return organizationDto;
    }

    public static Organization mapToOrganization(OrganizationDto organizationDto){
        Organization organization = new Organization(
            organizationDto.getId(),
            organizationDto.getOrganizationName(),
            organizationDto.getOrganizationdescription(),
            organizationDto.getOrganizationCode(),
            organizationDto.getCreateDate()
        );
        return organization;

    }
}
