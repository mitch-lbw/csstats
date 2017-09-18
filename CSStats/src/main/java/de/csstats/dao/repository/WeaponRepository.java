package de.csstats.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.csstats.dao.Weapon;

public interface WeaponRepository extends JpaRepository<Weapon, Integer> {

}
