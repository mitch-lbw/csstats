package de.csstats.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import de.csstats.dao.Game;
import de.csstats.dao.Kill;
import de.csstats.dao.Map;
import de.csstats.dao.MapDE;
import de.csstats.dao.Player;
import de.csstats.dao.PlayerCT;
import de.csstats.dao.PlayerT;
import de.csstats.dao.Round;
import de.csstats.dao.Weapon;
import de.csstats.dao.repository.GameRepository;
import de.csstats.dao.repository.MapRepository;
import de.csstats.dao.repository.PlayerRepository;
import de.csstats.dao.repository.WeaponRepository;
import de.csstats.service.parser.ParsingContext;

@Component
public class ContextRefreshListener {

	public static final Logger log = LoggerFactory.getLogger(ContextRefreshListener.class);

	@Value("${global.init}")
	private boolean doInit;

	@Autowired
	private WeaponRepository weaponRepository;

	@Autowired
	private MapRepository mapRepository;

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private ParserService parserService;

	@EventListener(ContextRefreshedEvent.class)
	public void initialize() {
		if (doInit) {
			try {
				Files.list(Paths.get(this.getClass().getResource("/gifs").toURI())).forEach((s) -> {
					Weapon w = new Weapon();
					String name = s.getFileName().toString().substring(0, s.getFileName().toString().indexOf("."));
					w.setName(name);
					weaponRepository.save(w);
				});
			} catch (URISyntaxException | IOException e) {
				log.error(e.getMessage());
			}

			Player p1 = new PlayerCT();
			p1.setName("Bot A");
			Player p2 = new PlayerT();
			p2.setName("Bot B");
			playerRepository.save(p1);
			playerRepository.save(p2);

			Map sampleMap = new MapDE();
			sampleMap.setName("dust");

			Game game1 = new Game();
			game1.setStartTimestamp(new Date());
			game1.setMap(sampleMap);

			Set<Round> rounds = new HashSet<>();
			Round re = new Round();
			re.setRoundNum(1);
			re.setGame(game1);
			Round re2 = new Round();
			re2.setRoundNum(2);
			re2.setGame(game1);
			rounds.add(re);
			rounds.add(re2);

			Set<Kill> kills = new HashSet<>();
			Kill k1 = new Kill();
			k1.setKiller(p1);
			k1.setVictim(p2);
			k1.setWeapon(weaponRepository.findOne(1));
			k1.setRound(re);
			Kill k2 = new Kill();
			k2.setKiller(p1);
			k2.setVictim(p2);
			k2.setWeapon(weaponRepository.findOne(2));
			k2.setRound(re2);
			kills.add(k1);
			kills.add(k2);
			re.setKills(kills);

			game1.setRounds(rounds);

			Set<Game> games = new HashSet<>();
			games.add(game1);
			sampleMap.setGames(games);

			this.mapRepository.save(sampleMap);
			log.warn("added map " + this.mapRepository.findOne(1).getName());
			game1.setEndTimestamp(new Date());
			this.gameRepository.save(game1);

			this.parserService.parseMapBlock(new ParsingContext(), "D:\\HL\\cstrike\\logs\\L0906011.log");
		}
	}
}
