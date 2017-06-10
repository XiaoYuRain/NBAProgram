package nba.association;

import java.util.List;

import nba.model.Arena;
import nba.model.ArenaTeam;
import nba.model.Coach;
import nba.model.CoachTeam;
import nba.model.Location;
import nba.model.Player;
import nba.model.Season;
import nba.model.Team;
import nba.util.NBAComparator;

public class AssociationManager {

  public void setPlayerToSeasonAssociations(List<Player> players, List<Season> seasons) {
    NBAComparator<Player> playerComparator = new NBAComparator<Player>("getBirthAndName");
    players.sort(playerComparator);

    NBAComparator<Season> seasonComparator = new NBAComparator<Season>("getPlayerBirthAndName");
    seasons.sort(seasonComparator);

    int playersSize = players.size();
    int seasonsSize = seasons.size();
    int index = 0;
    Player player;
    for (int i = 0; i < playersSize; ++i) {
      player = players.get(i);
      player.getSeasons().clear();
      while (index < seasonsSize
          && seasons.get(index).getPlayerBirthAndName().compareTo(player.getBirthAndName()) < 0)
        ++index;
      while (index < seasonsSize
          && seasons.get(index).getPlayerBirthAndName().equals(player.getBirthAndName())) {
        player.getSeasons().add(seasons.get(index));
        ++index;
      }
    }
  }

  public void setTeamToSeasonAssociations(List<Team> teams, List<Season> seasons) {
    NBAComparator<Team> teamComparator = new NBAComparator<Team>("getAbbr");
    teams.sort(teamComparator);

    NBAComparator<Season> seasonComparator = new NBAComparator<Season>("getTeamAbbr");
    seasons.sort(seasonComparator);

    int teamsSize = teams.size();
    int seasonsSize = seasons.size();
    int index = 0;
    Team team;
    for (int i = 0; i < teamsSize; ++i) {
      team = teams.get(i);
      team.getSeasons().clear();
      while (index < seasonsSize && seasons.get(index).getTeamAbbr().compareTo(team.getAbbr()) < 0)
        ++index;
      while (index < seasonsSize && seasons.get(index).getTeamAbbr().equals(team.getAbbr())) {
        team.getSeasons().add(seasons.get(index));
        ++index;
      }
    }
  }

  public void setCoachToTeamAssociations(List<Coach> coachs, List<CoachTeam> coachTeams) {
    NBAComparator<Coach> coachComparator = new NBAComparator<Coach>("getName");
    coachs.sort(coachComparator);

    NBAComparator<CoachTeam> coachTeamComparator = new NBAComparator<CoachTeam>("getCoachName");
    coachTeams.sort(coachTeamComparator);

    int coachsSize = coachs.size();
    int coachTeamsSize = coachTeams.size();
    int index = 0;
    Coach coach;
    for (int i = 0; i < coachsSize; ++i) {
      coach = coachs.get(i);
      coach.getCoachTeams().clear();
      while (index < coachTeamsSize
          && coachTeams.get(index).getCoachName().compareTo(coach.getName()) < 0)
        ++index;
      while (index < coachTeamsSize && coachTeams.get(index).getCoachName().equals(coach.getName())) {
        coach.getCoachTeams().add(coachTeams.get(index));
        ++index;
      }
    }
  }

  public void setTeamToCoachAssociations(List<Team> teams, List<CoachTeam> coachTeams) {
    NBAComparator<Team> teamComparator = new NBAComparator<Team>("getName");
    teams.sort(teamComparator);

    NBAComparator<CoachTeam> seasonComparator = new NBAComparator<CoachTeam>("getTeamName");
    coachTeams.sort(seasonComparator);

    int teamsSize = teams.size();
    int coachTeamsSize = coachTeams.size();
    int index = 0;
    Team team;
    for (int i = 0; i < teamsSize; ++i) {
      team = teams.get(i);
      team.getCoachTeams().clear();
      while (index < coachTeamsSize
          && coachTeams.get(index).getTeamName().compareTo(team.getName()) < 0)
        ++index;
      while (index < coachTeamsSize && coachTeams.get(index).getTeamName().equals(team.getName())) {
        team.getCoachTeams().add(coachTeams.get(index));
        ++index;
      }
    }
  }

  public void setArenaToLocationAssociations(List<Arena> arenas, List<Location> locations) {
    NBAComparator<Arena> arenaComparator = new NBAComparator<Arena>("getName");
    arenas.sort(arenaComparator);

    NBAComparator<Location> locationComparator = new NBAComparator<Location>("getArenaName");
    locations.sort(locationComparator);

    int arenasSize = arenas.size();
    int locationsSize = locations.size();
    int index = 0;
    Arena arena;
    for (int i = 0; i < arenasSize; ++i) {
      arena = arenas.get(i);
      arena.getLocations().clear();
      while (index < locationsSize
          && locations.get(index).getArenaName().compareTo(arena.getName()) < 0)
        ++index;
      while (index < locationsSize && locations.get(index).getArenaName().equals(arena.getName())) {
        arena.getLocations().add(locations.get(index));
        ++index;
      }
    }
  }

  public void setArenaToTeamAssociations(List<Arena> arenas, List<ArenaTeam> arenaTeams) {
    NBAComparator<Arena> arenaComparator = new NBAComparator<Arena>("getName");
    arenas.sort(arenaComparator);

    NBAComparator<ArenaTeam> arenaTeamComparator = new NBAComparator<ArenaTeam>("getArenaName");
    arenaTeams.sort(arenaTeamComparator);

    int arenasSize = arenas.size();
    int arenaTeamsSize = arenaTeams.size();
    int index = 0;
    Arena arena;
    for (int i = 0; i < arenasSize; ++i) {
      arena = arenas.get(i);
      arena.getLocations().clear();
      while (index < arenaTeamsSize
          && arenaTeams.get(index).getArenaName().compareTo(arena.getName()) < 0)
        ++index;
      while (index < arenaTeamsSize && arenaTeams.get(index).getArenaName().equals(arena.getName())) {
        arena.getArenaTeams().add(arenaTeams.get(index));
        ++index;
      }
    }
  }

  public void setTeamToArenaAssociations(List<Team> teams, List<ArenaTeam> arenaTeams) {
    NBAComparator<Team> teamComparator = new NBAComparator<Team>("getName");
    teams.sort(teamComparator);

    NBAComparator<ArenaTeam> arenaTeamComparator = new NBAComparator<ArenaTeam>("getTeamName");
    arenaTeams.sort(arenaTeamComparator);

    int teamsSize = teams.size();
    int arenaTeamsSize = arenaTeams.size();
    int index = 0;
    Team team;
    for (int i = 0; i < teamsSize; ++i) {
      team = teams.get(i);
      while (index < arenaTeamsSize
          && arenaTeams.get(index).getTeamName().compareTo(team.getName()) < 0)
        ++index;
      while (index < arenaTeamsSize && arenaTeams.get(index).getTeamName().equals(team.getName())) {
        team.getArenaTeams().add(arenaTeams.get(index));
        ++index;
      }
    }
  }

}
