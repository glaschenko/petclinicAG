package com.ag.petclinicAG.entities.envers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Getter
@Setter
@Entity
@Table(name = "revinfo")
@RevisionEntity(UserRevisionListener.class)
public class AuditEnversInfo extends DefaultRevisionEntity {
    @Column(name = "username")
    private String username;

}