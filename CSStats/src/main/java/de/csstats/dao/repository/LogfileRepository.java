package de.csstats.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import de.csstats.dao.Logfile;

public interface LogfileRepository extends JpaRepository<Logfile, Integer> {

	@Query
	public boolean existsByHash(final int hash);

	@Query
	public Logfile findByFilename(final String filename);

}
