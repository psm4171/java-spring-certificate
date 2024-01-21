package com.nhnacademy.springjpa.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

@Builder
@Entity
@Table(name = "household")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Household {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "household_serial_number")
    private Long householdSerialNumber;

    @ManyToOne
    @JoinColumn(name = "household_resident_serial_number")
    private Resident houseHoldResidentSerialNumber;

    @Column(name = "household_composition_date")
    private LocalDateTime houseHoldCompositionDate;

    @Column(name = "household_composition_reason_code")
    private String householdCompositionReasonCode;

    @Column(name = "current_house_movement_address")
    private String currentHouseMovementAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "household", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<HouseholdCompositionResident> householdCompositionResidents;

    @JsonIgnore
    @OneToMany(mappedBy = "household", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<HouseHoldMovementAddress> houseHoldMovementAddresses;

}
