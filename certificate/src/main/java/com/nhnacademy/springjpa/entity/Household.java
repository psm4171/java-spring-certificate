package com.nhnacademy.springjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "family_relationship")
@NoArgsConstructor
@Getter
@Setter
public class FamilyRelationship {

    @Id
    @Column(name = "base_resident_serial_number")
    private long baseResidentSerialNumer;

    @Column(name = "household_resident_serial_number")
    private long houseHoldResidentSerialNumber;

    @Column(name = "household_composition_date")
    private Data houseHoldCompositionDate;

    @Column(name = "household_composition_reason_code")
    private long baseResidentSerialNumer;

    @Column(name = "current_house_movement_address")
    private long curre;






}
