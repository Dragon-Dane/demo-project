package com.bio.demo.Controller;

import com.bio.demo.DataClass.ResponseObject;
import com.bio.demo.Service.PatientService;
import com.bio.demo.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.UUID;

@RestController
@RequestMapping("patients")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PatientController {
    private final PatientService patientService;

    @GetMapping
    public ResponseObject getAllPatient() {
        return patientService.getAllPatient();
    }

    @GetMapping("{id}")
    public ResponseObject getPatient(@PathVariable UUID id) {
        return patientService.getPatient(id);
    }

    @PostMapping
    public ResponseObject addPatient(@RequestBody @Valid Patient patient){
        return patientService.addPatient(patient);
    }

    @PutMapping("{id}")
    public ResponseObject updatePatient(@RequestBody @Valid Patient patient, @PathVariable UUID id) {
        return patientService.updatePatient(patient, id);
    }

    @DeleteMapping("{id}")
    public ResponseObject deletePatient(@PathVariable UUID id){
        return patientService.deletePatient(id);
    }

    @GetMapping("/report")
    public ResponseObject getReport() {
        return patientService.getReport();
    }

    @GetMapping("/search")
    public ResponseObject getFilteredPatient(@RequestParam(name = "startDate")String startDate, @RequestParam(name = "endDate") String endDate) throws ParseException {
        return patientService.getFilteredPatient(startDate, endDate);
    }
}
