package com.ag.petclinicAG.entities.envers;

import org.hibernate.envers.RevisionListener;

public class UserRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object revisionEntity) {
        AuditEnversInfo customRevisionEntity = (AuditEnversInfo) revisionEntity;
        customRevisionEntity.setUsername("Andrey");
    }
}