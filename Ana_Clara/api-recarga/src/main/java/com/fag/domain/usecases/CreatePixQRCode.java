package com.fag.domain.usecases;

import com.fag.domain.dto.PixDTO;
import com.fag.domain.entities.PixBO;
import com.fag.domain.mappers.PixMapper;
import com.fag.domain.repositories.IPixDatabaseRepository;
import com.fag.domain.repositories.IPixVendor;

public class CreatePixQRCode {
  private IPixVendor vendor;
  private IPixDatabaseRepository repository;

  public CreatePixQRCode(IPixVendor vendor, IPixDatabaseRepository repository) {
    this.vendor = vendor;
    this.repository = repository;
  }

  public PixDTO execute(PixDTO dto) {
    PixDTO response = vendor.create(dto);
    
     PixBO bo = PixMapper.toBO(response);

    repository.persist(bo);

    return response;
  }
}
