package com.systelab.envers.revision.service;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RevisionService {

    private final AuditReader auditReader;

    @Autowired
    public RevisionService(AuditReader auditReader) {
        this.auditReader = auditReader;
    }

    public List<?> getRevisionsById(UUID id, boolean fetchChanges, Class<?> revisionEntityClass) {
        AuditQuery auditQuery;

        if (fetchChanges) {
            auditQuery = auditReader.createQuery()
                    .forRevisionsOfEntityWithChanges(revisionEntityClass, true);
        } else {
            auditQuery = auditReader.createQuery()
                    .forRevisionsOfEntity(revisionEntityClass, false,  true);
        }
        auditQuery.add(AuditEntity.id().eq(id));
        return auditQuery.getResultList();
    }

    public List<?> getRevisionsByUser(UUID userId, boolean fetchChanges, Class<?> revisionEntityClass) {
        AuditQuery auditQuery;

        if (fetchChanges) {
            auditQuery = auditReader.createQuery()
                    .forRevisionsOfEntityWithChanges(revisionEntityClass, true);
        } else {
            auditQuery = auditReader.createQuery()
                    .forRevisionsOfEntity(revisionEntityClass, false,  true);
        }
        auditQuery.add(AuditEntity.revisionProperty("username").eq("admin"));
        return auditQuery.getResultList();
    }

    public List<?> getRevisionsByUserByDate(boolean fetchChanges, Class<?> revisionEntityClass, long dateFrom) {
        AuditQuery auditQuery;

        if (fetchChanges) {
            auditQuery = auditReader.createQuery()
                    .forRevisionsOfEntityWithChanges(revisionEntityClass, true);
        } else {
            auditQuery = auditReader.createQuery()
                    .forRevisionsOfEntity(revisionEntityClass, false,  true);
        }
        long now = new Timestamp(System.currentTimeMillis()).getTime();
        auditQuery.add(AuditEntity.revisionProperty("timestamp").between(dateFrom, now));

        return auditQuery.getResultList();
    }
}
