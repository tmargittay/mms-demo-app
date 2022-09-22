package com.tsystems.mms.demoapp.user.service;

import com.tsystems.mms.demoapp.user.domain.OrganisationalUnit;
import com.tsystems.mms.demoapp.user.domain.User;
import com.tsystems.mms.demoapp.user.dto.UnitCreateCommand;
import com.tsystems.mms.demoapp.user.dto.UnitInstanceItem;
import com.tsystems.mms.demoapp.user.dto.UnitModifyCommand;
import com.tsystems.mms.demoapp.user.repository.OrganisationalUnitRepository;
import com.tsystems.mms.demoapp.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UnitService {

    private final UserRepository userRepository;
    private final OrganisationalUnitRepository unitRepository;

    public UnitService(UserRepository userRepository, OrganisationalUnitRepository unitRepository) {
        this.userRepository = userRepository;
        this.unitRepository = unitRepository;
    }

    public List<UnitInstanceItem> getAllUnits() {
        return unitRepository.findAll().stream().map(UnitInstanceItem::new).collect(Collectors.toList());
    }

    public UnitInstanceItem getUnitById(Long id) {
        OrganisationalUnit unit = unitRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new UnitInstanceItem(unit);
    }

    public UnitInstanceItem createUnit(UnitCreateCommand command) {
        OrganisationalUnit unit = new OrganisationalUnit(command.getName());
        return new UnitInstanceItem(unitRepository.save(unit));
    }

    public UnitInstanceItem modifyUnit(UnitModifyCommand command) {
        OrganisationalUnit unit = unitRepository.findById(command.getUnitId()).orElseThrow(EntityNotFoundException::new);
        if (command.getName() != null) {
            unit.setName(command.getName());
        }
        return new UnitInstanceItem(unit);
    }

    public void deleteUnitById(Long id) {
        OrganisationalUnit unit = unitRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        for (User user : unit.getUsers()) {
            user.setUnit(null);
        }
        unitRepository.delete(unit);
    }
}
