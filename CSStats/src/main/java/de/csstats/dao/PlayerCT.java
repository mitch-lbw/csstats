package de.csstats.dao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CT")
public class PlayerCT extends Player {

}
