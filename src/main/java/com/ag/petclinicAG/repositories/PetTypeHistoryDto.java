package com.ag.petclinicAG.repositories;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.history.RevisionMetadata;


import java.util.Date;
@EqualsAndHashCode(callSuper = true)
@Data
public class PetTypeHistoryDto extends PetTypeDto {
    private RevisionMetadata.RevisionType revisionType;
    private Date revisionTimestamp;
    private String username;
}
