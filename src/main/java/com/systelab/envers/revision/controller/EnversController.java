package com.systelab.envers.revision.controller;

import com.systelab.envers.revision.service.RevisionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Tag(name = "Envers utilities")
@RestController
@RequestMapping(value = "/envers/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class EnversController {

    private final RevisionService revisionService;

    @Autowired
    public EnversController(RevisionService revisionService) {
        this.revisionService = revisionService;
    }


    @GetMapping("hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("Hello from the library");
    }

    @Operation(description = "Get Patient revisions by ID")
    @SecurityRequirement(name = "Authorization")
    @GetMapping(path = "patients/{uid}/revisions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPatientRevisionsById(@PathVariable(name = "uid") UUID id,
                                                     @RequestParam(value = "fetchChanges", required = false) boolean fetchChanges,
                                                     @RequestParam(value = "class") String className) throws ClassNotFoundException {
        return ResponseEntity.ok(revisionService.getRevisionsById(id, fetchChanges, Class.forName(className)));
    }

    @Operation(description = "Get Patient revisions by user")
    @SecurityRequirement(name = "Authorization")
    @GetMapping(path = "users/{userId}/revisions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPatientRevisionsByUser(@PathVariable(name = "userId") UUID userId,
                                                     @RequestParam(value = "fetchChanges", required = false) boolean fetchChanges,
                                                     @RequestParam(value = "class") String className) throws ClassNotFoundException {
        return ResponseEntity.ok(revisionService.getRevisionsByUser(userId, fetchChanges, Class.forName(className)));
    }

    @Operation(description = "Get Patient revisions by date")
    @SecurityRequirement(name = "Authorization")
    @GetMapping(path = "users/revisions/date/{dateFrom}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPatientRevisionsByUserByDates(@PathVariable(name = "dateFrom") long dateFrom,
                                                              @RequestParam(value = "fetchChanges", required = false) boolean fetchChanges,
                                                              @RequestParam(value = "class") String className) throws ClassNotFoundException {
        return ResponseEntity.ok(revisionService.getRevisionsByUserByDate(fetchChanges, Class.forName(className), dateFrom));
    }

    @Operation(description = "Get Entities by revision id")
    @SecurityRequirement(name = "Authorization")
    @GetMapping(path = "entities/{revisionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEntitiesByRevisions(@PathVariable(name = "revisionId") int revisionID) throws ClassNotFoundException {
        return ResponseEntity.ok(revisionService.getModifiedEntityTypes(revisionID));
    }

    @Operation(description = "Get entity names and corresponding Java classes modified in a given revision")
    @SecurityRequirement(name = "Authorization")
    @GetMapping(path = "entities/classes/{revisionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEntitiesClassNameByRevisions(@PathVariable(name = "revisionId") int revisionID) throws ClassNotFoundException {
        return ResponseEntity.ok(revisionService.getModifiedEntityNamesJavaClass(revisionID));
    }

}