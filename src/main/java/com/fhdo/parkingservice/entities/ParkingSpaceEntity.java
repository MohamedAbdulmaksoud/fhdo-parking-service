package com.fhdo.parkingservice.entities;

import com.fhdo.parkingservice.model.ParkingSpotType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parking_space", schema = "shared", uniqueConstraints={@UniqueConstraint(columnNames = {"parking_id", "internal_id"})})
public class ParkingSpaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID parkingSpaceId;

    @Column(name = "parking_id", nullable = false, updatable = false, insertable = false)
    private UUID parkingId;

    @ManyToOne
    @JoinColumn(name = "parking_id", nullable = false, updatable = false)
    private ParkingLotEntity parkingSpace;

    @Column(name = "internal_id")
    private Integer internalId;

    private Boolean isReserved;

    private Boolean isOccupied;

    @Enumerated(EnumType.STRING)
    private ParkingSpotType parkingSpotType;

}
