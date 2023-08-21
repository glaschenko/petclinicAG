package com.ag.petclinicAG.entities.visit;

import com.ag.petclinicAG.entities.Pet;
import com.ag.petclinicAG.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "visit")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "visit_type")
    private VisitType visitType;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "assigned_nurse_id")
    private User assignedNurse;

    @Column(name = "visit_start")
    private LocalDate visitStart;

    @Column(name = "visit_end")
    private LocalDate visitEnd;

    @Enumerated(EnumType.STRING)
    @Column(name = "treatment_status")
    private VisitTreatmentStatus treatmentStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

}