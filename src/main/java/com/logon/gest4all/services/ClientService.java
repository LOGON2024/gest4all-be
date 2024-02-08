package com.logon.gest4all.services;

import com.logon.gest4all.entities.CollectivePerson;
import com.logon.gest4all.entities.SingularPerson;
import com.logon.gest4all.entities.enums.ClientState;
import com.logon.gest4all.entities.enums.DeletedState;
import com.logon.gest4all.repositories.CollectivePersonRepository;
import com.logon.gest4all.repositories.SingularPersonRepository;
import com.logon.gest4all.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private SingularPersonRepository singularPersonRepository;
    @Autowired
    private CollectivePersonRepository collectivePersonRepository;
    public List<SingularPerson> findAllSingularPerson() {
        return singularPersonRepository.findAll();
    }

    public List<CollectivePerson> findAllCollectivePerson() {
        return collectivePersonRepository.findAll();
    }

    public SingularPerson findSingularPersonById(Long id) {
        Optional<SingularPerson> obj = singularPersonRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public CollectivePerson findCollectivePersonById(Long id) {
        Optional<CollectivePerson> obj = collectivePersonRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public SingularPerson createSingularPerson(SingularPerson obj) {
        findSingularPersonById(obj.getId());

        SingularPerson singularPerson = SingularPerson.builder()
                .id(obj.getId())
                .name(obj.getName())
                .nif(obj.getNif())
                .placeOfBirth(obj.getPlaceOfBirth())
                .address(obj.getAddress())
                .contact(obj.getContact())
                .start(LocalDateTime.now())
                .deletedState(DeletedState.ACTIVE)
                .maritalStatus(obj.getMaritalStatus())
                .clientState(ClientState.CLIENT)
                .build();

        return singularPersonRepository.save(singularPerson);
    }

    public CollectivePerson createCollectivePerson(CollectivePerson obj) {
        findCollectivePersonById(obj.getId());

        CollectivePerson collectivePerson = CollectivePerson.builder()
                .id(obj.getId())
                .name(obj.getName())
                .nipc(obj.getNipc())
                .address(obj.getAddress())
                .contact(obj.getContact())
                .start(LocalDateTime.now())
                .commercialPermanentCertificateCode(obj.getCommercialPermanentCertificateCode())
                .legalRepresentative(obj.getLegalRepresentative())
                .deletedState(DeletedState.ACTIVE)
                .build();

        return collectivePersonRepository.save(collectivePerson);
    }

    public void deleteSingularPerson(Long id) {
        SingularPerson singularPerson = findSingularPersonById(id);
        singularPerson.setDeletedState(DeletedState.DELETED);
        singularPersonRepository.save(singularPerson);
    }

    public void deleteCollectivePerson(Long id) {
        CollectivePerson collectivePerson = findCollectivePersonById(id);
        collectivePerson.setDeletedState(DeletedState.DELETED);
        collectivePersonRepository.save(collectivePerson);
    }

    public SingularPerson updateSingularPerson(Long id, SingularPerson obj) {
        SingularPerson singularPerson = findSingularPersonById(id);
        toUpdateSingularPerson(singularPerson, obj);
        return singularPersonRepository.save(singularPerson);
    }

    public CollectivePerson updateCollectivePerson(Long id, CollectivePerson obj) {
        CollectivePerson collectivePerson = findCollectivePersonById(id);
        toUpdateCollectivePerson(collectivePerson, obj);
        return collectivePersonRepository.save(collectivePerson);
    }

    private void toUpdateSingularPerson(SingularPerson existingSingularPerson, SingularPerson updateSingularPerson) {
        existingSingularPerson.setName(updateSingularPerson.getName());
        existingSingularPerson.setNif(updateSingularPerson.getNif());
        existingSingularPerson.setPlaceOfBirth(updateSingularPerson.getPlaceOfBirth());
        existingSingularPerson.setAddress(updateSingularPerson.getAddress());
        existingSingularPerson.setContact(updateSingularPerson.getContact());
        existingSingularPerson.setMaritalStatus(updateSingularPerson.getMaritalStatus());
    }

    private void toUpdateCollectivePerson(CollectivePerson existingCollectivePerson, CollectivePerson updateCollectivePerson) {
        existingCollectivePerson.setName(updateCollectivePerson.getName());
        existingCollectivePerson.setNipc(updateCollectivePerson.getNipc());
        existingCollectivePerson.setCommercialPermanentCertificateCode(updateCollectivePerson.getCommercialPermanentCertificateCode());
        existingCollectivePerson.setAddress(updateCollectivePerson.getAddress());
        existingCollectivePerson.setContact(updateCollectivePerson.getContact());
        existingCollectivePerson.setLegalRepresentative(updateCollectivePerson.getLegalRepresentative());
    }

}
