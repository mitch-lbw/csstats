package de.csstats.service.parser.impl;

import org.springframework.util.StringUtils;

import de.csstats.common.exception.ParsingException;
import de.csstats.dao.Map.MAP_TYPE;
import de.csstats.service.parser.AbstractParser;
import de.csstats.service.parser.ParsingContext;

public abstract class MapParser extends AbstractParser {

	protected abstract String getKeyword();

	public void parse(final ParsingContext context, final String line) throws ParsingException {
		if (lineContainsKeyword(line)) {
			String[] mapNameSplitter = line.split(OBJECT_DELIMITER);
			if (mapNameSplitter.length > 2) {
				String mapName = mapNameSplitter[1];
				MAP_TYPE mapType = MAP_TYPE.DE;
				if (mapName.startsWith("cs")) {
					mapType = MAP_TYPE.CS;
				}
				context.setMap(mapName, mapType);
			}
		}
		// für alle zeilen
		/**
		 * 1 checke ob runde beginnt oder endet --> zeit an runde melden 2
		 * checke ob neuer spieler bzw. seite gewechselt --> damit über alle
		 * Spieler laufen und schauen ob schon vorhanden, wenn ja -->
		 * seitenwechsel übernehmen und zeit für die vorherige seite aufaddieren
		 * 3 checken ob name gewechselt --> falls ja neuen Namen in den
		 * aktuellen Spieler eintragen 4 Frags checken und Spieler aktualisieren
		 * 5 Suicide testen werte aktualisieren 6 Kick / Playerquit testen
		 * zeiten aktualisieren 7 Hostage / VIP / Bomb event checken 8 Round
		 * Points
		 */
	}

	@Override
	public boolean lineContainsKeyword(String line) {
		if (StringUtils.hasText(line)) {
			if (line.toUpperCase().matches(getKeyword()) && line.contains(OBJECT_DELIMITER)) {
				return true;
			}
		}
		return false;
	}

	// public static void main(String[] args) throws Exception {
	// String line = "L 02/16/2007 - 21:01:45: Started map \"de_train\" (CRC
	// \"-663702360\")";
	// System.out.println(line.toUpperCase().indexOf(getKeyword()));
	// System.out.println(line.toUpperCase().matches(getKeyword()));
	// line = "L 02/16/2007 - 21:01:45: Loading map \"de_train\" (CRC
	// \"-663702360\")";
	// System.out.println(line.toUpperCase().matches(getKeyword()));
	// System.out.println(line.split("\"")[0]);
	// System.out.println(line.split("\"")[1]);
	// System.out.println(line.substring(line.toUpperCase().indexOf(getKeyword())
	// + getKeyword().length()).trim());
	// BufferedReader br = new BufferedReader(new FileReader(new
	// File("D:/HL/cstrike/logs/L0906008.log")));
	// line = br.readLine();
	// System.out.println(line.toUpperCase().matches(getKeyword()));
	// }
}
