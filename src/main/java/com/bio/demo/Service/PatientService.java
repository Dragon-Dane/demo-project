package com.bio.demo.Service;

import com.bio.demo.DataClass.ResponseObject;
import com.bio.demo.Execptions.ServiceExceptionHolder;
import com.bio.demo.Repository.PatientRepository;
import com.bio.demo.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PatientService {

    private final PatientRepository patientRepository;
    private final ApiResponseService apiResponseService;

    public ResponseObject getAllPatient() {
        return apiResponseService.sendListResponse("Patient", patientRepository.findAll());
    }

    public ResponseObject addPatient(@Valid Patient patient) {
        return apiResponseService.sendCreateResponse("Patient", patientRepository.save(patient));
    }

    public ResponseObject updatePatient(@Valid Patient patient, UUID id) {
        patient.setId(id);
        return apiResponseService.sendUpdateResponse("Patient", patientRepository.save(patient));
    }

    public ResponseObject deletePatient(UUID id) {
        Patient patient = patientRepository.findById(id).orElseThrow(()-> new ServiceExceptionHolder.EntityNotFoundException("Patient", id));
        patientRepository.delete(patient);
        return apiResponseService.sendDeleteResponse("Patient", patient);
    }

    public ResponseObject getPatient(UUID id) {
        Patient patient = patientRepository.findById(id).orElseThrow(()-> new ServiceExceptionHolder.EntityNotFoundException("Patient", id));
        return apiResponseService.sendDeleteResponse("Patient", patient);
    }
}
