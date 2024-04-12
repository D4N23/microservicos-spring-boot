package com.organizationservice.organizationservice.services.Impl;

import org.springframework.stereotype.Service;

import com.organizationservice.organizationservice.dto.OrganizationDto;
import com.organizationservice.organizationservice.entity.Organization;
import com.organizationservice.organizationservice.mapper.OrganizationMapper;
import com.organizationservice.organizationservice.repository.OrganizationRepository;
import com.organizationservice.organizationservice.services.OrganizationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
       Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
       return OrganizationMapper.mapToOrganizationDto(organization);
    }

}
